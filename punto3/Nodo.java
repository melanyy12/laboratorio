

public class Nodo<T> {

    private T valorNodo;
    private Nodo<T> siguienteNodo;

    public Nodo(T valorNodo) {
        this.valorNodo = valorNodo;
        this.siguienteNodo = null;
    }

    public T getValorNodo() {
        return valorNodo;
    }

    public void setValorNodo(T valorNodo) {
        this.valorNodo = valorNodo;
    }

    public Nodo<T> getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(Nodo<T> siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }
}