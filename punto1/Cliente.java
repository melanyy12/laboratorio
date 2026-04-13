public class Cliente {
    private String nombre;
    private int turno;
 
    public Cliente(String nombre, int turno) {
        this.nombre = nombre;
        this.turno  = turno;
    }
 
    public String getNombre() { return nombre; }
    public int getTurno()     { return turno; }
 
    @Override
    public String toString() {
        return "Turno #" + turno + " - " + nombre;
    }
}

