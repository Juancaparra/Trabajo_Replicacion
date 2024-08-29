import java.text.SimpleDateFormat;
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

    public void addItemFactura(ÍtemFactura item) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] == null) {
                this.items[i] = item;
                break;
            }
        }
    }

    public float calcularTotal() {
        float total = 0.0f;
        for (ÍtemFactura item : this.items) {
            if (item != null) {
                total += item.calcularImporte();
            }
        }
        return total;
    }

    public String generarDetalle() {
        StringBuilder sb = new StringBuilder("Factura Nº: ");
        sb.append(folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t NIF: ")
                .append(cliente.getNif())
                .append("\nDescripción: ")
                .append(this.descripcion)
                .append("\n");

        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        sb.append("Fecha Emisión: ")
                .append(df.format(this.fecha))
                .append("\n")
                .append("\n#\tNombre\t$\tCant.\tTotal\n");

        for(ÍtemFactura item: this.items){
            if(item == null){
                continue;
            }
            sb.append(item)
                    .append("\n");
        }
        sb.append("\nGran Total: ")
                .append(calcularTotal());

        return sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }

}