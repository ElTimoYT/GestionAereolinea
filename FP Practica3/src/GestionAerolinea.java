import java.util.Scanner;

public class GestionAerolinea {
    // Precio de un asiento de la clase turista
    private final int PRECIO_BILLETE_TURISTA = 350;
    // Precio de un asiento de la clase business
    private final int PRECIO_BILLETE_BUSINESS = 1500;
    // Se aplica un 15% de descuento a los menores de 15 años (<15)
    private final float DESCUENTO_INFANTIL = 15f;
    // Número de aviones de la aerolínea
    private final int NUM_AVIONES = 3;
    // Lista de aviones de la aerolínea
    private Avion[] aviones;
    private final int NUM_VUELOS = NUM_AVIONES;
    // Lista de vuelos
    private Vuelo[] vuelos;
    // Variable que indica si se han inicializado los datos de aviones y vuelos
    private boolean avionesYVuelosInicializados = false;

    public static void main(String[] args) {
        // Creamos un objeto para ejecutar el programa
        GestionAerolinea obj = new GestionAerolinea();
    }

    public GestionAerolinea() {
        // Constructor de la clase que inicia el programa
        int opcion;
        do {
            opcion = menu();
            ejecutarOpcion(opcion);
        } while (opcion != 0);
    }

    public void ejecutarOpcion(int opcion) {
        // Ejecuta el código asociado a la opción
        switch (opcion) {
            case 1: // Inicializar aviones y vuelos
                iniciarAvionesYVuelos();
                break;
            case 2: // Reservar asiento en un vuelo
                if (!avionesYVuelosInicializados) {
                    System.out.println("Error. Aviones y vuelos no inicializados.");
                    break;
                }
                int vuelo = preguntarVuelo();
                Clase clase = preguntarClase();
                reservarAsiento(vuelos[vuelo].getAvion(), clase);
                break;
            case 3: // Mostrar el mapa de asientos
                if (!avionesYVuelosInicializados) {
                    System.out.println("Error. Aviones y vuelos no inicializados.");
                    break;
                }
                vuelo = preguntarVuelo();
                vuelos[vuelo].getAvion().mostrarMapaDeAsientos();
                break;
            case 4: // Mostrar la lista de pasajeros
                if (!avionesYVuelosInicializados) {
                    System.out.println("Error. Aviones y vuelos no inicializados.");
                    break;
                }
                vuelo = preguntarVuelo();
                mostrarPasajeros(vuelos[vuelo].getAvion());
                break;
            case 5: // Mostrar pasajeros menores de 15 años
                if (!avionesYVuelosInicializados) {
                    System.out.println("Error. Aviones y vuelos no inicializados.");
                    break;
                }
                vuelo = preguntarVuelo();
                mostrarPasajeros(vuelos[vuelo].getAvion(), 15);
                break;
            case 6: // Mostrar ingresos del vuelo
                if (!avionesYVuelosInicializados) {
                    System.out.println("Error. Aviones y vuelos no inicializados.");
                    break;
                }
                vuelo = preguntarVuelo();
                mostrarIngresos(vuelos[vuelo].getAvion());
                break;
            default: // Finalizar
                System.out.println("Fin de la ejecución.");
        }
    }

    public void iniciarAvionesYVuelos() {
        // Se inicializan las listas de aviones y vuelos
        aviones = new Avion[NUM_AVIONES];
        aviones[0] = new Avion("Airbus A330", 40, 120);
        aviones[1] = new Avion("Airbus A310", 20, 100);
        aviones[2] = new Avion("Airbus A350", 48, 180);
        vuelos = new Vuelo[NUM_VUELOS];
        vuelos[0] = new Vuelo("Madrid", "La Habana", "01/12/2024", aviones[0]);
        vuelos[1] = new Vuelo("Madrid", "Cancún", "01/12/2024", aviones[1]);
        vuelos[2] = new Vuelo("Madrid", "Punta Cana", "01/12/2024", aviones[2]);
        avionesYVuelosInicializados = true;
        System.out.println("Aviones y vuelos inicializados.");
    }

    public int menu() {
        // Muestra el menú de opciones
        int opcion;
        System.out.println("1. Inicializar aviones y vuelos");
        System.out.println("2. Reservar asiento en un vuelo");
        System.out.println("3. Mostrar el mapa de asientos");
        System.out.println("4. Mostrar la lista de pasajeros");
        System.out.println("5. Mostrar pasajeros menores de 15 años");
        System.out.println("6. Mostrar ingresos del vuelo");
        System.out.println("0. Finalizar");
        opcion = leerNumero(0, 6, "Introduzca un número entre 0 y 6: ");
        return opcion;
    }

    public int leerNumero(int minimo, int maximo, String mensaje) {
        Scanner teclado = new Scanner(System.in);
        int numero;
        do {
            System.out.print(mensaje);
            numero = teclado.nextInt();
        } while (numero < minimo || numero > maximo);
        return numero;
    }

    public int preguntarVuelo() {
        int numero;
        numero = leerNumero(0, 2, "Elija el vuelo (0: La Habana, 1: Cancún, 2: Punta Cana) ");
        return numero;
    }

    public Clase preguntarClase() {
        Clase clase;
        int numero = leerNumero(0, 1, "Elija la clase (0: Business, 1: Turista) ");
        clase = numero == 0 ? Clase.BUSINESS : Clase.TURISTA;
        return clase;
    }

    public void reservarAsiento(Avion avion, Clase clase) {
        for (int fila = 1; fila <= avion.getNumeroFilas(clase); fila++) {
            for (int butaca = 1; butaca <= avion.getButacasPorFila(); butaca++) {
                if (avion.getPasajero(fila, butaca, clase) == null) {
                    Pasajero pasajero = Azar.generaPasajero();
                    avion.reservarAsiento(fila, butaca, clase, pasajero);
                    System.out.println("Reservado el asiento " + fila + (char)('A' + butaca - 1) +
                            " de clase " + clase.toString().toLowerCase() +
                            " al pasajero " + pasajero.getNombre());
                    return;
                }
            }
        }
        System.out.println("No hay asientos libres en clase " + clase.toString().toLowerCase());
    }

    public void mostrarPasajeros(Avion avion) {
        System.out.println("Avión " + avion.getModelo());
        System.out.println("Lista de pasajeros de la clase Business:");
        for (int fila = 1; fila <= avion.getNumeroFilas(Clase.BUSINESS); fila++) {
            System.out.println("Fila " + fila);
            for (int butaca = 1; butaca <= avion.getButacasPorFila(); butaca++) {
                Pasajero pasajero = avion.getPasajero(fila, butaca, Clase.BUSINESS);
                if (pasajero != null) {
                    System.out.printf("%-40s %-20s %d años%n", pasajero.getNombre(), pasajero.getPasaporte(), pasajero.getEdad());
                }
            }
        }
        System.out.println("Lista de pasajeros de la clase Turista:");
        for (int fila = 1; fila <= avion.getNumeroFilas(Clase.TURISTA); fila++) {
            System.out.println("Fila " + fila);
            for (int butaca = 1; butaca <= avion.getButacasPorFila(); butaca++) {
                Pasajero pasajero = avion.getPasajero(fila, butaca, Clase.TURISTA);
                if (pasajero != null) {
                    System.out.printf("%-40s %-20s %d años%n", pasajero.getNombre(), pasajero.getPasaporte(), pasajero.getEdad());
                } else {
                    System.out.println("(libre)");
                }
            }
        }
    }

    public void mostrarPasajeros(Avion avion, int edad) {
        System.out.println("Avión " + avion.getModelo());
        System.out.println("Lista de pasajeros menores de " + edad + " años de la clase Business:");
        for (int fila = 1; fila <= avion.getNumeroFilas(Clase.BUSINESS); fila++) {
            for (int butaca = 1; butaca <= avion.getButacasPorFila(); butaca++) {
                Pasajero pasajero = avion.getPasajero(fila, butaca, Clase.BUSINESS);
                if (pasajero != null && pasajero.getEdad() < edad) {
                    System.out.printf("%-40s %d años%n", pasajero.getNombre(), pasajero.getEdad());
                }
            }
        }
        System.out.println("Lista de pasajeros menores de " + edad + " años de la clase Turista:");
        for (int fila = 1; fila <= avion.getNumeroFilas(Clase.TURISTA); fila++) {
            for (int butaca = 1; butaca <= avion.getButacasPorFila(); butaca++) {
                Pasajero pasajero = avion.getPasajero(fila, butaca, Clase.TURISTA);
                if (pasajero != null && pasajero.getEdad() < edad) {
                    System.out.printf("%-40s %d años%n", pasajero.getNombre(), pasajero.getEdad());
                }
            }
        }
    }

    public void mostrarIngresos(Avion avion) {
        double ingresos = 0;
        for (int fila = 1; fila <= avion.getNumeroFilas(Clase.BUSINESS); fila++) {
            for (int butaca = 1; butaca <= avion.getButacasPorFila(); butaca++) {
                Pasajero pasajero = avion.getPasajero(fila, butaca, Clase.BUSINESS);
                if (pasajero != null) {
                    ingresos += PRECIO_BILLETE_BUSINESS;
                    if (pasajero.getEdad() < 15) {
                        ingresos -= PRECIO_BILLETE_BUSINESS * DESCUENTO_INFANTIL / 100;
                    }
                }
            }
        }
        for (int fila = 1; fila <= avion.getNumeroFilas(Clase.TURISTA); fila++) {
            for (int butaca = 1; butaca <= avion.getButacasPorFila(); butaca++) {
                Pasajero pasajero = avion.getPasajero(fila, butaca, Clase.TURISTA);
                if (pasajero != null) {
                    ingresos += PRECIO_BILLETE_TURISTA;
                    if (pasajero.getEdad() < 15) {
                        ingresos -= PRECIO_BILLETE_TURISTA * DESCUENTO_INFANTIL / 100;
                    }
                }
            }
        }
        System.out.println("El avión " + avion.getModelo() + " proporciona ingresos de " + ingresos + " €");
    }
}
