public class SistemaMusica {
 
    private ListaCircularSimple<Cancion> playlist = new ListaCircularSimple<>();
 
    public SistemaMusica() {}
 
    public ListaCircularSimple<Cancion> getPlaylist() { return playlist; }
 
    // Agrega canción al final de la playlist
    public void agregarCancion(String titulo, String artista) {
        Cancion c = new Cancion(titulo, artista);
        playlist.addLast(c);
        System.out.println("Canción agregada: " + c);
    }
 
    // Avanza a la siguiente canción (vuelve al inicio automáticamente)
    public void siguiente() {
        playlist.next();
        Object c = playlist.getCurrent().getNodeValue();
        System.out.println("Reproduciendo: " + c);
    }
 
    // Muestra la canción que se reproduce ahora
    public void mostrarActual() {
        if (playlist.isEmpty()) {
            System.out.println("La playlist está vacía.");
            return;
        }
        Object c = playlist.getCurrent().getNodeValue();
        System.out.println("Reproduciendo ahora: " + c);
    }
 
    // Elimina una canción por título
    public void eliminarCancion(String titulo) {
        boolean ok = playlist.remove(titulo);
        System.out.println(ok
            ? "Canción eliminada: " + titulo
            : "No se encontró: " + titulo);
    }
 
    // Busca una canción
    public void buscar(String titulo) {
        var nodo = playlist.search(titulo);
        System.out.println(nodo != null
            ? "Encontrada: " + nodo.getNodeValue()
            : "No encontrada: " + titulo);
    }
 
    // Muestra toda la secuencia actual
    public void mostrarPlaylist() {
        System.out.println(" Playlist ");
        playlist.showAll();
        
    }
}


