package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class VistaPrincipal extends JFrame {

    private Tablero2D tablero2D;
    
    public VistaPrincipal() throws HeadlessException {
        super("Drawer");
        setMinimumSize(new Dimension(800, 600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(new BorderLayout());
        tablero2D = new Tablero2D();
        add(tablero2D, BorderLayout.CENTER);
        pack();
    }

    public Tablero2D getTablero2D() {
        return tablero2D;
    }
}
