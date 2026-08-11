package P2B;

public class Voo {

    private String numeroVoo;
    private String origem;
    private String destino;
    private int assentosDisponiveis;

    public Voo(String numeroVoo, String origem, String destino,
               int assentosDisponiveis) {

        this.numeroVoo = numeroVoo;
        this.origem = origem;
        this.destino = destino;
        this.assentosDisponiveis = assentosDisponiveis;
    }

    public boolean verificarDisponibilidade(int quantidadeAssentos) {

        return quantidadeAssentos <= assentosDisponiveis;
    }

    public void realizarReserva(int quantidadeAssentos) {

        if (verificarDisponibilidade(quantidadeAssentos)) {

            assentosDisponiveis -= quantidadeAssentos;

            System.out.println("Reserva realizada com sucesso!");

        } else {

            System.out.println("Não há assentos disponíveis.");
        }
    }

    public void realizarPagamento(String tipoViagem,
                                  boolean pontosTuristicos) {

        double valor = 500;

        if (tipoViagem.equalsIgnoreCase("ida e volta")) {
            valor = valor * 2;
        }

        if (pontosTuristicos) {
            valor += 100;
        }

        System.out.println("Pagamento realizado.");
        System.out.println("Valor da passagem: R$ " + valor);
    }

    public void imprimirPassagem() {

        System.out.println("===== PASSAGEM =====");
        System.out.println("Voo: " + numeroVoo);
        System.out.println("Origem: " + origem);
        System.out.println("Destino: " + destino);
        System.out.println("Assentos disponíveis: "
                + assentosDisponiveis);
    }

    public String getNumeroVoo() {
        return numeroVoo;
    }
}