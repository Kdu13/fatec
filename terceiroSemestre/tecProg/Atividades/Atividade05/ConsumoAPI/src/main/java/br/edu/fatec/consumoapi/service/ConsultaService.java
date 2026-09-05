package br.edu.fatec.consumoapi.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@Service
public class ConsultaService {

    private final HttpClient client = HttpClient.newHttpClient();

    public String buscarSeriePorNome(String nomeSerie) {
        String nomeCodificado = URLEncoder.encode(nomeSerie, StandardCharsets.UTF_8);
        String url = "https://api.tvmaze.com/singlesearch/shows?q=" + nomeCodificado;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 404) {
                throw new RuntimeException("Nenhuma série encontrada com esse nome.");
            }
            if (response.statusCode() != 200) {
                throw new RuntimeException("A API retornou o status " + response.statusCode());
            }
            return response.body();
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Erro ao consultar a API TVMaze: " + e.getMessage(), e);
        }
    }
}