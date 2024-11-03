public class Pasajero {
	private String nombre;
	private String pasaporte;
	private String telefono;
	private int edad;
	private Maleta maleta;

	public Pasajero(String nombre, String pasaporte, String telefono, int edad, Maleta maleta) {
		this.nombre = nombre;
		this.pasaporte = pasaporte;
		this.telefono = telefono;
		this.edad = edad;
		this.maleta = maleta;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPasaporte() {
		return pasaporte;
	}

	public String getTelefono() {
		return telefono;
	}

	public int getEdad() {
		return edad;
	}

	public Maleta getMaleta() {
		return maleta;
	}
}
