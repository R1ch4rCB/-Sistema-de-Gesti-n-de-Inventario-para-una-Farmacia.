package vista;

import javax.swing.*;
import java.awt.*;
import modelo.InventarioFarmacia;

/**
 * Ventana principal del sistema con el menú de opciones
 */
public class MenuPrincipal extends JFrame {
    private InventarioFarmacia inventario;

    public MenuPrincipal() {
        inventario = new InventarioFarmacia();
        
        setTitle("Sistema de Gestión de Farmacia");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JButton btnAgregar = new JButton("Agregar Producto");
        JButton btnConsultar = new JButton("Consultar Producto");
        JButton btnInventario = new JButton("Mostrar Inventario");
        JButton btnVender = new JButton("Vender Producto");
        JButton btnActualizar = new JButton("Actualizar Precio");
        JButton btnSalir = new JButton("Salir");
        
        // Acciones de los botones
        btnAgregar.addActionListener(e -> new AgregarProductoDialog(this, inventario));
        btnConsultar.addActionListener(e -> new ConsultarProductoDialog(this, inventario));
        btnInventario.addActionListener(e -> new MostrarInventarioDialog(this, inventario));
        btnVender.addActionListener(e -> new VenderProductoDialog(this, inventario));
        btnActualizar.addActionListener(e -> new ActualizarPrecioDialog(this, inventario));
        btnSalir.addActionListener(e -> System.exit(0));
        
        panel.add(btnAgregar);
        panel.add(btnConsultar);
        panel.add(btnInventario);
        panel.add(btnVender);
        panel.add(btnActualizar);
        panel.add(btnSalir);
        
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
        });
    }
}