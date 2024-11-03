public class Vuelo {
    private String paisOrigen;
    private String paisDestino;
    private String fecha;
    private Avion avion;

    public Vuelo(String paisOrigen, String paisDestino, String fecha, Avion avion) {
        this.paisOrigen = paisOrigen;
        this.paisDestino = paisDestino;
        this.fecha = fecha;
        this.avion = avion;
    }

    public String getPaisOrigen() {
        return this.paisOrigen;
    }

    public String getPaisDestino() {
        return this.paisDestino;
    }

    public String getFecha() {
        return this.fecha;
    }

    public Avion getAvion() {
        return this.avion;
    }
}
