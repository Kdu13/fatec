import br.edu.fatecpg.streamlambda.view.FuncionarioView;
import br.edu.fatecpg.streamlambda.view.ProdutoView;

public class Main {

    public static void main(String[] args) {

        System.out.println("########## EXERCICIO 1 - PRODUTOS ##########\n");
        ProdutoView.executar();

        System.out.println("\n########## EXERCICIO 2 - FUNCIONARIOS ##########\n");
        FuncionarioView.executar();
    }
}