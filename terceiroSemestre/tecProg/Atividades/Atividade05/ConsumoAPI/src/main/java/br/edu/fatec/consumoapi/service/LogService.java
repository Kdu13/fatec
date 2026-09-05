package br.edu.fatec.consumoapi.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class LogService {

    private static final String ARQUIVO_LOG = "consultas.log";
    private static final DateTimeFormatter FORMATO_DATA =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss xxx");

    public void registrar(String termoConsultado, String resultado) {
        ZonedDateTime agora = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        String linha = "[" + agora.format(FORMATO_DATA) + "] "
                + "Consulta \"" + termoConsultado + "\" -> " + resultado;

        try (FileWriter escrita = new FileWriter(ARQUIVO_LOG, true)) {
            escrita.write(linha + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao gravar o log da consulta.");
            e.printStackTrace();
        }
    }

    public List<String> listarHistorico() {
        List<String> linhas = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(ARQUIVO_LOG))) {
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Nenhum histórico encontrado ainda (arquivo de log não existe).");
        }
        return linhas;
    }
}