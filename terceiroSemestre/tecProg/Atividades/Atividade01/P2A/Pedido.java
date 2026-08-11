import java.util.ArrayList;

public class Pedido {

    private int numero;
    private ArrayList<ItemPedido> itens;
    private int numeroMesa;

    public Pedido(int numero) {
        this.numero = numero;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public void removerItem(ItemPedido item) {
        itens.remove(item);
    }

    public void reservarMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public double calcularTotalPedido() {

        double total = 0;

        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }

        total += 10;

        return total;
    }

    public int getNumero() {
        return numero;
    }

    public void exibirPedido() {

        System.out.println("Pedido número: " + numero);
        System.out.println("Mesa: " + numeroMesa);

        for (ItemPedido item : itens) {
            System.out.println(item);
        }

        System.out.println("Total: R$ " + calcularTotalPedido());
    }
}