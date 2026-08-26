package br.edu.fatec.consumoapicombanco.service;

import br.edu.fatec.consumoapicombanco.model.PokemonDetalhe;
import br.edu.fatec.consumoapicombanco.model.PokemonListResponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PokeApiService {

    private static final String BASE_URL = "https://pokeapi.co/api/v2/pokemon";
    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    public PokemonListResponse listarPokemons(int limit, int offset) {
        String url = BASE_URL + "?limit=" + limit + "&offset=" + offset;
        return gson.fromJson(fazerRequisicao(url), PokemonListResponse.class);
    }

    public PokemonDetalhe buscarDetalhes(String nomeOuUrl) {
        String url = nomeOuUrl.startsWith("http") ? nomeOuUrl : BASE_URL + "/" + nomeOuUrl.toLowerCase();
        return gson.fromJson(fazerRequisicao(url), PokemonDetalhe.class);
    }

    private String fazerRequisicao(String url) {
        try {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new RuntimeException("Pokémon não encontrado (status " + response.statusCode() + ")");
            }
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao consumir a API: " + e.getMessage(), e);
        }
    }
}