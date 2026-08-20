package br.edu.fatec.view;

import br.edu.fatec.model.Endereco;
import br.edu.fatec.service.ConsumoAPI;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        List<Endereco> historico = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        boolean executando = true;

        System.out.println("Seja bem-vindo ao app Busca Endereços!");

        while (executando) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Consultar CEP");
            System.out.println("2 - Ver consultados");
            System.out.println("3 - Limpar histórico de consulta");
            System.out.println("9 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("\nDigite o CEP: ");
                    String cep = scan.nextLine();

                    try {
                        String retorno = ConsumoAPI.buscaCep(cep);
                        Endereco endereco = gson.fromJson(retorno, Endereco.class);

                        if (endereco.getCep() == null) {
                            System.out.println("CEP não encontrado.");
                        } else {
                            historico.add(endereco);

                            System.out.println("\n===== ENDEREÇO =====");
                            System.out.println(endereco);
                        }

                    } catch (IOException | InterruptedException e) {
                        System.out.println("Não foi possível consultar o CEP: " + e.getMessage());
                        if (e instanceof InterruptedException) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    break;

                case 2:
                    if (historico.isEmpty()) {
                        System.out.println("\nNenhum CEP foi consultado ainda.");
                    } else {
                        System.out.println("\n===== HISTÓRICO DE CONSULTAS =====");

                        for (Endereco endereco : historico) {
                            System.out.println(endereco);
                            System.out.println("----------------------------");
                        }
                    }
                    break;

                case 3:
                    if (historico.isEmpty()) {
                        System.out.println("\nO histórico já está vazio.");
                    } else {
                        historico.clear();
                        System.out.println("\nHistórico limpo com sucesso!");
                    }
                    break;

                case 9:
                    System.out.println("\nObrigado por usar o sistema!");
                    executando = false;
                    break;

                default:
                    System.out.println("\nOpção inválida!");
                    break;
            }
        }

        scan.close();
    }
}
