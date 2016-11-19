package controllers;

import model.Tablero;
import ui.Tablero2D;
import ui.VistaPrincipal;

public class ControladorPrincipal {
    
    private VistaPrincipal vistaPrincipal;
    private Tablero tableroBresenham;
    private Tablero tableroDDA;
    private ControladorTablero controladorTableroBresenham;
    private ControladorTablero controladorTableroDDA;
    
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
        
        controladorTableroBresenham = new ControladorTablero(tableroBresenham, tableroBresenham2D);
        controladorTableroDDA = new ControladorTablero(tableroDDA, tableroDDA2D);
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
}
