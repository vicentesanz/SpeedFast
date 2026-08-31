public class Main {

    public static void main(String[] args) {

        ControladorDeEnvios controlador = new ControladorDeEnvios();

        Pedido pedidoComida = new PedidoComida(
                101,
                "Av. Italia 456",
                4
        );

        Pedido pedidoEncomienda = new PedidoEncomienda(
                102,
                "Av. Santa Rosa 567",
                7
        );

        Pedido pedidoExpress = new PedidoExpress(
                103,
                "Av. Apoquindo 1500",
                8
        );

        System.out.println("========== SPEEDFAST ==========");
        System.out.println();

        // CASO 1: PEDIDO DE COMIDA
        System.out.println("=== PEDIDO COMIDA ===");

        pedidoComida.reservar();

        // Asignación automática
        pedidoComida.asignarRepartidor();

        mostrarPedido(pedidoComida);

        pedidoComida.despachar();
        controlador.registrarEntrega(pedidoComida);

        System.out.println();

        // CASO 2: PEDIDO DE ENCOMIENDA
        System.out.println("=== PEDIDO ENCOMIENDA ===");

        pedidoEncomienda.reservar();

        // Asignación manual mediante sobrecarga
        pedidoEncomienda.asignarRepartidor("Daniela Tapia");

        mostrarPedido(pedidoEncomienda);

        pedidoEncomienda.despachar();
        controlador.registrarEntrega(pedidoEncomienda);

        System.out.println();

        // CASO 3: PEDIDO EXPRESS
        System.out.println("=== PEDIDO EXPRESS ===");

        pedidoExpress.reservar();

        // Asignación automática
        pedidoExpress.asignarRepartidor();

        mostrarPedido(pedidoExpress);

        pedidoExpress.cancelar();

        System.out.println();

        // HISTORIAL
        controlador.verHistorial();
    }

    public static void mostrarPedido(Pedido pedido) {

        pedido.mostrarResumen();

        System.out.println(
                "Tiempo estimado de entrega: "
                        + pedido.calcularTiempoEntrega()
                        + " minutos"
        );
    }
}