class Nodo {
    String url;       
    String titulo;    
    Nodo   siguiente; 
    Nodo   anterior;  

    public Nodo(String url, String titulo) {
        this.url       = url;
        this.titulo    = titulo;
        this.siguiente = null;
        this.anterior  = null;
    }
}