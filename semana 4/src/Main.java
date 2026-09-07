import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        System.out.println("========== SPEEDFAST ==========");
        System.out.println("=== SIMULACIÓN DE ENTREGAS CONCURRENTES ===");
        System.out.println();

        // PEDIDOS DEL REPARTIDOR 1
        Pedido pedido1 = new PedidoComida(
                101,
                "Av. Italia 456",
                4
        );

        Pedido pedido2 = new PedidoExpress(
                102,
                "Av. Providencia 1200",
                6
        );

        // PEDIDOS DEL REPARTIDOR 2
        Pedido pedido3 = new PedidoEncomienda(
                103,
                "Av. Santa Rosa 567",
                7
        );

        Pedido pedido4 = new PedidoComida(
                104,
                "Av. Irarrázaval 2300",
                5
        );

        // PEDIDOS DEL REPARTIDOR 3
        Pedido pedido5 = new PedidoExpress(
                105,
                "Av. Apoquindo 1500",
                8
        );

        Pedido pedido6 = new PedidoEncomienda(
                106,
                "Gran Avenida 3200",
                10
        );

        // REPARTIDORES CON SUS PEDIDOS ASIGNADOS
        Repartidor repartidor1 = new Repartidor(
                "Camila",
                Arrays.asList(pedido1, pedido2)
        );

        Repartidor repartidor2 = new Repartidor(
                "Luis",
                Arrays.asList(pedido3, pedido4)
        );

        Repartidor repartidor3 = new Repartidor(
                "Daniela",
                Arrays.asList(pedido5, pedido6)
        );

        // POOL DE 3 HILOS
        ExecutorService executor = Executors.newFixedThreadPool(3);

        System.out.println("Iniciando entregas...");
        System.out.println();

        executor.execute(repartidor1);
        executor.execute(repartidor2);
        executor.execute(repartidor3);

        // NO SE ACEPTAN MÁS TAREAS
        executor.shutdown();

        try {

            // ESPERA A QUE TODOS LOS REPARTIDORES TERMINEN
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {

                System.out.println();
                System.out.println(
                        "Todos los repartidores finalizaron sus entregas."
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