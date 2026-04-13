public class Main {
    public static void main(String[] args) {
 
        SistemaMusica app = new SistemaMusica();
 
        app.agregarCancion("Bohemian Rhapsody", "Queen");
        app.agregarCancion("Hotel California",  "Eagles");
        app.agregarCancion("Stairway to Heaven","Led Zeppelin");
        app.agregarCancion("Imagine",            "John Lennon");
 
        app.mostrarPlaylist();
        app.mostrarActual();
        app.siguiente();
        app.siguiente();
        app.siguiente();
        app.siguiente(); // vuelve al inicio automáticamente
 
        app.eliminarCancion("Hotel California");
        app.mostrarPlaylist();
 
        app.buscar("Imagine");
        app.buscar("Thriller");
    }
}


