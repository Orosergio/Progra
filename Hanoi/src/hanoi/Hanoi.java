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
    public static int topc;
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
         // System.out.println("mover disco de " + iOrigen + " a " + iDestino);
       
         if(iOrigen==1){
            topc=Integer.parseInt(pPila1.TOP()); 
            pPila1.POP();
            }
            if(iOrigen==2){
            topc=Integer.parseInt(pPila2.TOP()); 
            pPila2.POP();
            
            } 
            
            if(iOrigen==3){
            topc=Integer.parseInt(pPila3.TOP()); 
            pPila3.POP();
            }
            
            if(iDestino==1){
                pPila1.PUSH(topc);
            }
            if(iDestino==2){
                pPila2.PUSH(topc);
            }
            if(iDestino==3){
                pPila3.PUSH(topc);
            }
           System.out.println("Origen: "+pPila1.Listar()+"\nAuxiliar: "+pPila2.Listar()+"\nDestino: "+pPila3.Listar());
           
            System.out.println("");
        }else{
            PasosHanoi(Numero-1,iOrigen,iDestino,iAuxiliar);
           
            System.out.println("Mover disco de "+iOrigen+" a " +iDestino);
            if(iOrigen==1){
            topc=Integer.parseInt(pPila1.TOP()); 
            pPila1.POP();
            }
            if(iOrigen==2){
            topc=Integer.parseInt(pPila2.TOP()); 
            pPila2.POP();
            
            } 
            
            if(iOrigen==3){
            topc=Integer.parseInt(pPila3.TOP()); 
            pPila3.POP();
            }
            
            if(iDestino==1){
                pPila1.PUSH(topc);
            }
            if(iDestino==2){
                pPila2.PUSH(topc);
            }
            if(iDestino==3){
                pPila3.PUSH(topc);
            }
            System.out.println("\nOrigen: "+pPila1.Listar()+"\nAuxiliar: "+pPila2.Listar()+"\nDestino: "+pPila3.Listar());    
             try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            
        }
            PasosHanoi(Numero-1,iAuxiliar,iOrigen,iDestino);
        
        }
        
        
    }  
}
