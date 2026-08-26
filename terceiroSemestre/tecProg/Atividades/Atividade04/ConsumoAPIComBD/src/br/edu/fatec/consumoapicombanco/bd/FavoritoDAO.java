package br.edu.fatec.consumoapicombanco.bd;

import br.edu.fatec.consumoapicombanco.model.Favorito;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FavoritoDAO {

    public void inserir(Favorito favorito) {
        String sql = "INSERT INTO favoritos (nome, url) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, favorito.getNome());
            stmt.setString(2, favorito.getUrl());
            stmt.executeUpdate();
            System.out.println("Favorito cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir favorito: " + e.getMessage());
        }
    }

    public List<Favorito> listar() {
        List<Favorito> lista = new ArrayList<>();
        String sql = "SELECT * FROM favoritos ORDER BY id";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new Favorito(rs.getInt("id"), rs.getString("nome"), rs.getString("url")));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar favoritos: " + e.getMessage());
        }
        return lista;
    }

    public void excluir(int id) {
        String sql = "DELETE FROM favoritos WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int linhas = stmt.executeUpdate();
            System.out.println(linhas > 0 ? "Favorito excluído com sucesso!" : "Nenhum favorito encontrado com esse ID.");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir favorito: " + e.getMessage());
        }
    }
}