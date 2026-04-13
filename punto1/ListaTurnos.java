import java.util.Iterator;
 
public class ListaTurnos<T> implements Iterable<T> {
 
    private Nodo<T> head;
    private Nodo<T> tail;
    private int size;
 
    public ListaTurnos() { head = null; tail = null; size = 0; }
 
    // Agregar al final — O(1)
    public void addLast(T value) {
        Nodo<T> nuevo = new Nodo<>(value);
        if (tail == null) { head = nuevo; tail = nuevo; }
        else { tail.setNext(nuevo); tail = nuevo; }
        size++;
    }
 
    // Eliminar primero — O(1)
    public void removeFirst() {
        if (head == null) throw new RuntimeException("Lista vacía");
        head = head.getNext();
        if (head == null) tail = null;
        size--;
    }
 
    // Buscar por toString — O(n)
    public Nodo<T> search(String valor) {
        Nodo<T> actual = head;
        while (actual != null) {
            if (actual.getNodeValue().toString().contains(valor)) return actual;
            actual = actual.getNext();
        }
        return null;
    }
 
    public Nodo<T> getFirstNode() { return head; }
    public boolean isEmpty()       { return head == null; }
    public int getSize()           { return size; }
 
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Nodo<T> actual = head;
            public boolean hasNext() { return actual != null; }
            public T next() { T v = (T) actual.getNodeValue(); actual = actual.getNext(); return v; }
        };
    }
}

