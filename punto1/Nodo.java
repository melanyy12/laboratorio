class Nodo {
    String cliente;   
    int    turno;     
    Nodo   siguiente; 

    public Nodo(String cliente, int turno) {
        this.cliente   = cliente;
        this.turno     = turno;
        this.siguiente = null;
    }
}