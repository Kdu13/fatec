package P2C;

public class TreinamentoPresencial extends Treinamento {

    private String local;

    public TreinamentoPresencial(int id, String nomeInstrutor,
                                 String linguagemEnsinada,
                                 String local) {

        super(id, nomeInstrutor, linguagemEnsinada);

        this.local = local;
    }

    public void informarLocal() {
        System.out.println("Local do treinamento: " + local);
    }

    @Override
    public void exibirInformacoes() {

        super.exibirInformacoes();

        System.out.println("Tipo: Presencial");
        System.out.println("Local: " + local);
    }
}
