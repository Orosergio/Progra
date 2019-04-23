/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

import javax.swing.JOptionPane;

/**
push top esta llena estavacia pop vaciar
 */
public class Pilas {

    static String titulo="",isbn="",autor="";
    static int nv=0,nvs=0;
     static Lista list1=new Lista();
    public static void main(String[] args) {
          int opcion=0;   
        while(opcion!=7 ){
        String op=JOptionPane.showInputDialog(null,"     Bienvenido al Registro de Libros(PILAS) \n"+
                "1.- Ingreso de un libro\n2.-Eliminación de un libro\n3.Longitud de la Lista-\n4.-Estado de la lista\n5.- Ver todos los libros\n6.Tope\n7.- Salir");
         opcion=Integer.parseInt(op);
        switch(opcion){
            case 1:
                ingreso();
                break;
            case 2:
                Eliminar();                
                break;
            case 3:
             tamanio();
                break;
            case 4:
                if(list1.estaVacia()==true){
                 JOptionPane.showMessageDialog(null, "La lista esta vacia ");
                
                }else{
                     JOptionPane.showMessageDialog(null, "La lista contiene datos ");
                }
                break;
            case 5:
                 System.out.println("TOTAL DE LIBROS: \n"+list1.ver());
                   break;
            case 6:
                obtener();
                break;
                case 7:
                
                break;
                }    //switch
        }//while
    }
  
    
    public static void ingreso(){
        int opcs=0;
      
         while(opcs!=2){
        String opc=JOptionPane.showInputDialog("Ingreso de Libro.\n1.-Ingreso del libro\n2.-Regresar al menú");
        opcs=Integer.parseInt(opc);
        
        
        switch(opcs){
            case 1:
                titulo=JOptionPane.showInputDialog("Nombre del Libro");
                autor=JOptionPane.showInputDialog("Autor del Libro");
                isbn=JOptionPane.showInputDialog("ISBN del Libro");
                Libro book=new Libro(titulo,autor,isbn);
                list1.PUSH(book);
                list1.ver();
                break;
            
            case 2:
              
                break;
          
            default:
                System.out.println("No existe la opcion");
                break;
        }
    System.out.println("Datos\n"+list1.ver());
        }
            }
    public static void Eliminar(){
     int opcs=0;
        String opc=JOptionPane.showInputDialog("Eliminación de Libro.\n1.-Eliminar libro\n2.- Volver al menu principal");
        
          opcs=Integer.parseInt(opc);
        
        
        switch(opcs){
            case 1:
                 nvs=JOptionPane.showConfirmDialog(null,"Seguro que desea eliminar el primero?","Eliminación", JOptionPane.YES_NO_OPTION);
                    if(nvs==JOptionPane.YES_OPTION){
                            list1.POP(); 
                            list1.ver();
                    }else if(nvs==JOptionPane.NO_OPTION){
                        break;
                    }
               
                break;
            case 2:
               
                break;
                                  default:
                System.out.println("No existe la opcion");
                break;
        }
        
        
    System.out.println("Datos\n"+list1.ver());
        }

   
    

 public static void obtener(){
    
        System.out.println("El libro en la ultima posición es:\n "+list1.TOP().getTitulo());
        
    }
    public static void tamanio(){
        
        JOptionPane.showMessageDialog(null, "El tamaño de la lista es de:  "+list1.contar());
    }
    
      
}



