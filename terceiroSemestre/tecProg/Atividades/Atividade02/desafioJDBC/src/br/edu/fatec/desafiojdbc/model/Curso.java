package br.edu.fatec.desafiojdbc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Curso {

    private int id;
    private String nome;
    private String descricao;
    private int duracao;
}