package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VistaPrincipal extends JFrame {

    private Tablero2D tableroBresenham2D;
    private Tablero2D tableroDDA;
    
    public VistaPrincipal() throws HeadlessException {
        super("Drawer");
        setMinimumSize(new Dimension(800, 600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(new BorderLayout());
        
        JPanel panelTableros = new JPanel();
        panelTableros.setLayout(new BoxLayout(panelTableros, BoxLayout.X_AXIS));
        
        tableroBresenham2D = new Tablero2D();
        tableroDDA = new Tablero2D();
        
        panelTableros.add(tableroBresenham2D);
        panelTableros.add(tableroDDA);
        
        add(panelTableros, BorderLayout.CENTER);
    }

    public Tablero2D getTableroBresenham2D() {
        return tableroBresenham2D;
    }

    public Tablero2D getTableroDDA2D() {
        return tableroDDA;
    }
}
