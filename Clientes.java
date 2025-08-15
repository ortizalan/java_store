public class Clientes {
    // Propiedades privadas
    private int id_cliente;
    private String nombre;
    private String email;

    // Constructor
    public Clientes(int id_cliente, String nombre, String email) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.email = email;
    }

    // Getters
    public int getId_cliente() {
        return id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    // Mostrar información cliente
    @Override
    public String toString() {
        return "Cliente: ID Cliente = " + this.id_cliente + ", \t|| Nombre = " + this.nombre + 
            ", \t|| email = " + this.email ;
    }
    
}
