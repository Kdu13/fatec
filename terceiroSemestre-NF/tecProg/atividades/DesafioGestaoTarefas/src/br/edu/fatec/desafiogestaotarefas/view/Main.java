package br.edu.fatec.desafiogestaotarefas.view;

import br.edu.fatec.desafiogestaotarefas.controller.TarefaController;
import br.edu.fatec.desafiogestaotarefas.model.Tarefa;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TarefaController controller = new TarefaController();

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1 - Criar tarefa");
            System.out.println("2 - Editar tarefa");
            System.out.println("3 - Excluir tarefa");
            System.out.println("4 - Filtrar por Categorias");
            System.out.println("5 - Filtrar por Status");
            System.out.println("6 - Listar todas as tarefas");
            System.out.println("9 - Sair");
            System.out.print("Escolha: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Titulo: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Descricao: ");
                    String descricao = scanner.nextLine();

                    System.out.print("Status (PENDENTE/CONCLUIDA): ");
                    String status = scanner.nextLine().toLowerCase();
                    boolean concluida = status.equals("concluida");

                    System.out.print("Categoria: ");
                    String categoria = scanner.nextLine();

                    Tarefa tarefa = new Tarefa(titulo, descricao, concluida, categoria);
                    controller.create(tarefa);
                    break;

                case 2:
                    System.out.print("ID da tarefa que deseja editar: ");
                    int idEditar = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Novo Titulo: ");
                    String novoTitulo = scanner.nextLine();

                    System.out.print("Nova Descricao: ");
                    String novaDescricao = scanner.nextLine();

                    System.out.print("Novo Status (PENDENTE/CONCLUIDA): ");
                    String novoStatus = scanner.nextLine().toLowerCase();
                    boolean novaConcluida = novoStatus.equals("concluida");

                    System.out.print("Nova Categoria: ");
                    String novaCategoria = scanner.nextLine();

                    Tarefa tarefaAtualizada = new Tarefa(novoTitulo, novaDescricao, novaConcluida, novaCategoria);
                    tarefaAtualizada.setId(idEditar);

                    controller.update(tarefaAtualizada);
                    break;

                case 3:
                    System.out.print("ID da tarefa que deseja excluir: ");
                    int idExcluir = scanner.nextInt();
                    scanner.nextLine();

                    controller.delete(idExcluir);
                    break;

                case 4:
                    System.out.print("Digite a categoria: ");
                    String categoriaFiltro = scanner.nextLine();

                    List<Tarefa> tarefasCategoria = controller.filterByCategory(categoriaFiltro);
                    printTarefas(tarefasCategoria);
                    break;

                case 5:
                    System.out.print("Status (PENDENTE/CONCLUIDA): ");
                    String statusFiltro = scanner.nextLine().toLowerCase();
                    boolean concluidaFiltro = statusFiltro.equals("concluida");

                    List<Tarefa> tarefasStatus = controller.filterByStatus(concluidaFiltro);
                    printTarefas(tarefasStatus);
                    break;

                case 6:
                    List<Tarefa> todas = controller.getAll();
                    printTarefas(todas);
                    break;

                case 9:
                    System.out.println("Encerrando...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    // 🔹 MÉTODO PARA IMPRIMIR TAREFAS
    private static void printTarefas(List<Tarefa> tarefas) {

        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
            return;
        }

        for (Tarefa t : tarefas) {

            String status = t.getConcluida() ? "CONCLUIDA" : "PENDENTE";

            System.out.println("----------------------------");
            System.out.println("ID: " + t.getId());
            System.out.println("Titulo: " + t.getTitulo());
            System.out.println("Descricao: " + t.getDescricao());
            System.out.println("Status: " + status);
            System.out.println("Categoria: " + t.getCategoria());
        }
    }
}