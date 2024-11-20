
import java.util.*;

public class GestionarProductos extends Json{

    static Scanner scanner = new Scanner(System.in);
    public static void agregarProducto() {
        cargarDatosDesdeJson();
        System.out.print("Ingrese el ID del producto: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer
        cargarDatosDesdeJson();
        GestionarCategoria.mostrarCategorias();
        System.out.print("Ingrese el ID de la categoría para registrar el producto: ");
        int categoriaId = scanner.nextInt();
        scanner.nextLine();

        Categoria categoria = buscarCategoriaPorId(categoriaId);
        if (categoria == null) {
            System.out.println("Categoría no encontrada.");
            return;
        }

        Producto producto = new Producto(id, nombre, precio);
        categoria.addProducto(producto);
        getProductos().add(producto);
        guardarDatosEnJson();
        System.out.println("Producto agregado correctamente.");
    }

    public static void mostrarProductos() {
        cargarDatosDesdeJson();
        if (getProductos().isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            System.out.println("Categorías disponibles:");
            for (Producto producto : getProductos()) {
                System.out.println("ID: " + producto.getId() + " - Nombre: " + producto.getNombre());

            }
        }
    }
    public static void modificarProducto() {
        cargarDatosDesdeJson();
        System.out.print("Ingrese el ID del producto a modificar: ");
        int productoId = scanner.nextInt();
        scanner.nextLine();

        for (Producto producto : getProductos()) {
            if (producto.getId() == productoId) {
                System.out.print("Ingrese el nuevo precio del producto: ");
                producto.setPrecio(scanner.nextDouble());
                scanner.nextLine();
                guardarDatosEnJson();
                System.out.println("Producto modificado correctamente.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }
    public static void eliminarProducto() {
        cargarDatosDesdeJson();
        System.out.print("Ingrese el ID del producto a eliminar: ");
        int productoId = scanner.nextInt();
        scanner.nextLine();

        getProductos().removeIf(producto -> producto.getId() == productoId);
        for (Categoria categoria : getCategorias()) {
            categoria.getProductos().removeIf(producto -> producto.getId() == productoId);
        }
        guardarDatosEnJson();
        System.out.println("Producto eliminado correctamente.");
    }
}
