package aulas.aula_24_10.model;

public class Poupança extends Conta {

	private double saldoPoupança;

	public Poupança(int agencia, int conta, String cliente) {
		super(agencia, conta, cliente);
		this.saldoPoupança = 0;
	}

	public void depositarSaldo(double valor, int op) {

		if (op == 1) {
			this.depositarSaldo(valor);
		} else if (op == 2) {
			this.saldoPoupança += valor;
		}
	}

	@Override
	public String toString() {
		return super.toString() + " | Poupança: " + this.saldoPoupança;
	}

}
