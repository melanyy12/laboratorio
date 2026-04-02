public class Main {
    public static void main(String[] args) {

        ListaTurnos fila = new ListaTurnos();

        // Registrar clientes
        fila.agregar("Ana García");
        fila.agregar("Luis Pérez");
        fila.agregar("María López");
        fila.agregar("Carlos Ruiz");

        System.out.println();
        fila.mostrar();

        System.out.println();
        fila.verSiguiente();          

        System.out.println();
        fila.atenderSiguiente();       

        System.out.println();
        fila.mostrar();                

        System.out.println();
        fila.buscar("María López");    
        fila.buscar("Pedro Jiménez"); 

        System.out.println();
        fila.atenderSiguiente();       
        fila.atenderSiguiente();       
        fila.atenderSiguiente();       
        fila.atenderSiguiente();       
    }
}
