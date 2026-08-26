package br.edu.fatec.consumoapicombanco.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(of = "name")
public class Pokemon {
    private String name;
    private String url;
}