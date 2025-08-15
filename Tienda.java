import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tienda {
    private Map<String, Productos> productos;           // Utilizando MAP para mostrar producto formateado
    private Map<String, Clientes> clientes;             // Utilizando MAP para mostrar cliente formateado
    private List<Ventas> ventas;
    private int count = 0;                              // Contador para crear Folio

    public Tienda(){
        this.productos = new HashMap<>();
        this.clientes = new HashMap<>();
        this.ventas = new ArrayList<>();
    }
    
    // >>>>>>>>>> ADMINISTRADOR DE PRODUCTOS <<<<<<<<<<
    public void addProducto(int codigo, String nombre, double precio, String categoria, int stock){
        if(productos.containsKey(nombre.toLowerCase())){
            System.out.println("Error: El Producto con nombre '" + nombre + "' ya existe.");
            return;
        }
        Productos newProduto = new Productos(codigo, nombre, precio, categoria, stock);
        productos.put(nombre.toLowerCase(), newProduto);    // buscar nombre en minúsculas (Case Sensitive) .
        System.out.println("Prodcuto '" + nombre + "' agregado correctamente.");
    }
    // Getter
    public Productos getProducto(String nombre){
        return productos.get(nombre.toLowerCase());
    }

    public void listAllProductos(){
        if(productos.isEmpty()){
            System.out.println("No existen productos registrados aún.");
            return;
        }
        System.out.println("\n ===== TODOS LOS PRODUCTOS =====");
        for(Productos prod: productos.values()){
            System.out.println(prod.toString());
        }
    }

    // >>>>>>>>>> ADMINISTRADOR DE CLIENTES <<<<<<<<<<
    public void addCliente(int id_cli, String nombre, String email){
        if(clientes.containsKey(nombre.toLowerCase())){
            System.out.println("ERROR: El cliente con nombre '" + nombre + "' ya existe.");
            return;
        }
        Clientes newCliente = new Clientes(id_cli, nombre, email);
        clientes.put(nombre.toLowerCase(), newCliente);
        System.out.println("Cliente '" + nombre + "' \t >> agregado correctamente.");
    }

    public Clientes getCliente(String nombre){
        return clientes.get(nombre.toLowerCase());
    }

    public void listAllClientes(){
        if(clientes.isEmpty()){
            System.out.println("No hay clientes registrados.");
            return;
        }
        System.out.println("\n ===== LISTADO DE CLIENTES =====");
        for(Clientes cli: clientes.values()){
            System.out.println(cli.toString());
        }
    }

    // ------ ADMINISTRADOR DE TIENDA ----- //
    public void registrarVenta(String nomProducto, int cantidad, String nomCliente){
        Productos producto = getProducto(nomProducto);
        Clientes cliente = getCliente(nomCliente);

        if(producto == null){
            System.out.println("ERROR: El Producto " + nomProducto + " no fue encontrado.");
            return;
        }
        if(cliente == null){
            System.out.println("ERROR: El cliente " + nomCliente + " no fue localizado.");
            return;
        }
        if(cantidad <= 0){
            System.out.println("ERROR: Cantidad debe de ser positiva.");
            return;
        }

        // Verificar disponibilidad en Stock
        if(producto.getStock() >= cantidad){
            if(producto.disminuirInventario(cantidad)){
                Ventas newVenta = new Ventas(producto, cantidad, cliente);
                newVenta.generarFolio(this.count);
                ventas.add(newVenta);
                System.out.println("Venta registrada exitosamente. \n" + newVenta + 
                    "\n____________________________________________");
                this.count += 1;
            }else{
                System.out.println("ERROR: Venta Fallida stock insuficiente para " + nomProducto);
            }
        }else{
            System.out.println("VENTA FALLIDA.");
            System.out.println("Producto: " + producto.getNombre());
            System.out.println("Existen sólo " + producto.getStock() + ", No pueden venderse " + cantidad + " unidades.");
        }
    }

    public void listAllVentas(){
        if(ventas.isEmpty()){
            System.out.println("Sin registro de ventas.");
            return;
        }
        System.out.println("\n ===== TODAS LAS VENTAS =====");
        for(Ventas sale: ventas){
            System.out.println(sale.toString());
        }
    }

    public static void main(String[] args){
        Tienda tienda = new Tienda();

        // >>>>> REGISTRAR PRODUCTOS <<<<< //
        System.out.println("\n ===== Registrando Productos =====");
        tienda.addProducto(1001,"Disco Duro 1TB", 550.25,"Electrónicos",10);
        tienda.addProducto(1002, "Disco Duro 500Gb", 385.00, "Electrónicos", 15);
        tienda.addProducto(2001, "Mouse Inalámbrico", 125.25, "Perimetrales", 20);
        tienda.addProducto(2002, "Impresora Láser", 1550.00, "Perimetrales", 5);
        tienda.addProducto(2003, "Monitor",999.00, "Perimetrales", 5);
        tienda.listAllProductos();

        // >>>>> REGISTRAR CLIENTES <<<<< //
        System.out.println("\n ===== Registrando Clientes ===== ");
        tienda.addCliente(101, "Alan Ortiz", "alan.ortiz@dominio.com");
        tienda.addCliente(102, "Elizabeth Lizardi", "jechu.lizardi@dominio.com");
        tienda.addCliente(103, "Ángela Córdova", "angela.cordova@dominio.com");
        tienda.addCliente(104, "Daniel Bojórquez","dani.bojorquez@dominio.com");
        tienda.addCliente(105, "José Meza", "pepe.meza@dominio.com");
        tienda.listAllClientes();

        // >>>>> REGISTRANDO VENTAS <<<<< //
        System.out.println("\n ===== Registrando Ventas ====== \n");
        tienda.registrarVenta("Disco Duro 1TB", 2,  "Alan Ortiz");
        tienda.registrarVenta("Mouse Inalámbrico", 8,"Elizabeth Lizardi");
        tienda.registrarVenta("Impresora Láser", 3, "ángela córdova");
        tienda.registrarVenta("Disco Duro 500Gb", 7, "daniel bojórquez");
        tienda.registrarVenta("monitor", 6, "josé meza");

        tienda.listAllVentas();
        tienda.listAllProductos();
    }

}
