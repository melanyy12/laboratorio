

public class ListaReproduccion<T> {

    private Nodo<T> nodoPrimero;
    private Nodo<T> nodoUltimo;
    private Nodo<T> actual;
    private int tamanio;

    public ListaReproduccion() {
        nodoPrimero = null;
        nodoUltimo = null;
        actual = null;
        tamanio = 0;
    }

    // Verificar si está vacía
    public boolean estaVacia() {
        return nodoPrimero == null;
    }

    //  AGREGAR canción
    public void agregar(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);

        if (estaVacia()) {
            nodoPrimero = nodoUltimo = nuevo;
            nuevo.setSiguienteNodo(nuevo); // circular
            actual = nodoPrimero;
        } else {
            nuevo.setSiguienteNodo(nodoPrimero);
            nodoUltimo.setSiguienteNodo(nuevo);
            nodoUltimo = nuevo;
        }

        tamanio++;
    }

    //  SIGUIENTE canción (CLAVE del escenario)
    public T siguiente() {
        if (estaVacia()) {
            throw new RuntimeException("Lista vacía");
        }

        if (actual == null) {
            actual = nodoPrimero;
        } else {
            actual = actual.getSiguienteNodo();
        }

        return actual.getValorNodo();
    }

    //  ELIMINAR canción
    public void eliminar(T valor) {

        if (estaVacia()) {
            throw new RuntimeException("Lista vacía");
        }

        Nodo<T> aux = nodoPrimero;
        Nodo<T> anterior = nodoUltimo;

        do {
            if (aux.getValorNodo().equals(valor)) {

                // Caso: solo un nodo
                if (nodoPrimero == nodoUltimo) {
                    nodoPrimero = nodoUltimo = actual = null;
                } else {

                    anterior.setSiguienteNodo(aux.getSiguienteNodo());

                    if (aux == nodoPrimero) {
                        nodoPrimero = aux.getSiguienteNodo();
                        nodoUltimo.setSiguienteNodo(nodoPrimero);
                    }

                    if (aux == nodoUltimo) {
                        nodoUltimo = anterior;
                    }

                    if (aux == actual) {
                        actual = aux.getSiguienteNodo();
                    }
                }

                tamanio--;
                return;
            }

            anterior = aux;
            aux = aux.getSiguienteNodo();

        } while (aux != nodoPrimero);

        throw new RuntimeException("No existe la canción");
    }

    //  BUSCAR canción
    public boolean buscar(T valor) {

        if (estaVacia()) return false;

        Nodo<T> aux = nodoPrimero;

        do {
            if (aux.getValorNodo().equals(valor)) {
                return true;
            }
            aux = aux.getSiguienteNodo();
        } while (aux != nodoPrimero);

        return false;
    }

    //  MOSTRAR lista
    public void mostrar() {

        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }

        Nodo<T> aux = nodoPrimero;

        do {
            System.out.print(aux.getValorNodo() + " -> ");
            aux = aux.getSiguienteNodo();
        } while (aux != nodoPrimero);

        System.out.println("(vuelve al inicio)");
    }
}