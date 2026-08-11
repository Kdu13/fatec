package P2B;

public class Main {

    public static void main(String[] args) {

        Voo voo = new Voo(
                "LA1234",
                "São Paulo",
                "Rio de Janeiro",
                100
        );

        Aeroporto aeroporto = new Aeroporto();

        aeroporto.adicionarVoo(voo);

        voo.realizarReserva(2);

        voo.realizarPagamento("ida e volta", true);

        voo.imprimirPassagem();
    }
}
