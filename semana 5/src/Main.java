import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        System.out.println("========== SPEEDFAST ==========");
        System.out.println("=== SINCRONIZACIÓN DE ENTREGAS ===");
        System.out.println();

        // RECURSO COMPARTIDO
        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

        // PEDIDOS
        Pedido pedido1 = new PedidoComida(
                101,
                "Santiago Centro",
                4
        );

        Pedido pedido2 = new PedidoExpress(
                102,
                "Providencia",
                6
        );

        Pedido pedido3 = new PedidoEncomienda(
                103,
                "Ñuñoa",
                7
        );

        Pedido pedido4 = new PedidoComida(
                104,
                "Recoleta",
                5
        );

        Pedido pedido5 = new PedidoExpress(
                105,
                "Las Condes",
                8
        );

        Pedido pedido6 = new PedidoEncomienda(
                106,
                "La Florida",
                10
        );

        // SE AGREGAN LOS PEDIDOS A LA ZONA DE CARGA COMPARTIDA
        zonaDeCarga.agregarPedido(pedido1);
        zonaDeCarga.agregarPedido(pedido2);
        zonaDeCarga.agregarPedido(pedido3);
        zonaDeCarga.agregarPedido(pedido4);
        zonaDeCarga.agregarPedido(pedido5);
        zonaDeCarga.agregarPedido(pedido6);

        System.out.println();

        // LOS 3 REPARTIDORES COMPARTEN LA MISMA ZONA DE CARGA
        Repartidor repartidor1 = new Repartidor(
                "Camila",
                zonaDeCarga
        );

        Repartidor repartidor2 = new Repartidor(
                "Luis",
                zonaDeCarga
        );

        Repartidor repartidor3 = new Repartidor(
                "Daniela",
                zonaDeCarga
        );

        ExecutorService executor = Executors.newFixedThreadPool(3);

        System.out.println("Iniciando entregas...");
        System.out.println();

        executor.execute(repartidor1);
        executor.execute(repartidor2);
        executor.execute(repartidor3);

        executor.shutdown();

        try {

            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {

                System.out.println();
                System.out.println(
                        "Todos los pedidos han sido entregados correctamente"
                );

            } else {

                System.out.println(
                        "La simulación superó el tiempo máximo de espera."
                );

                executor.shutdownNow();
            }

        } catch (InterruptedException e) {

            System.out.println(
                    "La ejecución principal fue interrumpida."
            );

            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println();
        System.out.println("========== FIN SPEEDFAST ==========");
    }
}