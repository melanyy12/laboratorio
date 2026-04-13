public class SistemaJuego {
 
    private ListaCircularDoble<Jugador> mesa = new ListaCircularDoble<>();
    private int idCounter = 0;
 
    public SistemaJuego() {}
 
    public ListaCircularDoble<Jugador> getMesa() { return mesa; }
 
    // Registra un jugador en la mesa
    public void registrarJugador(String nombre) {
        idCounter++;
        Jugador j = new Jugador(nombre, idCounter);
        mesa.addLast(j);
        System.out.println("Registrado: " + j);
    }
 
    // Avanza el turno al siguiente jugador
    public void siguienteTurno() {
        mesa.next();
        Object j = mesa.getCurrent().getNodeValue();
        System.out.println("Turno de: " + j);
    }
 
    // Retrocede al jugador anterior (consulta)
    public void jugadorAnterior() {
        mesa.prev();
        Object j = mesa.getCurrent().getNodeValue();
        System.out.println("Jugador anterior: " + j);
        mesa.next(); // regresa al turno actual
    }
 
    // Expulsa al jugador que tiene el turno actualmente
    public void expulsarActual() {
        if (mesa.isEmpty()) {
            System.out.println("No hay jugadores.");
            return;
        }
        Object j = mesa.getCurrent().getNodeValue();
        mesa.removeCurrent();
        System.out.println("Expulsado: " + j);
        if (!mesa.isEmpty())
            System.out.println("Turno pasa a: " + mesa.getCurrent().getNodeValue());
    }
 
    // Muestra quién tiene el turno ahora
    public void mostrarTurnoActual() {
        if (mesa.isEmpty()) {
            System.out.println("No quedan jugadores.");
            return;
        }
        Object j = mesa.getCurrent().getNodeValue();
        System.out.println("Turno actual: " + j);
    }
 
    // Busca un jugador por nombre
    public void buscar(String nombre) {
        var nodo = mesa.search(nombre);
        System.out.println(nodo != null
            ? "Encontrado: " + nodo.getNodeValue()
            : "Jugador no encontrado: " + nombre);
    }
 
    // Muestra todos los jugadores de la mesa
    public void mostrarMesa() {
        System.out.println("Mesa de juego");
        mesa.showAll();
       
    }
}

