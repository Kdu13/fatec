package br.edu.fatec.consumoapicombanco.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Favorito {
    private int id;
    private String nome;
    private String url;

    public Favorito(String nome, String url) {
        this.nome = nome;
        this.url = url;
    }

    public Favorito(int id, String nome, String url) {
        this.id = id;
        this.nome = nome;
        this.url = url;
    }
}