public class Main {

    public static void main(String[] args) {

        ItemPedido item1 = new ItemPedido("Hambúrguer", 2, 25.00);
        ItemPedido item2 = new ItemPedido("Refrigerante", 2, 7.00);

        Pedido pedido = new Pedido(1);

        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);

        pedido.reservarMesa(5);

        Restaurante restaurante = new Restaurante();

        restaurante.adicionarPedido(pedido);

        pedido.exibirPedido();

        System.out.println("Total do pedido: R$ "
                + pedido.calcularTotalPedido());
    }
}