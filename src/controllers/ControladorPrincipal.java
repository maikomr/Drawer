package controllers;

import algorithms.Bresenham;
import algorithms.DDA;
import algorithms.DrawingStrategy;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import model.Tablero;
import ui.Tablero2D;
import ui.VistaPrincipal;

public class ControladorPrincipal implements ActionListener {
    
    private VistaPrincipal vistaPrincipal;
    private Tablero tableroBresenham;
    private Tablero tableroDDA;
    private ControladorTableros controladorTableros;
    
    public ControladorPrincipal() {
        construirComponentes();
    }

    private void construirComponentes() {
        int filas = 18;
        int columnas = 18;
        tableroBresenham = new Tablero(filas, columnas);
        tableroDDA = new Tablero(filas, columnas);
        vistaPrincipal = new VistaPrincipal();
        
        Tablero2D tableroBresenham2D = vistaPrincipal.getTableroBresenham2D();
        Tablero2D tableroDDA2D = vistaPrincipal.getTableroDDA2D();
        
        DrawingStrategy estrategiaBresenham = new Bresenham();
        DrawingStrategy estrategiaDDA = new DDA();
        
        controladorTableros = new ControladorTableros();
        controladorTableros.conectar(tableroBresenham, tableroBresenham2D, estrategiaBresenham);
        controladorTableros.conectar(tableroDDA, tableroDDA2D, estrategiaDDA);
        
        JButton btnCambiarColor = vistaPrincipal.getBotonCambiarColor();
        btnCambiarColor.addActionListener(this);
    }
    
    public void iniciar() {
        vistaPrincipal.setVisible(true);
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControladorPrincipal().iniciar();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton boton = (JButton) e.getSource();
            if (boton.getName().equals("btnCambiarColor")) {
                Color nuevoColor = JColorChooser.showDialog(
                     vistaPrincipal,
                     "Elige un color",
                     controladorTableros.getColorActual());
                if (nuevoColor != null) {
                    controladorTableros.setColorActual(nuevoColor);
                }
            }
        }
    }
}
