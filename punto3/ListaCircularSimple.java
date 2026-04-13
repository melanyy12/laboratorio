public class ListaCircularSimple<T> {
 
    private Nodo<T> tail;   // apunta al último; tail.next = head
    private Nodo<T> current;
    private int size;
 
    public ListaCircularSimple() { tail = null; current = null; size = 0; }
 
    // Agregar al final — O(1)
    public void addLast(T value) {
        Nodo<T> nuevo = new Nodo<>(value);
        if (tail == null) {
            tail = nuevo;
            tail.setNext(tail);  // apunta a sí mismo
            current = tail;
        } else {
            nuevo.setNext(tail.getNext());  // nuevo -> head
            tail.setNext(nuevo);            // tail -> nuevo
            tail = nuevo;                   // tail avanza
        }
        size++;
    }
 
    // Avanzar a la siguiente canción (nunca null) — O(1)
    public void next() {
        if (current != null) current = current.getNext();
    }
 
    // Eliminar canción por valor toString — O(n)
    public boolean remove(String valor) {
        if (tail == null) return false;
        Nodo<T> head = tail.getNext();
        Nodo<T> prev = tail;
        Nodo<T> temp = head;
        do {
            if (temp.getNodeValue().toString().contains(valor)) {
                if (size == 1) { tail = null; current = null; size = 0; return true; }
                prev.setNext(temp.getNext());
                if (temp == tail) tail = prev;
                if (temp == current) current = temp.getNext();
                size--;
                return true;
            }
            prev = temp;
            temp = temp.getNext();
        } while (temp != head);
        return false;
    }
 
    // Buscar canción — O(n)
    public Nodo<T> search(String valor) {
        if (tail == null) return null;
        Nodo<T> head = tail.getNext();
        Nodo<T> temp = head;
        do {
            if (temp.getNodeValue().toString().contains(valor)) return temp;
            temp = temp.getNext();
        } while (temp != head);
        return null;
    }
 
    public Nodo<T> getCurrent() { return current; }
    public boolean isEmpty()    { return tail == null; }
    public int getSize()        { return size; }
 
    // Mostrar una vuelta completa — O(n)
    public void showAll() {
        if (tail == null) return;
        Nodo<T> head = tail.getNext();
        Nodo<T> temp = head;
        int pos = 1;
        do {
            boolean esCurrent = temp == current;
            System.out.println("  " + pos++ + ". " + temp.getNodeValue()
                + (esCurrent ? " REPRODUCIENDO" : ""));
            temp = temp.getNext();
        } while (temp != head);
    }
}

