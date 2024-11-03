public class Maleta {
    private final double PESO_MAXIMO = 23;
    private double peso;
    private final int MEDIDA_TOTAL_MAXIMA = 158;
    private int ancho;
    private int alto;
    private int fondo;

    public Maleta(double peso, int ancho, int alto, int fondo) {
        this.peso = peso;
        this.ancho = ancho;
        this.alto = alto;
        this.fondo = fondo;
    }

    public double getPeso() {
        return this.peso;
    }

    public int getMedidaTotal() {
        return this.ancho + this.alto + this.fondo;
    }

    public boolean excedeDePeso() {
        if (this.peso > this.PESO_MAXIMO){
            return true;
        }
        return false;
    }

    public boolean excedeDeMedidas() {
        if (this.getMedidaTotal() > this.MEDIDA_TOTAL_MAXIMA){
            return true;
        }
        return false;
    }
}
