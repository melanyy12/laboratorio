public class Nodo<T> {
    private T nodeValue;
    private Nodo<T> next;
 
    public Nodo(T nodeValue) {
        this.nodeValue = nodeValue;
        this.next = null;
    }
 
    public T getNodeValue() { return nodeValue; }
    public void setNodeValue(T nodeValue) { this.nodeValue = nodeValue; }
    public Nodo<T> getNext() { return next; }
    public void setNext(Nodo<T> next) { this.next = next; }
}

