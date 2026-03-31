

public class ListaJuego<T> {

    private NodoDoble<T> nodoPrimero;
    private NodoDoble<T> nodoUltimo;
    private NodoDoble<T> actual;
    private int tamanio;

    // AGREGAR jugador
    public void agregar(T valor) {

        NodoDoble<T> nuevo = new NodoDoble<>(valor);

        if (nodoPrimero == null) {
            nodoPrimero = nodoUltimo = nuevo;
            nuevo.setSiguienteNodo(nuevo);
            nuevo.setAnteriorNodo(nuevo);
            actual = nuevo;
        } else {
            nuevo.setAnteriorNodo(nodoUltimo);
            nuevo.setSiguienteNodo(nodoPrimero);

            nodoUltimo.setSiguienteNodo(nuevo);
            nodoPrimero.setAnteriorNodo(nuevo);

            nodoUltimo = nuevo;
        }

        tamanio++;
    }

    // SIGUIENTE turno
    public T siguiente() {
        if (actual == null) return null;
        actual = actual.getSiguienteNodo();
        return actual.getValorNodo();
    }

    // TURNO ANTERIOR
    public T anterior() {
        if (actual == null) return null;
        actual = actual.getAnteriorNodo();
        return actual.getValorNodo();
    }

    // ELIMINAR jugador
    public void eliminar(T valor) {

        if (nodoPrimero == null) {
            throw new RuntimeException("Lista vacía");
        }

        NodoDoble<T> aux = nodoPrimero;
        int cont = 0;

        while (cont < tamanio) {

            if (aux.getValorNodo().equals(valor)) {

                if (tamanio == 1) {
                    nodoPrimero = nodoUltimo = actual = null;
                } else {

                    NodoDoble<T> anterior = aux.getAnteriorNodo();
                    NodoDoble<T> siguiente = aux.getSiguienteNodo();

                    anterior.setSiguienteNodo(siguiente);
                    siguiente.setAnteriorNodo(anterior);

                    if (aux == nodoPrimero) {
                        nodoPrimero = siguiente;
                    }

                    if (aux == nodoUltimo) {
                        nodoUltimo = anterior;
                    }

                    if (aux == actual) {
                        actual = siguiente;
                    }
                }

                tamanio--;
                return;
            }

            aux = aux.getSiguienteNodo();
            cont++;
        }

        throw new RuntimeException("Jugador no encontrado");
    }

    // BUSCAR jugador
    public boolean buscar(T valor) {

        NodoDoble<T> aux = nodoPrimero;
        int cont = 0;

        while (cont < tamanio) {
            if (aux.getValorNodo().equals(valor)) {
                return true;
            }
            aux = aux.getSiguienteNodo();
            cont++;
        }

        return false;
    }

    // MOSTRAR jugadores
    public void mostrar() {

        if (nodoPrimero == null) {
            System.out.println("Lista vacía");
            return;
        }

        NodoDoble<T> aux = nodoPrimero;
        int cont = 0;

        while (cont < tamanio) {
            System.out.print(aux.getValorNodo() + " -> ");
            aux = aux.getSiguienteNodo();
            cont++;
        }

        System.out.println("(vuelve al inicio)");
    }
}