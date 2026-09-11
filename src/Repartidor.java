import java.util.Random;

public class Repartidor implements Runnable {

    private final String nombre;
    private final ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run() {

        Random random = new Random();

        while (true) {

            Pedido pedido = zonaDeCarga.retirarPedido();

            if (pedido == null) {
                break;
            }

            pedido.asignarRepartidor(nombre);
            pedido.setEstado(EstadoPedido.EN_REPARTO);

            System.out.println(
                    "[Repartidor - " + nombre + "] Retirando pedido #"
                            + pedido.getIdPedido() + "..."
            );

            System.out.println(
                    "[Repartidor - " + nombre + "] Estado: "
                            + pedido.getEstado()
            );

            System.out.println(
                    "[Repartidor - " + nombre + "] Entregando pedido #"
                            + pedido.getIdPedido() + "..."
            );

            try {

                int tiempoEntrega = 1000 + random.nextInt(2001);
                Thread.sleep(tiempoEntrega);

                pedido.setEstado(EstadoPedido.ENTREGADO);

                System.out.println(
                        "[Repartidor - " + nombre + "] Pedido #"
                                + pedido.getIdPedido()
                                + " entregado."
                );

                System.out.println(
                        "[Repartidor - " + nombre + "] Estado: "
                                + pedido.getEstado()
                );

                System.out.println();

            } catch (InterruptedException e) {

                System.out.println(
                        "[Repartidor - " + nombre
                                + "] La entrega fue interrumpida."
                );

                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println(
                "[Repartidor - " + nombre
                        + "] No quedan pedidos por entregar."
        );
    }
}