public abstract class Pedido {

    private int idPedido;
    private String direccionEntrega;
    private double distanciaKm;
    private String repartidor;
    private String estado;

    public Pedido(int idPedido, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.repartidor = "Sin asignar";
        this.estado = "Pendiente";
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public String getRepartidor() {
        return repartidor;
    }

    public String getEstado() {
        return estado;
    }

    protected void setEstado(String estado) {
        this.estado = estado;
    }

    public void mostrarResumen() {
        System.out.println("Pedido #" + idPedido);
        System.out.println("Dirección: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Repartidor asignado: " + repartidor);
        System.out.println("Estado: " + estado);
    }

    // Cada tipo de pedido realizará una asignación automática diferente.
    public abstract void asignarRepartidor();

    // Sobrecarga: permite asignar manualmente un repartidor.
    public void asignarRepartidor(String nombre) {
        this.repartidor = nombre;
    }

    // Cada tipo de pedido calcula su tiempo de entrega de forma diferente.
    public abstract int calcularTiempoEntrega();
}