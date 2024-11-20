import java.util.*;
public class Comprador {
    static Scanner s = new Scanner(System.in);

    // Método para mostrar el menú y manejar el flujo del CRUD
    public void crud_usuario() {
        boolean continuar = true;// Bandera para controlar el bucle del menú
        Mostrar_productos mostrarProductos = new Mostrar_productos();
        mostrarProductos.mostrar();

        while (continuar) {
            System.out.println("\n--- MENÚ DE NAVEGACIÓN ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Actualizar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = validador(); // Llamada al validador para obtener la opción
            switch (opcion) {
                case 1:
                    System.out.println("Seleccionó agregar producto.");
                    // Llamar al método que maneja la lógica para agregar producto
                    break;
                case 2:
                    System.out.println("Seleccionó actualizar producto.");
                    // Llamar al método que maneja la lógica para actualizar producto
                    break;
                case 3:
                    System.out.println("Seleccionó eliminar producto.");
                    // Llamar al método que maneja la lógica para eliminar producto
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    continuar = false; // Salir del bucle y terminar el programa
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
    public int validador(){
        int valor;
        while(!s.hasNextInt()){
            System.out.print("Enter a integer numnber please: ");
            s.next();
        }
        valor = s.nextInt();
        // creamos un while para validar que la entrada no sea menor a cero
        while(valor < 0){
            System.out.print("enter a integer number greater than zero: ");
            valor = s.nextInt();
        }
        return valor;
    }
}
class Mostrar_productos{
    // se crea un metodo para mostrar los productos
    public Mostrar_productos(){
        // se crea un cosntructor vacio
    }
    public void mostrar(){
        GestionarProductos.cargarDatosDesdeJson();
    }
}
class Compra_productos{
    private int cantidad;
    private double suma;
    private boolean decision;
    // se crea un constructor vacio
    public Compra_productos(){
        // constructor vacio
    }

}