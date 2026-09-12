package br.edu.fatecpg.streamlambda.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Produto {

    private String nome;
    private String categoria;
    private double preco;
}