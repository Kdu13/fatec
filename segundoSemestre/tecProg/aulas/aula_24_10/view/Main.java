package aulas.aula_24_10.view;

import aulas.aula_24_10.model.Corrente;
import aulas.aula_24_10.model.Poupança;

public class Main {
    public static void main(String[] args) {

        Corrente contac = new Corrente(1000, 1010, "Maria");
        Poupança contap = new Poupança(1000, 5050, "Pedro");

        contac.depositarSaldo(50);
        contac.cobrarTaxa();
        System.out.println(contac);

        System.out.println();

        contap.depositarSaldo(70.00);
        contap.depositarSaldo(150, 2);
        contap.cobrarTaxa();
        System.out.println(contap);

    }

}
