package br.edu.fatec.cadastroprodutos.model;

public class Produto {

    private Long id;
    private String nome;
    private double preco;
    private String categoria;
    private String descricao;

    // Construtor vazio usado pelo Spring ao receber o formulário.
    public Produto() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
