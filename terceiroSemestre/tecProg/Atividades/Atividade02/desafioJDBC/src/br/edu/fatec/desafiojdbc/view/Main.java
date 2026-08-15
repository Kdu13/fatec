package br.edu.fatec.desafiojdbc.view;

import br.edu.fatec.desafiojdbc.db.DB;
import br.edu.fatec.desafiojdbc.model.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Connection conn = DB.connection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Conexão realizada com sucesso!");

            boolean executando = true;

            while (executando) {
                mostrarMenu();

                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        inserirCurso(conn, scanner);
                        break;

                    case 2:
                        listarCursos(conn);
                        break;

                    case 3:
                        atualizarCurso(conn, scanner);
                        break;

                    case 4:
                        deletarCurso(conn, scanner);
                        break;

                    case 5:
                        System.out.println("Obrigado por usar o sistema!");
                        executando = false;
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro no banco de dados: " + e.getMessage());
        }
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("===== SISTEMA DE CURSOS =====");
        System.out.println("1 - Inserir curso");
        System.out.println("2 - Listar cursos");
        System.out.println("3 - Atualizar curso");
        System.out.println("4 - Deletar curso");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void inserirCurso(Connection conn, Scanner scanner) throws SQLException {

        System.out.print("Digite o nome do curso: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a descrição do curso: ");
        String descricao = scanner.nextLine();

        System.out.print("Digite a duração do curso em horas: ");
        int duracao = scanner.nextInt();
        scanner.nextLine();

        String sql = "INSERT INTO cursos (nome, descricao, duracao) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, descricao);
            stmt.setInt(3, duracao);
            stmt.executeUpdate();
        }

        System.out.println("Curso inserido com sucesso!");
    }

    private static void listarCursos(Connection conn) throws SQLException {

        List<Curso> cursos = new ArrayList<>();

        String sql = "SELECT id, nome, descricao, duracao FROM cursos ORDER BY id";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Curso curso = new Curso();

                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setDescricao(rs.getString("descricao"));
                curso.setDuracao(rs.getInt("duracao"));

                cursos.add(curso);
            }
        }

        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso cadastrado.");
            return;
        }

        System.out.println();
        System.out.println("===== CURSOS CADASTRADOS =====");

        for (Curso curso : cursos) {
            System.out.println("ID: " + curso.getId());
            System.out.println("Nome: " + curso.getNome());
            System.out.println("Descrição: " + curso.getDescricao());
            System.out.println("Duração: " + curso.getDuracao() + " horas");
            System.out.println("------------------------------");
        }
    }

    private static void atualizarCurso(Connection conn, Scanner scanner) throws SQLException {

        System.out.print("Digite o ID do curso: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o novo nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a nova descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Digite a nova duração em horas: ");
        int duracao = scanner.nextInt();
        scanner.nextLine();

        String sql = "UPDATE cursos SET nome = ?, descricao = ?, duracao = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, descricao);
            stmt.setInt(3, duracao);
            stmt.setInt(4, id);

            int resultado = stmt.executeUpdate();

            if (resultado > 0) {
                System.out.println("Curso atualizado com sucesso!");
            } else {
                System.out.println("Curso não encontrado.");
            }
        }
    }

    private static void deletarCurso(Connection conn, Scanner scanner) throws SQLException {

        System.out.print("Digite o ID do curso: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        String sql = "DELETE FROM cursos WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int resultado = stmt.executeUpdate();

            if (resultado > 0) {
                System.out.println("Curso deletado com sucesso!");
            } else {
                System.out.println("Curso não encontrado.");
            }
        }
    }
}