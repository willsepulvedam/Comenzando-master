import com.google.gson.stream.JsonToken;

import java.util.Scanner;

public class GestionarCategoria extends Json{

    static Scanner scanner = new Scanner(System.in);
    // Agregar una nueva categoría
    public static void agregarCategoria() {
        cargarDatosDesdeJson();
        System.out.print("Ingrese el ID de la categoria: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nombre de la nueva categoría: ");
        String nombre = scanner.nextLine().trim();

        // Validación de entrada
        if (nombre.isEmpty()) {
            System.out.println("El nombre de la categoría no puede estar vacío.");
            return;
        }

        // Crear la nueva categoría con un ID único
        Categoria categoria = new Categoria(id, nombre);
        getCategorias().add(categoria);
        guardarDatosEnJson();

        System.out.println("Categoría '" + nombre + "' agregada con éxito.");
    }


    // Mostrar todas las categorías
    public static void mostrarCategorias() {
        cargarDatosDesdeJson(); // Asegurarse de que las categorías se carguen desde JSON
        if (getCategorias().isEmpty()) {
            System.out.println("No hay categorías disponibles.");
        } else {
            System.out.println("Categorías disponibles:");
            for (Categoria categoria : getCategorias()) {
                System.out.println("ID: " + categoria.getId() + " - Nombre: " + categoria.getNombre());
            }
        }
    }

    // Modificar una categoría existente
    public static void modificarCategoria() {
        cargarDatosDesdeJson();
        System.out.print("Ingrese el ID de la categoría a modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Categoria categoria = buscarCategoriaPorId(id);
        if (categoria != null) {
            System.out.print("Ingrese el nuevo nombre de la categoría: ");
            String nuevoNombre = scanner.nextLine();
            categoria.setNombre(nuevoNombre);

            guardarDatosEnJson();
            System.out.println("Categoría modificada correctamente.");
        } else {
            System.out.println("Categoría no encontrada.");
        }
    }

    // Eliminar una categoría
    public static void eliminarCategoria() {
        cargarDatosDesdeJson();
        System.out.print("Ingrese el ID de la categoría a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Categoria categoria = buscarCategoriaPorId(id);
        if (categoria != null) {
            getCategorias().remove(categoria);
            guardarDatosEnJson();
            System.out.println("Categoría eliminada correctamente.");
        } else {
            System.out.println("Categoría no encontrada.");
        }
    }
}
