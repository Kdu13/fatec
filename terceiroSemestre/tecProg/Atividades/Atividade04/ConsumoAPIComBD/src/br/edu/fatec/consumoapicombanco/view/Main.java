package br.edu.fatec.consumoapicombanco.view;

import br.edu.fatec.consumoapicombanco.bd.FavoritoDAO;
import br.edu.fatec.consumoapicombanco.model.Favorito;
import br.edu.fatec.consumoapicombanco.model.Pokemon;
import br.edu.fatec.consumoapicombanco.model.PokemonDetalhe;
import br.edu.fatec.consumoapicombanco.model.PokemonListResponse;
import br.edu.fatec.consumoapicombanco.service.PokeApiService;

import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static PokeApiService service = new PokeApiService();
    static FavoritoDAO dao = new FavoritoDAO();

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro();
            switch (opcao) {
                case 1 -> listarPokemons();
                case 2 -> cadastrarFavorito();
                case 3 -> exibirDetalhesFavorito();
                case 4 -> excluirFavorito();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    static void exibirMenu() {
        System.out.println("\n=== POKÉDEX ===");
        System.out.println("1 - Listar Pokémons (API)");
        System.out.println("2 - Cadastrar Favorito");
        System.out.println("3 - Exibir Favorito com detalhes");
        System.out.println("4 - Excluir Favorito");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    static void listarPokemons() {
        int offset = 0, limit = 20;
        String comando;
        do {
            PokemonListResponse resp = service.listarPokemons(limit, offset);
            System.out.println("\n--- Pokémons (" + (offset + 1) + " a " + (offset + limit) + " de " + resp.getCount() + ") ---");
            int i = 1;
            for (Pokemon p : resp.getResults()) {
                System.out.println((offset + i) + ". " + p.getName());
                i++;
            }
            System.out.print("\n[N] próxima página | [P] anterior | [S] sair da listagem: ");
            comando = scanner.next().trim().toUpperCase();
            if (comando.equals("N") && resp.getNext() != null) offset += limit;
            else if (comando.equals("P") && offset - limit >= 0) offset -= limit;
        } while (!comando.equals("S"));
    }

    static void cadastrarFavorito() {
        System.out.print("Digite o nome do Pokémon (ex: pikachu): ");
        String nome = scanner.next().trim().toLowerCase();
        try {
            PokemonDetalhe detalhe = service.buscarDetalhes(nome);
            String url = "https://pokeapi.co/api/v2/pokemon/" + detalhe.getId() + "/";
            dao.inserir(new Favorito(detalhe.getName(), url));
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    static void exibirDetalhesFavorito() {
        List<Favorito> favoritos = dao.listar();
        if (favoritos.isEmpty()) { System.out.println("Nenhum favorito cadastrado."); return; }

        System.out.println("\n--- Favoritos ---");
        for (Favorito f : favoritos) System.out.println(f.getId() + " - " + f.getNome());

        System.out.print("Digite o ID do favorito para ver detalhes: ");
        int id = lerInteiro();

        Favorito favorito = favoritos.stream().filter(f -> f.getId() == id).findFirst().orElse(null);
        if (favorito == null) { System.out.println("Favorito não encontrado."); return; }

        PokemonDetalhe detalhe = service.buscarDetalhes(favorito.getUrl());
        System.out.println("\n=== " + detalhe.getName().toUpperCase() + " ===");
        System.out.println("Altura: " + detalhe.getHeight() + " dm");
        System.out.println("Peso: " + detalhe.getWeight() + " hg");
        System.out.println("Experiência base: " + detalhe.getBaseExperience());
        System.out.println("Tipos: " + detalhe.getTiposFormatados());
        System.out.println("Habilidades: " + detalhe.getHabilidadesFormatadas());
    }

    static void excluirFavorito() {
        List<Favorito> favoritos = dao.listar();
        if (favoritos.isEmpty()) { System.out.println("Nenhum favorito cadastrado."); return; }

        System.out.println("\n--- Favoritos ---");
        for (Favorito f : favoritos) System.out.println(f.getId() + " - " + f.getNome());

        System.out.print("Digite o ID a excluir: ");
        dao.excluir(lerInteiro());
    }

    static int lerInteiro() {
        while (!scanner.hasNextInt()) {
            System.out.print("Digite um número válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}