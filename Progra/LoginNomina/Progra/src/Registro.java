
import java.sql.*;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yavhe
 */
public class Registro extends javax.swing.JFrame {

    /**
     * Creates new form Registro
     */
    public Registro() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(500,400);
        lblstatus.setVisible(false);
        combostatus.setVisible(false);
        registros.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_nuser = new javax.swing.JTextField();
        txt_npass = new javax.swing.JPasswordField();
        txt_vernpass = new javax.swing.JPasswordField();
        lblstatus = new javax.swing.JLabel();
        combostatus = new javax.swing.JComboBox<>();
        registros = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jTextField2.setText("jTextField2");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Registro de Usuarios");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        jLabel2.setText("Usuario");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        jLabel3.setText("Contraseña");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        jLabel4.setText("Verificar");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));
        getContentPane().add(txt_nuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 120, -1));
        getContentPane().add(txt_npass, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 120, -1));

        txt_vernpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_vernpassActionPerformed(evt);
            }
        });
        txt_vernpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_vernpassKeyTyped(evt);
            }
        });
        getContentPane().add(txt_vernpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 120, -1));

        lblstatus.setText("Estatus");
        getContentPane().add(lblstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        combostatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "0" }));
        getContentPane().add(combostatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, -1, -1));

        registros.setText("Registrarse");
        registros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrosActionPerformed(evt);
            }
        });
        getContentPane().add(registros, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, -1, -1));

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_vernpassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_vernpassKeyTyped
        
    }//GEN-LAST:event_txt_vernpassKeyTyped

    private void txt_vernpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_vernpassActionPerformed
        // TODO add your handling code here:
        if(txt_vernpass.getText().equals(txt_npass.getText())){
            lblstatus.setVisible(true);
            combostatus.setVisible(true);
            registros.setVisible(true);
        }
    }//GEN-LAST:event_txt_vernpassActionPerformed

    private void registrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrosActionPerformed
        // TODO add your handling code here:
         try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ins", "root", "");
            PreparedStatement pst = cn.prepareStatement("insert into usuarios values(?,?,?,?)");
            
            pst.setString(1, "0");
            pst.setString(2, txt_nuser.getText().trim());
            pst.setString(3, txt_npass.getText().trim());
            pst.setString(4, combostatus.getSelectedItem().toString());
            pst.executeUpdate();
            
            txt_nuser.setText("");
            txt_npass.setText("");
            txt_vernpass.setText("");
            
            JOptionPane.showMessageDialog(null,"Registro Exitoso");
        }catch (Exception e){
           System.out.println("Se ha producido un error");
        }
    }//GEN-LAST:event_registrosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Login log =new Login();
        this.setVisible(false);
        log.setVisible(true);
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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combostatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblstatus;
    private javax.swing.JButton registros;
    private javax.swing.JPasswordField txt_npass;
    private javax.swing.JTextField txt_nuser;
    private javax.swing.JPasswordField txt_vernpass;
    // End of variables declaration//GEN-END:variables
}
