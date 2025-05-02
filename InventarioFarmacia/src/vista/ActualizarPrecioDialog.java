package vista;

import javax.swing.*;
import java.awt.*;
import modelo.*;

/**
 * Diálogo para actualizar precios de productos
 */
public class ActualizarPrecioDialog extends JDialog {
    private JTextField txtCodigo, txtNuevoPrecio;
    private InventarioFarmacia inventario;

    public ActualizarPrecioDialog(JFrame parent, InventarioFarmacia inventario) {
        super(parent, "Actualizar Precio", true);
        this.inventario = inventario;
        
        setSize(400, 200);
        setLocationRelativeTo(parent);
        
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        panel.add(new JLabel("Código de Barras:"));
        txtCodigo = new JTextField();
        panel.add(txtCodigo);
        
        panel.add(new JLabel("Nuevo Precio:"));
        txtNuevoPrecio = new JTextField();
        panel.add(txtNuevoPrecio);
        
        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(e -> actualizarPrecio());
        panel.add(btnActualizar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        panel.add(btnCancelar);
        
        add(panel);
        setVisible(true);
    }

    private void actualizarPrecio() {
        try {
            String codigo = txtCodigo.getText();
            double nuevoPrecio = Double.parseDouble(txtNuevoPrecio.getText());
            
            if (inventario.actualizarPrecio(codigo, nuevoPrecio)) {
                JOptionPane.showMessageDialog(this, "Precio actualizado con éxito");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Producto no encontrado", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Precio inválido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}