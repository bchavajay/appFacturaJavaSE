package gt.bchavajay.appfacturas.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
    private int folio;
    private String descricion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;
    private int indiceItems;
    public static final int MAX_ITEMS = 12;
    private static int ultimoFolio;

    public Factura(String descricion, Cliente cliente) {
        this.descricion = descricion;
        this.cliente = cliente;
        this.items = new ItemFactura[MAX_ITEMS];
        this.folio = ++ultimoFolio;
        this.fecha = new Date();
    }

    public int getFolio() {
        return folio;
    }

    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
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

    public ItemFactura[] getItems() {
        return items;
    }

    public void addItemFactura(ItemFactura item) {
        if (indiceItems < MAX_ITEMS) {
            this.items[indiceItems++] = item;
        }
    }

    public float calcularTotal() {
        float total = 0.0f;
        for (int i = 0;i < indiceItems ; i++) {
            ItemFactura item = this.items[i];
            total = total + item.calcularImporte();
        }
        return total;
    }

    public String generarDetalle() {
        StringBuilder sb = new StringBuilder("Factura No.");
        sb.append(folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\tNit: ")
                .append(this.cliente.getNit())
                .append("\nDescripción: ")
                .append(this.descricion)
                .append("\n");

        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMM, yyyy");
        sb.append("Fecha Emision: ")
                .append(df.format(this.fecha))
                .append("\n")

                .append("\n#\tnombre\tQ\tCant.\tTotal\n");
        for (int i = 0;i < indiceItems ; i++) {
            ItemFactura item = this.items[i];
            sb.append(item.toString())
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
