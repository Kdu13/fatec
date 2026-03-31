package aulas.aula_07_11.model;

public class Endereco {
    private String rua;
    private String cep;
    private int numero;

    public Endereco(String rua, String cep, int numero) {
        this.rua = rua;
        this.cep = cep;
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }
    public String getCep() {
        return cep;
    }
    public int getNumero() {
        return numero;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    @Override
    public String toString() {
        return "Endereco{" +
                "rua='" + rua + '\'' +
                ", cep='" + cep + '\'' +
                ", numero=" + numero +
                '}';
    }
}
