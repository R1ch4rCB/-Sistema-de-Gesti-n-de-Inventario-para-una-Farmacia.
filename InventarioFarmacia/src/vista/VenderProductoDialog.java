package vista;

import javax.swing.*;
import java.awt.*;
import modelo.*;

/**
 * Diálogo para realizar ventas de productos
 */
public class VenderProductoDialog extends JDialog {
    private JTextField txtCodigo, txtCantidad;
    private InventarioFarmacia inventario;

    public VenderProductoDialog(JFrame parent, InventarioFarmacia inventario) {
        super(parent, "Vender Producto", true);
        this.inventario = inventario;
        
        setSize(400, 200);
        setLocationRelativeTo(parent);
        
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        panel.add(new JLabel("Código de Barras:"));
        txtCodigo = new JTextField();
        panel.add(txtCodigo);
        
        panel.add(new JLabel("Cantidad a vender:"));
        txtCantidad = new JTextField();
        panel.add(txtCantidad);
        
        JButton btnVender = new JButton("Vender");
        btnVender.addActionListener(e -> venderProducto());
        panel.add(btnVender);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        panel.add(btnCancelar);
        
        add(panel);
        setVisible(true);
    }

    private void venderProducto() {
        try {
            String codigo = txtCodigo.getText();
            int cantidad = Integer.parseInt(txtCantidad.getText());
            
            if (inventario.venderProducto(codigo, cantidad)) {
                JOptionPane.showMessageDialog(this, "Venta realizada con éxito");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No hay suficiente stock o producto no encontrado", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cantidad inválida", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}