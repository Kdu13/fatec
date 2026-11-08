package br.edu.fatec.cadastroprodutos.controller;

import br.edu.fatec.cadastroprodutos.model.Produto;
import br.edu.fatec.cadastroprodutos.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProdutoController {

    private static final List<String> CATEGORIAS =
            List.of("Eletrônico", "Vestuário", "Alimento", "Outros");

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // GET / → abre o formulário.
    @GetMapping("/")
    public String index() {
        return "redirect:/cadastrar";
    }

    // GET /cadastrar → exibe o formulário vazio.
    @GetMapping("/cadastrar")
    public String exibirFormulario(Model model) {
        prepararFormulario(model, new Produto());
        return "cadastrar";
    }

    // POST /cadastrar → valida, salva no Service e aplica o padrão PRG.
    @PostMapping("/cadastrar")
    public String cadastrarProduto(@ModelAttribute Produto produto, Model model) {
        if (produto.getPreco() < 0) {
            prepararFormulario(model, produto);
            model.addAttribute("erro", "O preço não pode ser menor que zero.");
            return "cadastrar";
        }

        produtoService.adicionar(produto);
        return "redirect:/lista";
    }

    // GET /lista → mostra todos os produtos ou apenas os que correspondem à busca.
    @GetMapping("/lista")
    public String exibirLista(@RequestParam(required = false) String busca, Model model) {
        model.addAttribute("produtos", produtoService.buscar(busca));
        model.addAttribute("busca", busca == null ? "" : busca);
        model.addAttribute("totalProdutos", produtoService.contar());
        return "lista";
    }

    // POST /remover/{id} → remove o produto escolhido.
    @PostMapping("/remover/{id}")
    public String removerProduto(@PathVariable Long id) {
        produtoService.remover(id);
        return "redirect:/lista";
    }

    private void prepararFormulario(Model model, Produto produto) {
        model.addAttribute("produto", produto);
        model.addAttribute("categorias", CATEGORIAS);
    }
}
