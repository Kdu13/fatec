package br.edu.fatecpg.consumoapi.view;

import br.edu.fatecpg.consumoapi.db.DB;
import br.edu.fatecpg.consumoapi.model.Socio;
import br.edu.fatecpg.consumoapi.service.BrasilApi;
import java.io.IOException;
import br.edu.fatecpg.consumoapi.model.Empresa;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();

        boolean validacao = true;
        Scanner scan = new Scanner(System.in);

        System.out.println("Bem-Vindo ao Cadastro de Fornecedores");

        while (validacao) {
            System.out.println("Digite 1 - Para cadastrar uma Empresa: \n" +
                    "Digite 2 - Para excluir uma Empresa: \n" +
                    "Digite 3 - Para listar uma Empresa: \n" +
                    "Digite 9 para sair:");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {

                case 1:
                    System.out.println("Cadastro de Empresa");
                    System.out.println("Digite um cnpj válido:");

                    String cnpjDigitado = scan.nextLine();

                    String cnpjNormalizado = cnpjDigitado
                            .replaceAll("[^A-Z0-9]", "");

                    String sqlVerificaEmpresa =
                            "SELECT id FROM empresa WHERE cnpj = ?";

                    String sqlEmpresa = """
                            INSERT INTO empresa (cnpj, razao_social, nome_fantasia, logradouro)
                            VALUES (?, ?, ?, ?)
                            RETURNING id
                            """;

                    String sqlVerificaSocio = """
                            SELECT 1 FROM socio
                            WHERE cnpj_cpf_do_socio = ? AND empresa_id = ?
                            """;

                    String sqlSocio = """
                            INSERT INTO socio (nome_socio, cnpj_cpf_do_socio, qualificacao_socio, empresa_id)
                            VALUES (?, ?, ?, ?)
                            """;

                    try {
                        String retorno = BrasilApi.buscaEmpresa(cnpjNormalizado);

                        if (retorno.contains("Bad Request") || retorno.contains("message")) {
                            System.out.println("CNPJ inválido.");
                            break;
                        }

                        Empresa emp = gson.fromJson(retorno, Empresa.class);

                        try (Connection conn = DB.connection()) {

                            boolean empresaExiste = false;
                            try (PreparedStatement verificaEmpresa =
                                         conn.prepareStatement(sqlVerificaEmpresa)) {

                                verificaEmpresa.setString(1, emp.getCnpj());
                                var empVerifica = verificaEmpresa.executeQuery();

                                if (empVerifica.next()) {
                                    empresaExiste = true;
                                }
                            }
                            if (empresaExiste) {
                                System.out.println("Empresa já cadastrada!");
                                break;
                            }
                            int empresaId = 0;
                            try (PreparedStatement stmtEmpresa =
                                         conn.prepareStatement(sqlEmpresa)) {

                                stmtEmpresa.setString(1, emp.getCnpj());
                                stmtEmpresa.setString(2, emp.getRazao_social());
                                stmtEmpresa.setString(3, emp.getNome_fantasia());
                                stmtEmpresa.setString(4, emp.getLogradouro());

                                var idEmpresa = stmtEmpresa.executeQuery();
                                if (idEmpresa.next()) {
                                    empresaId = idEmpresa.getInt("id");
                                }

                                System.out.println("Empresa criada com ID: " + empresaId);
                                System.out.println(emp + "\n");
                            }

                            if (emp.getQsa() != null && !emp.getQsa().isEmpty()) {

                                for (Socio socio : emp.getQsa()) {

                                    try (PreparedStatement verificaSocio =
                                                 conn.prepareStatement(sqlVerificaSocio)) {

                                        verificaSocio.setString(1, socio.getCnpj_cpf_do_socio());
                                        verificaSocio.setInt(2, empresaId);
                                        var verifySocio = verificaSocio.executeQuery();

                                        if (verifySocio.next()) {
                                            System.out.println("Sócio já cadastrado: "
                                                    + socio.getNome_socio());
                                            continue;
                                        }
                                    }

                                    try (PreparedStatement stmtSocio =
                                                 conn.prepareStatement(sqlSocio)) {

                                        stmtSocio.setString(1, socio.getNome_socio());
                                        stmtSocio.setString(2, socio.getCnpj_cpf_do_socio());
                                        stmtSocio.setString(3, socio.getQualificacao_socio());
                                        stmtSocio.setInt(4, empresaId);

                                        stmtSocio.executeUpdate();
                                        System.out.println("Sócio inserido: " + socio.getNome_socio());
                                    }
                                }

                                System.out.println("Sócios cadastrados com sucesso!");

                            } else {
                                System.out.println("Nenhum sócio encontrado no QSA desta empresa.");
                            }

                        } catch (Exception e) {
                            System.out.println("Erro ao acessar o banco de dados:");
                            e.printStackTrace();
                        }

                    } catch (IOException | InterruptedException e) {
                        System.out.println("Erro ao buscar CNPJ.");
                    }
                    break;

                case 2:
                    System.out.println("Digite o ID da empresa que deseja remover:");
                    int idExcluir = scan.nextInt();
                    scan.nextLine();

                    String sqlDelete = "DELETE FROM empresa WHERE id = ?";

                    try (Connection conn = DB.connection();
                         PreparedStatement stmt = conn.prepareStatement(sqlDelete)) {

                        stmt.setInt(1, idExcluir);
                        int linhasAfetadas = stmt.executeUpdate();

                        if (linhasAfetadas > 0) {
                            System.out.println("Empresa excluída com sucesso!");
                        } else {
                            System.out.println("Nenhuma empresa encontrada com o ID: " + idExcluir);
                        }

                    } catch (Exception e) {
                        System.out.println("Erro ao excluir empresa:");
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    System.out.println("Digite o CNPJ da empresa que deseja consultar:");

                    String cnpjBusca = scan.nextLine()
                            .replaceAll("[^0-9]", "");

                    String sqlBuscaEmpresa =
                            "SELECT id, cnpj, razao_social, nome_fantasia, logradouro FROM empresa WHERE cnpj = ?";

                    String sqlBuscaSocios =
                            "SELECT id, nome_socio, cnpj_cpf_do_socio, qualificacao_socio FROM socio WHERE empresa_id = ?";

                    try (Connection conn = DB.connection()) {

                        try (PreparedStatement stmtEmpresa = conn.prepareStatement(sqlBuscaEmpresa)) {

                            stmtEmpresa.setString(1, cnpjBusca);
                            ResultSet rsEmpresa = stmtEmpresa.executeQuery();

                            if (!rsEmpresa.next()) {
                                System.out.println("Empresa não encontrada para o CNPJ: " + cnpjBusca);
                            } else {

                                int idEncontrado = rsEmpresa.getInt("id");
                                Empresa empEncontrada = new Empresa(
                                        rsEmpresa.getString("cnpj"),
                                        rsEmpresa.getString("razao_social"),
                                        rsEmpresa.getString("nome_fantasia"),
                                        rsEmpresa.getString("logradouro")
                                );
                                empEncontrada.setId(idEncontrado);

                                ArrayList<Socio> socios = new ArrayList<>();

                                try (PreparedStatement stmtSocios = conn.prepareStatement(sqlBuscaSocios)) {
                                    stmtSocios.setInt(1, idEncontrado);
                                    ResultSet rsSocios = stmtSocios.executeQuery();

                                    while (rsSocios.next()) {
                                        Socio s = new Socio(
                                                rsSocios.getString("nome_socio"),
                                                rsSocios.getString("cnpj_cpf_do_socio"),
                                                rsSocios.getString("qualificacao_socio")
                                        );
                                        s.setId(rsSocios.getInt("id"));
                                        socios.add(s);
                                    }
                                }

                                empEncontrada.setQsa(socios);

                                Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
                                System.out.println(gsonPretty.toJson(empEncontrada));
                            }
                        }

                    } catch (Exception e) {
                        System.out.println("Erro ao consultar empresa:");
                        e.printStackTrace();
                    }
                    break;

                case 9:
                    System.out.println("Saindo!");
                    validacao = false;
                    break;

                default:
                    System.out.println("Essa opção não existe!");
            }
        }
    }
}