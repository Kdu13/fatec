package br.edu.fatecpg.rest_countries_pais.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Nome {

    @JsonProperty("common")
    private String nomeComum;

    @JsonProperty("official")
    private String nomeOficial;

    public String getNomeComum() {
        return nomeComum;
    }

    public void setNomeComum(String nomeComum) {
        this.nomeComum = nomeComum;
    }

    public String getNomeOfiacial() {
        return nomeOficial;
    }

    public void setNomeOfiacial(String nomeOfiacial) {
        this.nomeOficial = nomeOfiacial;
    }
}
