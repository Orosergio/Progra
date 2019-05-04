/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoi;

import javax.swing.JOptionPane;

/**
 *
 * @author alumno
 */
public class Hanoi {

    /**
     * @param args the command line arguments
     */
    public static Pilas pPila1=new Pilas();
    public static Pilas pPila2=new Pilas();
    public static Pilas pPila3=new Pilas();
    public static void main(String[] args) {
        int iCantidadDiscos;
        iCantidadDiscos=Integer.parseInt(JOptionPane.showInputDialog("Cuantos discos desea?"));
           for (int i = 1; i <= iCantidadDiscos; i++) {
               pPila1.PUSH(i);
           }
        System.out.println("Origen\t\t"+pPila1.Listar()+ "\nAuxiliar\t\t"+pPila2.Listar()+"\nDestino\t\t"+pPila3.Listar()+"\n");
       PasosHanoi(Integer.parseInt(pPila1.TOP()),1,2,3);
    }          
    public static void PasosHanoi(int Numero, int iOrigen, int iAuxiliar, int iDestino){
        if (Numero==1) {
          //origen a destino  
        }else{
            PasosHanoi(Numero-1,iOrigen,iDestino,iAuxiliar);
            if (iOrigen==1) {
                pPila1.POP();
            }else if (iOrigen==2) {
                 pPila2.POP();
            }else if (iOrigen==3) {
                pPila3.POP(); 
            }
            
            PasosHanoi(Numero-1,iAuxiliar,iOrigen,iDestino);
        }
    }  
}
