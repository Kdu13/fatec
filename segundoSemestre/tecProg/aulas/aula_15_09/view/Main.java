package aulas.aula_15_09.view;

import aulas.aula_15_09.model.Carro;

public class Main {

    public static void main(String[] args) {

        Carro meuCarro = new Carro("Renault", "Logan", 2015); // Método Construtor.
        meuCarro.setAno(2020); // Setter do ano.
        System.out.println(meuCarro.getModelo()); // Getter do modelo.
        String marca = meuCarro.getMarca(); // Getter da marca pegando o retorno.
        System.out.println(marca); // Impressão da variável.
        meuCarro.ligar(); // Chama o método ligar.
        meuCarro.acelerar(); // Chama o método acelerar.

    }

}
