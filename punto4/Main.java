

public class Main {

    public static void main(String[] args) {

        ListaJuego<String> juego = new ListaJuego<>();

        // AGREGAR jugadores
        juego.agregar("Jugador 1");
        juego.agregar("Jugador 2");
        juego.agregar("Jugador 3");

        System.out.println("Jugadores:");
        juego.mostrar();

        // TURNOS
        System.out.println("\nSiguiente turno:");
        System.out.println(juego.siguiente());

        System.out.println("Siguiente turno:");
        System.out.println(juego.siguiente());

        System.out.println("Turno anterior:");
        System.out.println(juego.anterior());

        // ELIMINAR
        System.out.println("\nEliminar Jugador 2");
        juego.eliminar("Jugador 2");

        juego.mostrar();

        // BUSCAR
        System.out.println("\nBuscar Jugador 3:");
        System.out.println(juego.buscar("Jugador 3"));
    }
}