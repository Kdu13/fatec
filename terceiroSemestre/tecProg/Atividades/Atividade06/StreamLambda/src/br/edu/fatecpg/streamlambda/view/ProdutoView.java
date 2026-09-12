package br.edu.fatecpg.streamlambda.view;

import br.edu.fatecpg.streamlambda.model.Produto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProdutoView {

    public static void executar() {

        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Smartphone", "Eletronicos", 1500.00));
        produtos.add(new Produto("Notebook", "Eletronicos", 3500.00));
        produtos.add(new Produto("Fone de Ouvido", "Eletronicos", 200.00));
        produtos.add(new Produto("Smart TV", "Eletronicos", 2200.00));
        produtos.add(new Produto("Dom Casmurro", "Livros", 35.00));
        produtos.add(new Produto("O Cortico", "Livros", 28.50));
        produtos.add(new Produto("Camiseta", "Roupas", 49.90));
        produtos.add(new Produto("Calca Jeans", "Roupas", 129.90));
        produtos.add(new Produto("Jaqueta", "Roupas", 249.90));

        System.out.println("=== Lista completa de produtos ===");
        produtos.forEach(System.out::println);

        List<Produto> eletronicos = produtos.stream()
                .filter(p -> p.getCategoria().equals("Eletronicos"))
                .collect(Collectors.toList());

        System.out.println("\n=== Produtos da categoria Eletronicos ===");
        eletronicos.forEach(System.out::println);

        List<Produto> eletronicosComDesconto = eletronicos.stream()
                .map(p -> new Produto(p.getNome(), p.getCategoria(), p.getPreco() * 0.9))
                .sorted(Comparator.comparingDouble(Produto::getPreco))
                .collect(Collectors.toList());

        System.out.println("\n=== Eletronicos com 10% de desconto, ordenados por preco (crescente) ===");
        eletronicosComDesconto.forEach(System.out::println);

        double totalRoupas = produtos.stream()
                .filter(p -> p.getCategoria().equals("Roupas"))
                .map(Produto::getPreco)
                .reduce(0.0, Double::sum);

        System.out.printf("%n=== Total gasto em Roupas: R$ %.2f ===%n", totalRoupas);

        Map<String, Double> mediaPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(
                        Produto::getCategoria,
                        Collectors.averagingDouble(Produto::getPreco)
                ));

        System.out.println("\n=== Preco medio por categoria ===");
        mediaPorCategoria.forEach((categoria, media) ->
                System.out.printf("%s: R$ %.2f%n", categoria, media));
    }
}
