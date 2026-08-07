package br.edu.fatecpg.api_open_meteo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClimaDados {

    @JsonProperty("latitude")
    private double latitude;

    @JsonProperty("longitude")
    private double longitude;

    @JsonProperty("timezone")
    private String fuso;

    @JsonProperty("current")
    private ClimaAtual climaAtual;

    private String erro;

    public boolean temErro() {
        return erro != null;
    }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public String getFuso() { return fuso; }
    public void setFuso(String fuso) { this.fuso = fuso; }

    public ClimaAtual getClimaAtual() { return climaAtual; }
    public void setClimaAtual(ClimaAtual climaAtual) { this.climaAtual = climaAtual; }

    public String getErro() { return erro; }
    public void setErro(String erro) { this.erro = erro; }
}