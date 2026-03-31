

public class Main {

    public static void main(String[] args) {

        ListaReproduccion<String> lista = new ListaReproduccion<>();

        lista.agregar("Cancion 1");
        lista.agregar("Cancion 2");
        lista.agregar("Cancion 3");

        System.out.println("Lista de reproducción:");
        lista.mostrar();

        System.out.println("\nReproduciendo:");
        System.out.println(lista.siguiente());
        System.out.println(lista.siguiente());
        System.out.println(lista.siguiente());
        System.out.println(lista.siguiente()); // vuelve al inicio 

        System.out.println("\nEliminar Cancion 2");
        lista.eliminar("Cancion 2");

        System.out.println("\nLista actualizada:");
        lista.mostrar();

        System.out.println("\nBuscar Cancion 3:");
        System.out.println(lista.buscar("Cancion 3"));
    }
}