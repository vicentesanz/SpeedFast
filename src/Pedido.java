public abstract class Pedido implements Despachable, Cancelable {

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

    public void reservar() {
        estado = "Reservado";
        System.out.println("Pedido #" + idPedido + " reservado correctamente.");
    }

    @Override
    public void despachar() {
        estado = "Despachado";
        System.out.println("Pedido #" + idPedido + " despachado correctamente.");
    }

    @Override
    public void cancelar() {
        estado = "Cancelado";
        System.out.println("Pedido #" + idPedido + " cancelado exitosamente.");
    }

    public abstract void asignarRepartidor();

    public void asignarRepartidor(String nombre) {
        this.repartidor = nombre;
    }

    public abstract int calcularTiempoEntrega();
}