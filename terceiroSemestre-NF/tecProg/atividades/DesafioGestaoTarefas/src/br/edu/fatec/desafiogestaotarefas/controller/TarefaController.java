package br.edu.fatec.desafiogestaotarefas.controller;

import br.edu.fatec.desafiogestaotarefas.db.DB;
import br.edu.fatec.desafiogestaotarefas.model.Tarefa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TarefaController {

    public void create(Tarefa tarefa) {

        String sql = """
                INSERT INTO tarefas (titulo, descricao, concluida, categoria)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection conn = DB.connection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setBoolean(3, tarefa.getConcluida());
            stmt.setString(4, tarefa.getCategoria());

            stmt.executeUpdate();

            System.out.println("Tarefa criada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao criar tarefa:");
        }

    }

    public void update(Tarefa tarefa) {

        String sql = """
            UPDATE tarefas
            SET titulo = ?, descricao = ?, concluida = ?, categoria = ?
            WHERE id = ?
            """;

        try (Connection conn = DB.connection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setBoolean(3, tarefa.getConcluida());
            stmt.setString(4, tarefa.getCategoria());
            stmt.setInt(5, tarefa.getId()); // precisa ter getId()

            stmt.executeUpdate();

            System.out.println("Tarefa atualizada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao atualizar tarefa:");
            e.printStackTrace();
        }
    }

    public void delete(int id) {

        String sql = "DELETE FROM tarefas WHERE id = ?";

        try (Connection conn = DB.connection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Tarefa excluída com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao excluir tarefa:");
            e.printStackTrace();
        }
    }

    public List<Tarefa> getAll() {

        String sql = "SELECT * FROM tarefas";
        List<Tarefa> tarefas = new ArrayList<>();

        try (Connection conn = DB.connection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Tarefa tarefa = new Tarefa(
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        rs.getBoolean("concluida"),
                        rs.getString("categoria")
                );

                tarefa.setId(rs.getInt("id"));

                tarefas.add(tarefa);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar tarefas:");
            e.printStackTrace();
        }

        return tarefas;
    }

    public List<Tarefa> filterByCategory(String categoria) {

        String sql = "SELECT * FROM tarefas WHERE categoria = ?";
        List<Tarefa> tarefas = new ArrayList<>();

        try (Connection conn = DB.connection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Tarefa tarefa = new Tarefa(
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        rs.getBoolean("concluida"),
                        rs.getString("categoria")
                );

                tarefa.setId(rs.getInt("id"));

                tarefas.add(tarefa);
            }

        } catch (Exception e) {
            System.out.println("Erro ao filtrar por categoria:");
            e.printStackTrace();
        }

        return tarefas;
    }

    public List<Tarefa> filterByStatus(boolean concluida) {

        String sql = "SELECT * FROM tarefas WHERE concluida = ?";
        List<Tarefa> tarefas = new ArrayList<>();

        try (Connection conn = DB.connection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setBoolean(1, concluida);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Tarefa tarefa = new Tarefa(
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        rs.getBoolean("concluida"),
                        rs.getString("categoria")
                );

                tarefa.setId(rs.getInt("id"));

                tarefas.add(tarefa);
            }

        } catch (Exception e) {
            System.out.println("Erro ao filtrar por status:");
            e.printStackTrace();
        }

        return tarefas;
    }
}