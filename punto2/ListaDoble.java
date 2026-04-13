import java.util.Iterator;
 
public class ListaDoble<T> implements Iterable<T> {
 
    private Nodo<T> head;
    private Nodo<T> tail;
    private Nodo<T> current;
    private int size;
 
    public ListaDoble() { head = null; tail = null; current = null; size = 0; }
 
    // Agregar página después del nodo actual y truncar el futuro — O(1)
    public void addAfterCurrent(T value) {
        Nodo<T> nuevo = new Nodo<>(value);
        if (current == null) {
            head = nuevo; tail = nuevo; current = nuevo;
        } else {
            current.setNext(nuevo);
            nuevo.setPrev(current);
            tail = nuevo;
            current = nuevo;
        }
        size++;
    }
 
    // Retroceder al nodo anterior — O(1)
    public boolean goBack() {
        if (current == null || current.getPrev() == null) return false;
        current = (Nodo<T>) current.getPrev();
        return true;
    }
 
    // Avanzar al nodo siguiente — O(1)
    public boolean goForward() {
        if (current == null || current.getNext() == null) return false;
        current = current.getNext();
        return true;
    }
 
    // Buscar por toString — O(n)
    public Nodo<T> search(String valor) {
        Nodo<T> temp = head;
        while (temp != null) {
            if (temp.getNodeValue().toString().contains(valor)) return temp;
            temp = temp.getNext();
        }
        return null;
    }
 
    public Nodo<T> getCurrent() { return current; }
    public boolean isEmpty()    { return head == null; }
    public int getSize()        { return size; }
 
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Nodo<T> temp = head;
            public boolean hasNext() { return temp != null; }
            public T next() { T v = (T) temp.getNodeValue(); temp = temp.getNext(); return v; }
        };
    }
}

