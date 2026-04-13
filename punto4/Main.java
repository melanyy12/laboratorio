public class Main{
    public static void main(String[] args) {
 
        SistemaJuego juego = new SistemaJuego();
 
        juego.registrarJugador("Ana");
        juego.registrarJugador("Luis");
        juego.registrarJugador("María");
        juego.registrarJugador("Carlos");
 
        juego.mostrarMesa();
        juego.mostrarTurnoActual();
        juego.siguienteTurno();
        juego.siguienteTurno();
        juego.jugadorAnterior();
        juego.siguienteTurno();
        juego.siguienteTurno();
        juego.siguienteTurno(); // vuelve a Ana
 
        juego.expulsarActual(); // expulsa al que tiene el turno
        juego.mostrarMesa();
        juego.siguienteTurno();
        juego.siguienteTurno();
        juego.siguienteTurno(); // cicla entre los 3 restantes
 
        juego.buscar("María");
        juego.buscar("Carlos");
    }
}

