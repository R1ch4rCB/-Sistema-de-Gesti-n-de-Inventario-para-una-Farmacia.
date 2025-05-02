package vista;

import javax.swing.*;
import java.awt.*;
import modelo.*;

/**
 * Diálogo para agregar nuevos productos al inventario
 */
public class AgregarProductoDialog extends JDialog {
    private JTextField txtNombre, txtCodigo, txtPrecio, txtStock;
    private InventarioFarmacia inventario;

    public AgregarProductoDialog(JFrame parent, InventarioFarmacia inventario) {
        super(parent, "Agregar Producto", true);
        this.inventario = inventario;
        
        setSize(400, 300);
        setLocationRelativeTo(parent);
        
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        panel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);
        
        panel.add(new JLabel("Código de Barras:"));
        txtCodigo = new JTextField();
        panel.add(txtCodigo);
        
        panel.add(new JLabel("Precio Unitario:"));
        txtPrecio = new JTextField();
        panel.add(txtPrecio);
        
        panel.add(new JLabel("Cantidad en Stock:"));
        txtStock = new JTextField();
        panel.add(txtStock);
        
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(e -> agregarProducto());
        panel.add(btnAgregar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        panel.add(btnCancelar);
        
        add(panel);
        setVisible(true);
    }

    private void agregarProducto() {
        try {
            String nombre = txtNombre.getText();
            String codigo = txtCodigo.getText();
            double precio = Double.parseDouble(txtPrecio.getText());
            int stock = Integer.parseInt(txtStock.getText());
            
            ProductoDTO producto = new ProductoDTO(nombre, codigo, precio, stock);
            inventario.agregarProducto(producto);
            
            JOptionPane.showMessageDialog(this, "Producto agregado exitosamente");
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en los datos ingresados", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}