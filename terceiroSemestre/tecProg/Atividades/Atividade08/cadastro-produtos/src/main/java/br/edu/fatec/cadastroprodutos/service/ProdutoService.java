package br.edu.fatec.cadastroprodutos.service;

import br.edu.fatec.cadastroprodutos.model.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

// Mantém os produtos em memória e concentra as operações da aplicação.
@Service
public class ProdutoService {

    private final List<Produto> produtos = new ArrayList<>();
    private final AtomicLong proximoId = new AtomicLong(1);

    public void adicionar(Produto produto) {
        produto.setId(proximoId.getAndIncrement());
        produtos.add(produto);
    }

    public boolean remover(Long id) {
        return produtos.removeIf(produto -> produto.getId().equals(id));
    }

    public List<Produto> buscar(String termo) {
        if (termo == null || termo.isBlank()) {
            return new ArrayList<>(produtos);
        }

        String busca = termo.trim().toLowerCase(Locale.ROOT);
        return produtos.stream()
                .filter(produto -> contem(produto.getNome(), busca)
                        || contem(produto.getCategoria(), busca))
                .toList();
    }

    public int contar() {
        return produtos.size();
    }

    private boolean contem(String valor, String busca) {
        return valor != null && valor.toLowerCase(Locale.ROOT).contains(busca);
    }
}
