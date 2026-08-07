package br.edu.fatecpg.api_open_meteo.controller;

import br.edu.fatecpg.api_open_meteo.model.ClimaDados;
import br.edu.fatecpg.api_open_meteo.service.ClimaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClimaController {

    private final ClimaService climaService;

    public ClimaController(ClimaService climaService) {
        this.climaService = climaService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/buscar")
    public String buscar(
            @RequestParam double latitude,
            @RequestParam double longitude,
            Model model) {

        ClimaDados dados = climaService.buscarClima(latitude, longitude);

        if (dados.getErro() == null) {
            String descricao = climaService.descricaoClima(
                    dados.getClimaAtual().getCodigoClima()
            );

            model.addAttribute("descricao", descricao);
        }

        model.addAttribute("dados", dados);

        return "resultado";
    }
}