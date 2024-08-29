public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private static int ultimoCodigo;

    public Producto(String producto,String nombre, double precio){
        this.codigo="Codigo "+(++ultimoCodigo);
        this.nombre=nombre;
        this.precio=precio;
    }

    public Producto() {

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}