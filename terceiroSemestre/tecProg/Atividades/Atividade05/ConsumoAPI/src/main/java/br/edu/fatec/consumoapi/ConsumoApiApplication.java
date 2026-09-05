package br.edu.fatec.consumoapi;

import br.edu.fatec.consumoapi.model.Show;
import br.edu.fatec.consumoapi.service.ConsultaService;
import br.edu.fatec.consumoapi.service.ConverteDados;
import br.edu.fatec.consumoapi.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ConsumoApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConsumoApiApplication.class, args);
	}
}

@Component
@RequiredArgsConstructor
class MenuRunner implements CommandLineRunner {

	private final ConsultaService consultaService;
	private final ConverteDados converteDados;
	private final LogService logService;

	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);
		boolean continuar = true;

		System.out.println("=== Consulta de Séries (API TVMaze) ===");

		while (continuar) {
			exibirMenu();
			String opcao = scanner.nextLine().trim();

			switch (opcao) {
				case "1" -> consultar(scanner);
				case "2" -> listar();
				case "3" -> {
					System.out.println("Encerrando o programa. Até logo!");
					continuar = false;
				}
				default -> System.out.println("Opção inválida. Escolha 1, 2 ou 3.");
			}
		}

		scanner.close();
	}

	private void exibirMenu() {
		System.out.println();
		System.out.println("1. Consultar");
		System.out.println("2. Listar");
		System.out.println("3. Sair");
		System.out.print("Escolha uma opção: ");
	}

	private void consultar(Scanner scanner) {
		System.out.print("Digite o nome da série que deseja consultar (ex: Breaking Bad): ");
		String nomeSerie = scanner.nextLine().trim();

		try {
			String json = consultaService.buscarSeriePorNome(nomeSerie);
			Show show = converteDados.obterDados(json, Show.class);

			System.out.println(show.descricaoFormatada());
			logService.registrar(nomeSerie, show.resumo());
		} catch (RuntimeException e) {
			System.out.println("Não foi possível concluir a consulta: " + e.getMessage());
			logService.registrar(nomeSerie, "ERRO - " + e.getMessage());
		}
	}

	private void listar() {
		List<String> historico = logService.listarHistorico();

		if (historico.isEmpty()) {
			System.out.println("Nenhuma consulta registrada até o momento.");
			return;
		}

		System.out.println("=== Histórico de consultas ===");
		historico.forEach(System.out::println);
	}
}