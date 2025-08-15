import java.time.LocalDate;

public class Ventas {
    private Productos producto;
    private int cantidad;
    private Clientes cliente;
    private LocalDate fechaVenta;
    private double precioTotal;
    private String folio;

    // Constructor de la clase
    public Ventas(Productos producto, int cantidad,Clientes cliente){
        this.producto = producto;
        this.cantidad = cantidad;
        this.cliente = cliente;
        this.fechaVenta = LocalDate.now(); // Fecha actual
        this.precioTotal = producto.getPrecio() * cantidad;
    }

    // Getters
    public Productos getProducto(){
        return this.producto;
    }
    public int getCantidad(){
        return this.cantidad;
    }
    public Clientes getCliente(){
        return this.cliente;
    }
    public LocalDate getFechaVenta(){
        return this.fechaVenta;
    }
    public double getPrecioTotal(){
        return this.precioTotal;
    }

    public void generarFolio(int count){
        count += 1;
        String strCont = String.valueOf(count);
        if(strCont.length() < 2){
            this.folio = "0" + strCont;
        }else{
            this.folio = strCont;
        }
        System.out.println("Folio = " + this.folio);
    }

    @Override
    public String toString(){
        return "Venta: ID = " + this.folio + "-" + this.fechaVenta + " \t| Producto = " + this.producto.getNombre() +
            " \t| Cantidad = " + this.cantidad + " \t| Total Venta = " + String.format("%.2f",precioTotal) +
            " \t| Cliente = " + this.cliente.getNombre();
    }
}
