
public class Productos {
    // Propiedades privadas
    private int codigo;
    private String nombre;
    private double precio;
    private String categoria;
    private int stock;


    // Constructor
    public Productos(int codigo, String nombre, double precio, String categoria, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
    }

    // Getters

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria(){
        return categoria;
    }

    public int getStock() {
        return stock;
    }
    // Actualizar Inventario
    public void aumentarInventario(int cantidad){
        if(cantidad > 0){
            this.stock += cantidad;
            System.out.println(cantidad + "unidades agregadas a " + this.nombre + "; Nuevo Stock: " + this.stock);
        }else{
            System.out.println("La cantidad a restar en el Stock, debe de ser positiva.");
        }
        
    }

    public boolean disminuirInventario(int cantidad){
        if(cantidad > 0 && this.stock >= cantidad){
            this.stock -= cantidad;
            System.out.println("Se descontaron " + cantidad + " Unidades a " + this.nombre + 
            ". \tNuevo Stock: " + this.stock);
            System.out.println("____________________________________________");
            return true;
        }else if(cantidad <= 0){
            System.out.println("La cantidad a descontar debe de ser positiva.");
            return false;
        }else{
            System.out.println("No hay suficiente Stock para " + this.nombre +". Disponible: " + this.stock);
            return false;
        }
    }

    @Override
    public String toString() {
        return "Producto: Nombre = " + this.nombre + " \t|| Código = " + this.codigo + 
            " \t|| Precio = " + String.format("%.2f", precio) + " \t|| Categoria = " + this.categoria +
            " \t|| Stock = " + this.stock;
    }
}
