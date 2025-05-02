package vista;

import javax.swing.*;
import java.awt.*;
import modelo.*;

/**
 * Diálogo para consultar productos por código de barras
 */
public class ConsultarProductoDialog extends JDialog {
    private JTextField txtCodigo;
    private JTextArea txtResultado;
    private InventarioFarmacia inventario;

    public ConsultarProductoDialog(JFrame parent, InventarioFarmacia inventario) {
        super(parent, "Consultar Producto", true);
        this.inventario = inventario;
        
        setSize(400, 300);
        setLocationRelativeTo(parent);
        
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel panelSuperior = new JPanel(new GridLayout(1, 2, 10, 10));
        panelSuperior.add(new JLabel("Código de Barras:"));
        txtCodigo = new JTextField();
        panelSuperior.add(txtCodigo);
        
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(e -> buscarProducto());
        panelSuperior.add(btnBuscar);
        
        panel.add(panelSuperior, BorderLayout.NORTH);
        
        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        panel.add(new JScrollPane(txtResultado), BorderLayout.CENTER);
        
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());
        panel.add(btnCerrar, BorderLayout.SOUTH);
        
        add(panel);
        setVisible(true);
    }

    private void buscarProducto() {
        String codigo = txtCodigo.getText();
        ProductoDTO producto = inventario.buscarProductoPorCodigo(codigo);
        
        if (producto != null) {
            txtResultado.setText(producto.toString());
        } else {
            txtResultado.setText("Producto no encontrado");
        }
    }
}