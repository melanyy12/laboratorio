class ListaTurnos {
    private Nodo cabeza;
    private Nodo cola;
    private int contador;

    public ListaTurnos() {
        cabeza = null;
        cola = null;
        contador = 0;
    }

    // Registra un nuevo cliente al final de la fila
    public void agregar(String nombreCliente) {
        contador++;
        Nodo nuevo = new Nodo(nombreCliente);

        if (cola == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
        }
        System.out.println(" Cliente registrado: " + nombreCliente
                + " | Turno #" + contador);
    }

    // Atiende (elimina) al primer cliente de la fila
    public void atenderSiguiente() {
        if (cabeza == null) {
            System.out.println(" No hay clientes en espera.");
            return;
        }
        System.out.println(" Atendiendo: " + cabeza.cliente
                + " | Turno #" + cabeza.turno);
        cabeza = cabeza.siguiente;
        if (cabeza == null) {
            cola = null;
        }
    }

    // Consulta si un cliente está en la fila (por nombre)
    public void buscar(String nombreCliente) {
        Nodo actual = cabeza;
        int pos = 1;
        while (actual != null) {
            if (actual.cliente.equalsIgnoreCase(nombreCliente)) {
                System.out.println(" Cliente encontrado: " + actual.cliente
                        + " | Turno #" + actual.turno
                        + " | Posición en fila: " + pos);
                return;
            }
            actual = actual.siguiente;
            pos++;
        }
        System.out.println(" Cliente '" + nombreCliente + "' no está en la fila.");
    }

    // Consulta quién es el próximo sin eliminarlo
    public void verSiguiente() {
        if (cabeza == null) {
            System.out.println(" La fila está vacía.");
        } else {
            System.out.println(" Siguiente en ser atendido: " + cabeza.cliente
                    + "  Turno #" + cabeza.turno);
        }
    }

    // Muestra toda la fila de espera
    public void mostrar() {
        if (cabeza == null) {
            System.out.println("La fila está vacía.");
            return;
        }
        System.out.println(" Fila de turnos actual");
        Nodo actual = cabeza;
        int pos = 1;
        while (actual != null) {
            System.out.println("  " + pos + ". " + actual.cliente
                    + " (Turno #" + actual.turno + ")");
            actual = actual.siguiente;
            pos++;
        }

    }

}