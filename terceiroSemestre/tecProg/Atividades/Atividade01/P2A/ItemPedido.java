public class ItemPedido {

    private String nomeDoPrato;
    private int quantidade;
    private double precoUnitario;

    public ItemPedido(String nomeDoPrato, int quantidade, double precoUnitario) {
        this.nomeDoPrato = nomeDoPrato;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public String getNomeDoPrato() {
        return nomeDoPrato;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public double calcularSubtotal() {
        return quantidade * precoUnitario;
    }

    @Override
    public String toString() {
        return nomeDoPrato + " - Quantidade: " + quantidade
                + " - Preço: R$ " + precoUnitario;
    }
}