package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaPrincipal extends JFrame {

    private Tablero2D tableroBresenham2D;
    private Tablero2D tableroDDA2D;
    private JButton botonCambiarColor;
    
    public VistaPrincipal() throws HeadlessException {
        super("Drawer");
        setMinimumSize(new Dimension(900, 600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(new BorderLayout());
        
        JPanel panelTableros = new JPanel();
        panelTableros.setLayout(new BoxLayout(panelTableros, BoxLayout.X_AXIS));
        
        tableroBresenham2D = new Tablero2D();
        tableroDDA2D = new Tablero2D();
        JPanel panelTableroBresenham2D = new JPanel();
        panelTableroBresenham2D.setLayout(new BorderLayout());
        panelTableroBresenham2D.add(new JLabel("Algoritmo Bresenham"), BorderLayout.NORTH);
        panelTableroBresenham2D.add(tableroBresenham2D, BorderLayout.CENTER);
        
        JPanel panelTableroDDA2D = new JPanel();
        panelTableroDDA2D.setLayout(new BorderLayout());
        panelTableroDDA2D.add(new JLabel("Algoritmo DDA"), BorderLayout.NORTH);
        panelTableroDDA2D.add(tableroDDA2D, BorderLayout.CENTER);
        
        panelTableros.add(panelTableroBresenham2D);
        panelTableros.add(panelTableroDDA2D);
        
        add(panelTableros, BorderLayout.CENTER);
        
        JPanel panelHerramientas = new JPanel();
        panelHerramientas.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        botonCambiarColor = new JButton("Cambiar Color");
        botonCambiarColor.setName("btnCambiarColor");
        panelHerramientas.add(botonCambiarColor);
        
        add(panelHerramientas, BorderLayout.EAST);
    }

    public Tablero2D getTableroBresenham2D() {
        return tableroBresenham2D;
    }

    public Tablero2D getTableroDDA2D() {
        return tableroDDA2D;
    }

    public JButton getBotonCambiarColor() {
        return botonCambiarColor;
    }
}
