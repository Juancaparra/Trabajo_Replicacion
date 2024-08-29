import java.util.Date;

public class Factura {
    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ÍtemFactura[] items;
    private int indiceActual;
    private static final int MAX_ITEMS = 100;
    private static int ultimoFolio = 0;

    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.items = new ÍtemFactura[MAX_ITEMS];
        this.indiceActual = 0;
        this.folio = generarFolio();
        this.fecha = new Date();
    }

    private static int generarFolio() {
        return ++ultimoFolio;
    }

    public boolean agregarItem(ÍtemFactura item) {
        if (indiceActual < MAX_ITEMS) {
            items[indiceActual++] = item;
            return true;
        }
        return false;
    }

    public Factura(int folio,String descripcion,Date fecha,Cliente cliente, ÍtemFactura[] items){
        this.folio=folio;
        this.descripcion=descripcion;
        this.fecha=fecha;
        this.cliente=cliente;
        this.items=items;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ÍtemFactura[] getItems() {
        return items;
    }

    public void setItems(ÍtemFactura[] items) {
        this.items = items;
    }

}