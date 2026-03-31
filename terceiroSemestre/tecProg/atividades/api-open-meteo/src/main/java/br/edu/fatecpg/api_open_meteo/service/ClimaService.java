package br.edu.fatecpg.api_open_meteo.service;

import br.edu.fatecpg.api_open_meteo.model.ClimaDados;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ClimaService {

    @Value("${open-meteo.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public ClimaDados buscarClima(double latitude, double longitude) {

        String url = apiUrl
                .replace("{lat}", String.valueOf(latitude))
                .replace("{lon}", String.valueOf(longitude));

        try {
            ClimaDados dados = restTemplate.getForObject(url, ClimaDados.class);

            if (dados == null || dados.getClimaAtual() == null) {
                return erro("Não foi possível obter dados da API.");
            }

            return dados;

        } catch (HttpClientErrorException e) {
            System.out.println("Erro HTTP: " + e.getStatusCode());
            return erro("Erro na requisição (verifique parâmetros).");

        } catch (Exception e) {
            System.out.println("Erro geral: " + e.getMessage());
            return erro("Serviço indisponível no momento.");
        }
    }

    private ClimaDados erro(String mensagem) {
        ClimaDados erro = new ClimaDados();
        erro.setErro(mensagem);
        return erro;
    }

    public String descricaoClima(int codigo) {
        return switch (codigo) {
            case 0 -> "Céu Limpo";
            case 1, 2, 3 -> "Parcialmente Nublado";
            case 45, 48 -> "Neblina";
            case 51, 53, 55, 56, 57, 61, 63, 65, 66, 67 -> "Chuva";
            case 71, 73, 75, 77 -> "Neve";
            case 80, 81, 82 -> "Pancadas de Chuva";
            case 95, 96, 99 -> "Tempestade com Raios";
            default -> "Condição Desconhecida";
        };
    }
}