public class Main {

    public static void main(String[] args) {

        Pedido pedidoComida = new PedidoComida(
                1,
                "Av. Italia 456",
                4
        );

        Pedido pedidoEncomienda = new PedidoEncomienda(
                2,
                "Av. Independencia 123",
                6
        );

        Pedido pedidoExpress = new PedidoExpress(
                3,
                "Av. Apoquindo 1500",
                7
        );

        mostrarPedido("Pedido Comida", pedidoComida);
        mostrarPedido("Pedido Encomienda", pedidoEncomienda);
        mostrarPedido("Pedido Express", pedidoExpress);
    }

    public static void mostrarPedido(String tipo, Pedido pedido) {
        System.out.println("=== " + tipo + " ===");
        pedido.mostrarResumen();
        System.out.println("Tiempo estimado de entrega: "
                + pedido.calcularTiempoEntrega() + " minutos");
        System.out.println();
    }
}