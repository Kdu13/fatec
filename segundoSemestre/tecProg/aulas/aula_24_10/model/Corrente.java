package aulas.aula_24_10.model;

public class Corrente extends Conta {

    public Corrente(int agencia, int conta, String cliente) {
        super(agencia, conta, cliente);

    }

    @Override
    public void cobrarTaxa() {
        this.depositarSaldo(-0.99);
    }

}
