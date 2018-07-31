/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.utility;

import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.Timer;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;

/**
 *
 * @author JANSEN
 */
public class TestRotate extends javax.swing.JFrame {

     static RotatingIcon ri;
    public TestRotate() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        label = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(219, Short.MAX_VALUE))
        );

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(177, 177, 177))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      // panel.remove(label);
       //panel.revalidate();
     //  panel.repaint();
        ri.rotatingTimer.stop();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TestRotate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestRotate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestRotate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestRotate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestRotate().setVisible(true);
                ImageIcon icon = new ImageIcon( 
               getClass().getResource("/images/rotating_icon.gif"));
                ri = new RotatingIcon( icon , panel );
                label.setIcon(icon);
               
                
                ri.rotatingTimer.start();
            }
        });
    }
    
    private static class RotatingIcon implements Icon{
    private final Icon delegateIcon;
    private double angleInDegrees = 90;
    public final Timer rotatingTimer;
    private RotatingIcon( Icon icon, final JComponent component ) {
      delegateIcon = icon;
      rotatingTimer = new Timer( 100, new ActionListener() {
        @Override
        public void actionPerformed( ActionEvent e ) {
          angleInDegrees = angleInDegrees + 10;
          if ( angleInDegrees == 360 ){
            angleInDegrees = 0;
          }
          component.repaint();
          component.revalidate();
        }
      } );
      rotatingTimer.setRepeats( false );
      rotatingTimer.start();
      
    }

    @Override
    public void paintIcon( Component c, Graphics g, int x, int y ) {
      rotatingTimer.stop();
      Graphics2D g2 = (Graphics2D )g.create();
      int cWidth = delegateIcon.getIconWidth() / 2;
      int cHeight = delegateIcon.getIconHeight() / 2;
      Rectangle r = new Rectangle(x, y, delegateIcon.getIconWidth(), delegateIcon.getIconHeight());
      g2.setClip(r);
      AffineTransform original = g2.getTransform();
      AffineTransform at = new AffineTransform();
      at.concatenate(original);
      at.rotate(Math.toRadians( angleInDegrees ), x + cWidth, y + cHeight);
      g2.setTransform(at);
      delegateIcon.paintIcon(c, g2, x, y);
      g2.setTransform(original);
      rotatingTimer.start();
    }

    @Override
    public int getIconWidth() {
      return delegateIcon.getIconWidth();
    }

    @Override
    public int getIconHeight() {
      return delegateIcon.getIconHeight();
    }
  } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private static javax.swing.JLabel label;
    private static javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}