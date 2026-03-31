package aulas.aula_29_08.model;

public class Carro {

    public String marca;
    public String modelo;
    public int ano;
    public boolean ligado = false;

    public void ligar() {

        if (!ligado) {
            System.out.println("O carro foi ligado");
        } else {
            System.out.println("O carro já está ligado");
        }

    }

    public void acelerar() {

        if (ligado) {
            System.out.println("O carro está andando");
        } else {
            System.out.println("Não é possível andar com o carro desligado");
            this.ligar();
            this.acelerar();
        }
    }

    public void desligar() {
        if (ligado) {
            System.out.println("O carro foi desligado");
            ligado = false;
        } else {
            System.out.println("O carro já está desligado");
        }
    }

}
