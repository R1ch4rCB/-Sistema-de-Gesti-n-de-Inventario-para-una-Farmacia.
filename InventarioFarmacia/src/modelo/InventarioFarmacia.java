package modelo;

import javax.swing.JOptionPane;

/**
 * Clase que gestiona el inventario de productos de la farmacia
 */
public class InventarioFarmacia {
    private final ProductoDTO[] productos;
    private int contadorProductos;
    private static final int CAPACIDAD_MAXIMA = 100;

    public InventarioFarmacia() {
        productos = new ProductoDTO[CAPACIDAD_MAXIMA];
        contadorProductos = 0;
    }

    /**
     * Agrega un nuevo producto al inventario
     * @param producto
     */
    public void agregarProducto(ProductoDTO producto) {
        if (contadorProductos < CAPACIDAD_MAXIMA) {
            productos[contadorProductos] = producto;
            contadorProductos++;
        } else {
            JOptionPane.showMessageDialog(null, "Inventario lleno, no se pueden agregar más productos");
        }
    }

    /**
     * Busca un producto por su código de barras
     */
    public ProductoDTO buscarProductoPorCodigo(String codigoBarras) {
        for (int i = 0; i < contadorProductos; i++) {
            if (productos[i].getCodigoBarras().equals(codigoBarras)) {
                return productos[i];
            }
        }
        return null;
    }

    /**
     * Muestra todos los productos del inventario
     */
    public String mostrarInventario() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < contadorProductos; i++) {
            sb.append(productos[i].toString()).append("\n\n");
        }
        return sb.toString();
    }

    /**
     * Realiza una venta de producto si hay stock suficiente
     */
    public boolean venderProducto(String codigoBarras, int cantidadVendida) {
        ProductoDTO producto = buscarProductoPorCodigo(codigoBarras);
        if (producto != null && producto.getCantidadStock() >= cantidadVendida) {
            producto.setCantidadStock(producto.getCantidadStock() - cantidadVendida);
            return true;
        }
        return false;
    }

    /**
     * Actualiza el precio de un producto
     */
    public boolean actualizarPrecio(String codigoBarras, double nuevoPrecio) {
        ProductoDTO producto = buscarProductoPorCodigo(codigoBarras);
        if (producto != null) {
            producto.setPrecioUnitario(nuevoPrecio);
            return true;
        }
        return false;
    }
}