package aulas.aula_03_10.view;

import aulas.aula_03_10.model.Aluno;
import aulas.aula_03_10.model.Carro;
import aulas.aula_03_10.model.Farmacia;

public class Main {
    public static void main(String[] args) {

        Carro sandero = new Carro();
        sandero.marca = "Renault";
        sandero.modelo = "Sandero";
        sandero.ano = 2017;

        System.out.println("Marca: " + sandero.marca + "\nModelo: " + sandero.modelo + "\nAno: " + sandero.ano);

        Aluno carlos = new Aluno();
        carlos.setNome("Carlos");
        carlos.setMatricula(null);
        carlos.setNotaFinal(7.5);

        String[] nomesMedicamentos = { "Dipirona", "Parecetamol", "Tadala", "Xanax" };
        int[] diasParaVencimento = { 10, 5, 25, 20 };
        double[] precos = { 20.00, 15.00, 37.75, 175.89 };

        Farmacia drogaril = new Farmacia(nomesMedicamentos, diasParaVencimento, precos);
        drogaril.exibirMedicamentos();
        drogaril.mediaVencimento();
        drogaril.medicamentoVencimento();
        drogaril.desconto();
        drogaril.venda(1);

    }
}
