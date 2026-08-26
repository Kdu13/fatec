package br.edu.fatec.consumoapicombanco.model;

import lombok.Getter;

import java.util.List;

@Getter
public class PokemonListResponse {
    private int count;
    private String next;
    private String previous;
    private List<Pokemon> results;
}