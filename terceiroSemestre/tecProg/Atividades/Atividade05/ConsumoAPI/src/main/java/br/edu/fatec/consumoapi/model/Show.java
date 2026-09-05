package br.edu.fatec.consumoapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Show(
        Long id,
        String name,
        String type,
        String language,
        List<String> genres,
        String status,
        String premiered,
        @JsonProperty("officialSite")
        String siteOficial,
        String summary,
        Rating rating,
        Network network
) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Rating(Double average) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Network(String name, Country country) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Country(String name) {}

    public String resumo() {
        return name + " (" + (premiered != null ? premiered.substring(0, 4) : "?") + ") - "
                + (network != null ? network.name() : "rede desconhecida");
    }

    public String descricaoFormatada() {
        String resumoLimpo = summary != null
                ? summary.replaceAll("<[^>]*>", "")
                : "Sem sinopse.";

        return "Nome: " + name
                + " | Tipo: " + type
                + " | Gêneros: " + (genres != null ? String.join(", ", genres) : "-")
                + " | Status: " + status
                + " | Estreou em: " + premiered
                + " | Nota: " + (rating != null && rating.average() != null ? rating.average() : "sem avaliação")
                + " | Rede: " + (network != null ? network.name() : "-")
                + " | Site oficial: " + (siteOficial != null ? siteOficial : "-")
                + "\nSinopse: " + resumoLimpo;
    }
}