public class Main {
    public static void main(String[] args) {
 
        SistemaPanaderia sistema = new SistemaPanaderia();
 
        sistema.registerClient("Ana García");
        sistema.registerClient("Luis Pérez");
        sistema.registerClient("María López");
        sistema.registerClient("Carlos Ruiz");
 
        sistema.showClients();
        sistema.showNextClient();
        sistema.attendClient();
        sistema.showClients();
        sistema.attendClient();
        sistema.attendClient();
        sistema.attendClient();
        sistema.attendClient(); // fila vacía
    }
}

