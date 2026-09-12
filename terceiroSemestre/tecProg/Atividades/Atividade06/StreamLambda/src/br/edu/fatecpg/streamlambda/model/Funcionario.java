package br.edu.fatecpg.streamlambda.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Funcionario {

    private String nome;
    private String departamento;
    private double salario;
    private int anosDeServico;
}