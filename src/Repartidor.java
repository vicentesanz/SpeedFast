import java.util.List;
import java.util.Random;

public class Repartidor implements Runnable {

    private String nombre;
    private List<Pedido> pedidos;

    public Repartidor(String nombre, List<Pedido> pedidos) {
        this.nombre = nombre;
        this.pedidos = pedidos;
    }

    @Override
    public void run() {

        Random random = new Random();

        for (Pedido pedido : pedidos) {

            System.out.println(
                    "[Repartidor: " + nombre + "] Entregando "
                            + pedido.getClass().getSimpleName()
                            + " #" + pedido.getIdPedido() + "..."
            );

            try {
                int tiempoEspera = 1000 + random.nextInt(2001);
                Thread.sleep(tiempoEspera);

                pedido.despachar();

                System.out.println(
                        "[Repartidor: " + nombre + "] Pedido #"
                                + pedido.getIdPedido()
                                + " entregado."
                );

            } catch (InterruptedException e) {
                System.out.println(
                        "[Repartidor: " + nombre
                                + "] La entrega fue interrumpida."
                );

                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println(
                "[Repartidor: " + nombre + "] Finalizó todas sus entregas."
        );
    }
}