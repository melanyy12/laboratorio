public class SistemaHistorial {
 
    private ListaDoble<Pagina> historial = new ListaDoble<>();
 
    public SistemaHistorial() {}
 
    public ListaDoble<Pagina> getHistorial() { return historial; }
 
    // Visita nueva página: inserta después del actual y trunca el futuro
    public void visitarPagina(String url, String titulo) {
        Pagina p = new Pagina(url, titulo);
        historial.addAfterCurrent(p);
        System.out.println("Visitando: " + p);
    }
 
    // Retrocede a la página anterior
    public void retroceder() {
        if (!historial.goBack()) {
            System.out.println("Ya estás en la primera página.");
            return;
        }
        Object p = historial.getCurrent().getNodeValue();
        System.out.println("Retrocediendo a: " + p);
    }
 
    // Avanza a la página siguiente
    public void avanzar() {
        if (!historial.goForward()) {
            System.out.println("No hay páginas hacia adelante.");
            return;
        }
        Object p = historial.getCurrent().getNodeValue();
        System.out.println("Avanzando a: " + p);
    }
 
    // Muestra la página que se está viendo ahora
    public void mostrarActual() {
        if (historial.isEmpty()) {
            System.out.println("Historial vacío.");
            return;
        }
        Object p = historial.getCurrent().getNodeValue();
        System.out.println("Página actual: " + p);
    }
 
    // Busca una URL en el historial
    public void buscar(String url) {
        var nodo = historial.search(url);
        if (nodo != null) System.out.println("Encontrado: " + nodo.getNodeValue());
        else System.out.println("URL no encontrada: " + url);
    }
 
    // Muestra todo el historial desde la primera página
    public void mostrarHistorial() {
        System.out.println("Historial");
        int pos = 1;
        for (Object pg : historial) {
            boolean esActual = pg == historial.getCurrent().getNodeValue();
            System.out.println("  " + pos++ + ". " + pg + (esActual ? " <- ACTUAL" : ""));
        }
        
    }
}


