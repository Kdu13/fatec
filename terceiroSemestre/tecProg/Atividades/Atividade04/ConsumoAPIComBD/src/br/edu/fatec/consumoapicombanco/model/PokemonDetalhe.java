package br.edu.fatec.consumoapicombanco.model;

import lombok.Getter;

import java.util.List;

@Getter
public class PokemonDetalhe {
    private int id;
    private String name;
    private int height;
    private int weight;
    private int base_experience;
    private List<TypeSlot> types;
    private List<AbilitySlot> abilities;

    public int getBaseExperience() { return base_experience; }

    public List<String> getTiposFormatados() {
        return types.stream().map(t -> t.type.name).toList();
    }

    public List<String> getHabilidadesFormatadas() {
        return abilities.stream().map(a -> a.ability.name).toList();
    }

    static class TypeSlot { TypeInfo type; }
    static class TypeInfo { String name; }
    static class AbilitySlot { AbilityInfo ability; }
    static class AbilityInfo { String name; }
}