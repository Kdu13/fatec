package P2C;

public class TreinamentoOnline extends Treinamento {

    private String linkAcesso;

    public TreinamentoOnline(int id, String nomeInstrutor,
                             String linguagemEnsinada,
                             String linkAcesso) {

        super(id, nomeInstrutor, linguagemEnsinada);

        this.linkAcesso = linkAcesso;
    }

    public void acessarTreinamento() {
        System.out.println("Link de acesso: " + linkAcesso);
    }

    @Override
    public void exibirInformacoes() {

        super.exibirInformacoes();

        System.out.println("Tipo: Online");
        System.out.println("Link: " + linkAcesso);
    }
}