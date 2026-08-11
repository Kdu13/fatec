package P2B;

import java.util.ArrayList;

public class Aeroporto {

    private ArrayList<Voo> voos;

    public Aeroporto() {
        voos = new ArrayList<>();
    }

    public void adicionarVoo(Voo voo) {
        voos.add(voo);
    }

    public void removerVoo(Voo voo) {
        voos.remove(voo);
    }

    public Voo buscarVoo(String numeroVoo) {

        for (Voo voo : voos) {

            if (voo.getNumeroVoo().equals(numeroVoo)) {
                return voo;
            }
        }

        return null;
    }

    public void exibirVoos() {

        for (Voo voo : voos) {
            voo.imprimirPassagem();
            System.out.println("--------------------");
        }
    }
}
