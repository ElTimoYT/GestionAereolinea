public class Asiento {
    private int fila;
    private int butaca;
    private Pasajero pasajero;

    public Asiento(int fila, int butaca, Pasajero pasajero) {
        this.fila = fila;
        this.butaca = butaca;
        this.pasajero = pasajero;
    }

    public int getFila() {
        return this.fila;
    }

    public int getButaca() {
        return this.butaca;
    }

    public Pasajero getPasajero() {
        return this.pasajero;
    }

    public String toString() {
        String letraButaca = switch (getButaca()) {
            case 0 -> "A";
            case 1 -> "B";
            case 2 -> "C";
            case 3 -> "D";
            default -> "";
        };

        return getFila() + letraButaca;
    }
}
