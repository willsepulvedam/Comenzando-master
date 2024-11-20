import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Json {
    private static Gson gson = new Gson();
    private static final String JSON_FILE = "C:\\Users\\Flia Seplveda Mendoz\\Desktop\\WILL\\JAVA\\Comenzando\\Comenzando-master\\ecommerce.json";
    private static List<Producto> productos = new ArrayList<>();
    private static List<Categoria> categorias = new ArrayList<>();

    public static List<Categoria> getCategorias() {
        return categorias;
    }

    public static List<Producto> getProductos() {
        return productos;
    }

    public static void cargarDatosDesdeJson() {
        try (FileReader reader = new FileReader(JSON_FILE)) {
            Type containerType = new TypeToken<CategoriasContainer>() {}.getType();
            CategoriasContainer container = gson.fromJson(reader, containerType);

            // Si el contenedor no es nulo, asignamos las categorías y productos
            if (container != null) {
                categorias = container.getCategorias();
                productos = container.getProductos();
            } else {
                categorias = new ArrayList<>();
                productos = new ArrayList<>();
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
    }

    public static void guardarDatosEnJson() {
        try (FileWriter writer = new FileWriter(JSON_FILE)) {
            // Creamos un contenedor que contenga las categorías y productos
            CategoriasContainer container = new CategoriasContainer();
            container.setCategorias(categorias);
            container.setProductos(productos);

            // Serializamos el contenedor a JSON
            gson.toJson(container, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    static Categoria buscarCategoriaPorId(int id) {
        cargarDatosDesdeJson();
        for (Categoria categoria : getCategorias()) {
            if (categoria.getId() == id) {
                return categoria;
            }
        }
        return null;

    }
}
