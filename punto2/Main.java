public class Main {
    public static void main(String[] args) {
 
        SistemaHistorial nav = new SistemaHistorial();
 
        nav.visitarPagina("https://google.com",    "Google");
        nav.visitarPagina("https://github.com",    "GitHub");
        nav.visitarPagina("https://docs.java.com", "Java Docs");
        nav.visitarPagina("https://stackoverflow.com", "Stack Overflow");
 
        nav.mostrarHistorial();
        nav.retroceder();
        nav.retroceder();
        nav.mostrarActual();
        nav.avanzar();
        nav.visitarPagina("https://wikipedia.org", "Wikipedia");
        nav.mostrarHistorial();
        nav.avanzar();
        nav.buscar("github.com");
        nav.buscar("stackoverflow.com");
    }
}

