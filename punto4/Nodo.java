public class Nodo<T> {
    private T nodeValue;
    private Nodo<T> next;
    private Nodo<T> prev;
 
    public Nodo(T nodeValue) {
        this.nodeValue = nodeValue;
        this.next = null;
        this.prev = null;
    }
 
    public T getNodeValue()        { return nodeValue; }
    public void setNodeValue(T v)  { this.nodeValue = v; }
    public Nodo<T> getNext()       { return next; }
    public void setNext(Nodo<T> n) { this.next = n; }
    public Nodo<T> getPrev()       { return prev; }
    public void setPrev(Nodo<T> p) { this.prev = p; }
}

