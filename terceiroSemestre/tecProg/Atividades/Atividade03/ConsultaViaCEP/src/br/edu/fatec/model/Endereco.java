package br.edu.fatec.model;

import lombok.Data;

@Data
public class Endereco {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
}
