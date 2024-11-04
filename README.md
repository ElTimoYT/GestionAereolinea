# ✈️ Sistema de Gestión de Aerolíneas

## 📝 Descripción General

El Sistema de Gestión de Aerolíneas es una aplicación basada en Java que permite a los usuarios gestionar vuelos y reservas. El sistema ofrece funcionalidades para inicializar vuelos y aviones, reservar asientos, mostrar mapas de asientos, listar pasajeros, mostrar pasajeros menores de cierta edad y calcular ingresos de vuelos.

## 🌟 Funcionalidades

1. **Inicializar Aviones y Vuelos** 🛫
   - Crea aviones y vuelos predefinidos.
   - Muestra el mensaje `"Aviones y vuelos inicializados"`.

2. **Reservar un Asiento en un Vuelo** 🎟️
   - Solicita al usuario seleccionar un vuelo y una clase (business o turista).
   - Reserva un asiento en la clase y vuelo especificados.
   - Muestra los detalles de la reserva.

3. **Mostrar Mapa de Asientos** 🗺️
   - Solicita al usuario seleccionar un vuelo.
   - Muestra el mapa de asientos del vuelo seleccionado.

4. **Listar Pasajeros** 👥
   - Solicita al usuario seleccionar un vuelo.
   - Muestra la lista de pasajeros en las clases business y turista con un formato adecuado.

5. **Mostrar Pasajeros Menores de una Cierta Edad** 👶
   - Solicita al usuario seleccionar un vuelo.
   - Muestra la lista de pasajeros menores de 15 años en las clases business y turista con un formato adecuado.

6. **Mostrar Ingresos del Vuelo** 💰
   - Solicita al usuario seleccionar un vuelo.
   - Muestra el ingreso total generado por el vuelo seleccionado.

7. **Salir de la Aplicación** 🚪
   - Muestra el mensaje `"Fin de la ejecución"`.

## 📖 Uso

1. **Inicializar Aviones y Vuelos** 🛫
   - Seleccione la opción `1` del menú.
   - El sistema inicializará los aviones y vuelos y mostrará un mensaje de confirmación.

2. **Reservar un Asiento en un Vuelo** 🎟️
   - Seleccione la opción `2` del menú.
   - Siga las instrucciones para seleccionar un vuelo y una clase.
   - El sistema reservará un asiento y mostrará los detalles de la reserva.

3. **Mostrar Mapa de Asientos** 🗺️
   - Seleccione la opción `3` del menú.
   - Siga la instrucción para seleccionar un vuelo.
   - El sistema mostrará el mapa de asientos del vuelo seleccionado.

4. **Listar Pasajeros** 👥
   - Seleccione la opción `4` del menú.
   - Siga la instrucción para seleccionar un vuelo.
   - El sistema mostrará la lista de pasajeros con el formato adecuado.

5. **Mostrar Pasajeros Menores de una Cierta Edad** 👶
   - Seleccione la opción `5` del menú.
   - Siga la instrucción para seleccionar un vuelo.
   - El sistema mostrará la lista de pasajeros menores de 15 años con el formato adecuado.

6. **Mostrar Ingresos del Vuelo** 💰
   - Seleccione la opción `6` del menú.
   - Siga la instrucción para seleccionar un vuelo.
   - El sistema mostrará el ingreso total generado por el vuelo seleccionado.

7. **Salir de la Aplicación** 🚪
   - Seleccione la opción `0` del menú.
   - El sistema mostrará el mensaje `"Fin de la ejecución"` y saldrá.

## ⚙️ Requisitos

- **Java Development Kit (JDK)** 8 o superior
- **IntelliJ IDEA** 2024.2.1 o cualquier otro IDE de Java

## 🚀 Cómo Ejecutarlo

1. Clonar el repositorio:
   ```sh
   git clone https://github.com/ElTimoYT/airline-management-system.git

2. Abra el proyecto en IntelliJ IDEA o en su IDE de Java preferido.

3. Compile y ejecute la clase `GestionAerolinea`.

## 📚 Clases

- **GestionAerolinea**: Clase principal que gestiona el menú y las interacciones con el usuario.
- **Avion**: Representa un avión con métodos para gestionar asientos y pasajeros.
- **Vuelo**: Representa un vuelo con detalles como destino, fecha y avión asociado.
- **Pasajero**: Representa un pasajero con detalles como nombre, pasaporte, teléfono, edad y equipaje.
- **Clase**: Enum que representa la clase del asiento (`business` o `Turista`).
- **Azar**: Clase utilitaria para generar pasajeros aleatorios.

## 📄 Licencia

Este proyecto está licenciado bajo la **Licencia MIT**. Vea el archivo [`LICENSE`](LICENSE) para más detalles.
