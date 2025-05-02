package vista;

import javax.swing.*;
import modelo.InventarioFarmacia;

/**
 * Diálogo para mostrar todo el inventario
 */
public class MostrarInventarioDialog extends JDialog {
    public MostrarInventarioDialog(JFrame parent, InventarioFarmacia inventario) {
        super(parent, "Inventario Completo", true);
        
        setSize(500, 400);
        setLocationRelativeTo(parent);
        
        JTextArea txtInventario = new JTextArea(inventario.mostrarInventario());
        txtInventario.setEditable(false);
        
        add(new JScrollPane(txtInventario));
        setVisible(true);
    }
}