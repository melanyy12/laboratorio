public class Main {
    public static void main(String[] args) {

        Historial nav = new Historial();

        nav.visitar("https://google.com",    "Google");
        nav.visitar("https://github.com",    "GitHub");
        nav.visitar("https://docs.java.com", "Java Docs");
        nav.visitar("https://stackoverflow.com", "Stack Overflow");

        System.out.println();
        nav.mostrar();

        System.out.println();
        nav.retroceder();   
        nav.retroceder();   

        System.out.println();
        nav.paginaActual(); 

        System.out.println();
        nav.avanzar();      

        System.out.println();
        // Visitar nueva página: elimina Stack Overflow del historial futuro
        nav.visitar("https://wikipedia.org", "Wikipedia");

        System.out.println();
        nav.mostrar();      

        System.out.println();
        nav.avanzar();      

        System.out.println();
        nav.buscar("https://github.com");
        nav.buscar("https://stackoverflow.com"); 
    }
}