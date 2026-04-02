class Historial {
    private Nodo cabeza;  
    private Nodo actual;  

    public Historial() {
        cabeza = null;
        actual = null;
    }

    
    // Inserta después del nodo actual y elimina el historial futuro
    public void visitar(String url, String titulo) {
        Nodo nuevo = new Nodo(url);

        if (actual == null) {         
            cabeza = nuevo;
            actual = nuevo;
        } else {
            // Truncar historial futuro: eliminar nodos después del actual
            actual.siguiente = nuevo; 
            nuevo.anterior   = actual; 
            actual = nuevo;            
        }
        System.out.println("Visitando: [" + titulo + "] " + url);
    }

   
    // Mueve el puntero actual al nodo anterior
    public void retroceder() {
        if (actual == null) {
            System.out.println("El historial está vacío.");
            return;
        }
        if (actual.anterior == null) {
            System.out.println("Ya estás en la primera página visitada.");
            return;
        }
        actual = (Nodo) actual.anterior;
        System.out.println("Retrocediendo a: [" + actual.titulo + "] " + actual.url);
    }

    
    // Mueve el puntero actual al nodo siguiente
    public void avanzar() {
        if (actual == null) {
            System.out.println("El historial está vacío.");
            return;
        }
        if (actual.siguiente == null) {
            System.out.println("No hay páginas hacia adelante.");
            return;
        }
        actual = actual.siguiente;
        System.out.println("Avanzando a: [" + actual.titulo + "] " + actual.url);
    }

    
    // Busca una URL en todo el historial (desde cabeza)
    public void buscar(String url) {
        Nodo temp = cabeza;
        int  pos  = 1;
        while (temp != null) {
            if (temp.url.equalsIgnoreCase(url)) {
                System.out.println("Encontrado en posición " + pos
                    + ": [" + temp.titulo + "] " + temp.url
                    + (temp == actual ? "  ACTUAL" : ""));
                return;
            }
            temp = temp.siguiente;
            pos++;
        }
        System.out.println("URL no encontrada en el historial: " + url);
    }

    
    // Muestra todo el historial marcando la página actual
    public void mostrar() {
        if (cabeza == null) {
            System.out.println("El historial está vacío.");
            return;
        }
        System.out.println(" Historial de navegación ");
        Nodo temp = cabeza;
        int  pos  = 1;
        while (temp != null) {
            String marca = (temp == actual) ? "  ACTUAL" : "";
            System.out.println("  " + pos + ". [" + temp.titulo + "] "
                             + temp.url + marca);
            temp = temp.siguiente;
            pos++;
        }
        
    }

    
    public void paginaActual() {
        if (actual == null) {
            System.out.println("No hay ninguna página activa.");
        } else {
            System.out.println("Página actual: [" + actual.titulo + "] " + actual.url);
        }
    }
}