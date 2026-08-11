import java.util.ArrayList;

public class Restaurante {

    private ArrayList<Pedido> pedidos;

    public Restaurante() {
        pedidos = new ArrayList<>();
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void removerPedido(Pedido pedido) {
        pedidos.remove(pedido);
    }

    public Pedido buscarPedido(int numero) {

        for (Pedido pedido : pedidos) {

            if (pedido.getNumero() == numero) {
                return pedido;
            }
        }

        return null;
    }

    public void exibirPedidos() {

        for (Pedido pedido : pedidos) {
            pedido.exibirPedido();
            System.out.println("----------------------");
        }
    }
}