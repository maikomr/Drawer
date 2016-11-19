package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import model.CambioPixel;

public class PanelInspeccion extends JPanel implements Observer {

    private String resultado;
    private JTextArea areaResultado;
    
    public PanelInspeccion() {
        super();
        inicializar();
    }
    
    private void inicializar() {
        setLayout(new BorderLayout());
        resultado = "";
        areaResultado = new JTextArea();
        areaResultado.setMaximumSize(new Dimension(400, 300));
        areaResultado.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaResultado);
        add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg != null && arg instanceof CambioPixel) {
            CambioPixel cambioPixel = (CambioPixel) arg;
            resultado += cambioPixel.toString() + "\n";
            areaResultado.setText(resultado);
            repaint();
        }
    }
}
