public class ListaCircularDoble<T> {
 
    private Nodo<T> current;
    private int size;
 
    public ListaCircularDoble() { current = null; size = 0; }
 
    // Agregar jugador al final del ciclo — O(1)
    public void addLast(T value) {
        Nodo<T> nuevo = new Nodo<>(value);
        if (current == null) {
            nuevo.setNext(nuevo);
            nuevo.setPrev(nuevo);
            current = nuevo;
        } else {
            Nodo<T> last = current.getPrev();
            last.setNext(nuevo);
            nuevo.setPrev(last);
            nuevo.setNext(current);
            current.setPrev(nuevo);
        }
        size++;
    }
 
    // Avanzar al siguiente jugador — O(1)
    public void next() {
        if (current != null) current = current.getNext();
    }
 
    // Retroceder al jugador anterior — O(1)
    public void prev() {
        if (current != null) current = current.getPrev();
    }
 
    // Eliminar jugador actual y avanzar el turno — O(1)
    public void removeCurrent() {
        if (current == null) return;
        if (size == 1) { current = null; size = 0; return; }
        Nodo<T> prevNode = current.getPrev();
        Nodo<T> nextNode = current.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
        current = nextNode;
        size--;
    }
 
    // Buscar jugador — O(n)
    public Nodo<T> search(String valor) {
        if (current == null) return null;
        Nodo<T> inicio = current;
        Nodo<T> temp   = current;
        do {
            if (temp.getNodeValue().toString().contains(valor)) return temp;
            temp = temp.getNext();
        } while (temp != inicio);
        return null;
    }
 
    // Mostrar todos los jugadores del ciclo — O(n)
    public void showAll() {
        if (current == null) return;
        Nodo<T> inicio = current;
        Nodo<T> temp   = current;
        int pos = 1;
        do {
            boolean esCurrent = temp == current;
            System.out.println("  " + pos++ + ". " + temp.getNodeValue()
                + (esCurrent ? " <- TURNO ACTUAL" : ""));
            temp = temp.getNext();
        } while (temp != inicio);
    }
 
    public Nodo<T> getCurrent() { return current; }
    public boolean isEmpty()    { return current == null; }
    public int getSize()        { return size; }
}


