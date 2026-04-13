public class SistemaPanaderia {
 
    private ListaTurnos<Cliente> listClient = new ListaTurnos<>();
    private int contador = 0;
 
    public SistemaPanaderia() {}
 
    public ListaTurnos<Cliente> getListClient() { return listClient; }
    public void setListClient(ListaTurnos<Cliente> l) { this.listClient = l; }
 
    // Registra un nuevo cliente al final de la fila
    public void registerClient(String nombre) {
        contador++;
        Cliente c = new Cliente(nombre, contador);
        listClient.addLast(c);
        System.out.println("Registrado: " + c);
    }
 
    // Atiende (elimina) al primer cliente
    public void attendClient() {
        if (listClient.isEmpty()) {
            System.out.println("No hay clientes en espera.");
            return;
        }
        Object cliente = listClient.getFirstNode().getNodeValue();
        System.out.println("Atendiendo: " + cliente);
        listClient.removeFirst();
    }
 
    // Muestra quién es el siguiente sin atenderlo
    public void showNextClient() {
        if (listClient.isEmpty()) {
            System.out.println("La fila está vacía.");
            return;
        }
        Object cliente = listClient.getFirstNode().getNodeValue();
        System.out.println("Siguiente: " + cliente);
    }
 
    // Muestra toda la fila actual
    public void showClients() {
        System.out.println("Fila actual ");
        int pos = 1;
        for (Object t : listClient) {
            System.out.println("  " + pos++ + ". " + t);
        }
      
    }
}

