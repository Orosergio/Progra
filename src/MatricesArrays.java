
import java.text.DecimalFormat;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sergio Orozco
 */
public class MatricesArrays extends javax.swing.JFrame {

    /**
     * Creates new form MatricesArrays
     */ 
    String matriz[][]=new String[10][11],intsumafila;
    String [] vectorLetras={"A","B","C","D","E"};
    int vectorSumadep[]=new int [5];
    DecimalFormat formato=new DecimalFormat("#.00");
    public MatricesArrays() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPrincipal = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaDepartamento = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablaPrincipal.setFont(new java.awt.Font("Palatino Linotype", 0, 14)); // NOI18N
        TablaPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombres", "Salario Base", "Bonificación", "Comisión", "Descuento Judicial", "IGSS", "ISR", "Saldo Liquido", "Departamento", "saldo sin ISR"
            }
        ));
        jScrollPane1.setViewportView(TablaPrincipal);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 1050, 190));

        TablaDepartamento.setFont(new java.awt.Font("Palatino Linotype", 0, 14)); // NOI18N
        TablaDepartamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Departamentos"
            }
        ));
        jScrollPane2.setViewportView(TablaDepartamento);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, 130));

        jButton1.setFont(new java.awt.Font("Palatino Linotype", 0, 14)); // NOI18N
        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, -1, -1));

        jButton2.setFont(new java.awt.Font("Palatino Linotype", 0, 14)); // NOI18N
        jButton2.setText("Generar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"0 a 5000", "3 %"},
                {"5001 a 10000", "5%"},
                {"10001 en adelante", "7%"}
            },
            new String [] {
                "TOTAL", "ISR"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 190, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //codigo    nombre  sueldo+ bonificaion+    comision+   igss-   descuento judicial-     ISR-       sueldo liquido
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
        for (int i=0;i<10;i++){
            for(int j=2;j<6;j++){
              int intrandom=(int)(Math.random()*10000)+1000; //GENERANDO NÚMEROS RANDOM
                matriz[i][j]=String.valueOf(intrandom);   //LLENANDO MATRIZ CON NUMEROS RANDOM
                
            }
            //CALCULO IGSS
            matriz[i][6]=String.valueOf(formato.format((Integer.parseInt(matriz[i][2])*4.83)/100));
            //CALCULO SIN ISR
            matriz[i][10]=String.valueOf(Integer.parseInt(matriz[i][2])+Integer.parseInt(matriz[i][3])+Integer.parseInt(matriz[i][4])-Integer.parseInt(matriz[i][5])-Float.parseFloat(matriz[i][6]));
            //INGRESO DE NOMBRE
            matriz[i][1]=JOptionPane.showInputDialog(null,"Nombre: ");
            int intRandomdep=(int)(Math.random()*5)+0;
            //ASIGNACION DE DEPARTAMENTO
            matriz[i][9]=vectorLetras[intRandomdep];
            //ASIGNACION DE CODIGO
            matriz[i][0]=String.valueOf(i+1);
            //CALCULO ISR
            if(Float.parseFloat(matriz[i][10])>=5000){
               matriz[i][7]=String.valueOf(formato.format((Float.parseFloat(matriz[i][10])*3)/100));
            }else if(Float.parseFloat(matriz[i][10])<5000){
                matriz[i][7]=String.valueOf((Float.parseFloat(matriz[i][10])*5)/100);
            }
            //SALDO LIQUIDO
            matriz[i][8]=String.valueOf(formato.format(Integer.parseInt(matriz[i][2])+Integer.parseInt(matriz[i][3])+Integer.parseInt(matriz[i][4])-Integer.parseInt(matriz[i][5])-Float.parseFloat(matriz[i][6])-Float.parseFloat(matriz[i][7])));
    
            
            
        }
       
        for(int i=0;i<10;i++){
            if (matriz [i][9] == "A"){
            vectorSumadep[0]+= Integer.parseInt(matriz[i][4]);    
            }
            if (matriz [i][9] == "B"){
            vectorSumadep[1]+= Integer.parseInt(matriz[i][4]);
            }
            if (matriz [i][9] == "C"){
            vectorSumadep[2]+= Integer.parseInt(matriz[i][4]);    
            }
            if (matriz [i][9] == "D"){
            vectorSumadep[3]+= Integer.parseInt(matriz[i][4]); 
            }
            if (matriz [i][9] == "E"){
            vectorSumadep[4]+=Integer.parseInt(matriz[i][4]);    
            }
        }
        
      
       this.MostrarMatriz(matriz,vectorLetras,vectorSumadep);
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        for(int i=0;i<10;i++){
            for(int j=0;j<11;j++){
                matriz[i][j]="";
            }
        }
        for (int i=0;i<5;i++){
            vectorSumadep[i]=0;
        }
        this.MostrarMatriz(matriz, vectorLetras, vectorSumadep);
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
            java.util.logging.Logger.getLogger(MatricesArrays.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MatricesArrays.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MatricesArrays.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MatricesArrays.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MatricesArrays().setVisible(true);
            }
        });
    }
    
    
    
    public void MostrarMatriz(String matrix[][],String vector[],int vecSuma[]){
        DefaultTableModel model = (DefaultTableModel) TablaPrincipal.getModel(); //Obteniendo modelo de JTable
        for(int i=0;i<10;i++){
            for(int j=0;j<11;j++){
                TablaPrincipal.setValueAt(matriz[i][j], i, j); //Asignando valores de la matriz al JTable
            }
        }
        
        DefaultTableModel dftVectormodel=(DefaultTableModel) TablaDepartamento.getModel(); //Obtener el model de JTable
        for (int i=0;i<5;i++){
            for(int j=0;j<2;j++){
            TablaDepartamento.setValueAt(vecSuma[i],i,0);    
            }
         }
    }
    
               
           
    
            
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaDepartamento;
    private javax.swing.JTable TablaPrincipal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
