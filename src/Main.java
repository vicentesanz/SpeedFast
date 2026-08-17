public class Main {

    public static void main(String[] args) {

        Pedido pedidoComida = new PedidoComida(
                1,
                "Av. Providencia 1234",
                "Comida"
        );

        Pedido pedidoEncomienda = new PedidoEncomienda(
                2,
                "Av. Apoquindo 2500",
                "Encomienda"
        );

        Pedido pedidoExpress = new PedidoExpress(
                3,
                "Av. Irarrázaval 1800",
                "Express"
        );

        pedidoComida.asignarRepartidor();
        pedidoComida.asignarRepartidor("Juan Pérez");

        System.out.println();

        pedidoEncomienda.asignarRepartidor();
        pedidoEncomienda.asignarRepartidor("Camila Soto");

        System.out.println();

        pedidoExpress.asignarRepartidor();
        pedidoExpress.asignarRepartidor("Luis Díaz");
    }
}