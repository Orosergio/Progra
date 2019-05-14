/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colas;

/**
 *
 * @author Yavhé Sergio Enrique Orozco Valle
 * 0901-17-6739
 */

import javax.swing.JOptionPane;

/**
push top esta llena estavacia pop vaciar
 */
public class Colas {

    static String titulo="",isbn="",autor="";
    static int nv=0,nvs=0;
     static Lista list1=new Lista();
    public static void main(String[] args) {
          int opcion=0;   //Creación del menú principal
        while(opcion!=7 ){
        String op=JOptionPane.showInputDialog(null,"     Bienvenido al Registro de Libros(COLAS) \n"+
                "1.- Ingreso de un libro\n2.-Eliminación de un libro\n3.Longitud de la Cola-\n4.-Estado de la Cola\n5.- Ver todos los libros\n6.- Primer elemento\n7.- Salir");
         opcion=Integer.parseInt(op);
        switch(opcion){//Realizacion de tareas dependiendo de la opcion seleccionada
            case 1:
                ingreso();//Se llama al metodo ingreso
                break;
            case 2:
                Eliminar();//Se llama al metodo elminar
                break;
            case 3:
             tamanio();//Se llama al metodo de tamaño
                break;
            case 4:
                if(list1.estaVacia()==true){
                 JOptionPane.showMessageDialog(null, "La Cola esta vacia ");//Verifica si hay elementos en la cola
                
                }else{
                     JOptionPane.showMessageDialog(null, "La Cola contiene datos ");
                }
                break;
            case 5:
                 System.out.println("TOTAL DE LIBROS: \n"+list1.ver());//Muestra la cantidad de registros
                   break;
            case 6:
                obtener();//Obtiene el primer elemento de la cola
                break;
                case 7:
                
                break;
                }    //switch
        }//while
    }
  
    
    public static void ingreso(){
        int opcs=0;
      //Menu interior para el ingreso
         while(opcs!=2){
        String opc=JOptionPane.showInputDialog("Ingreso de Libro.\n1.-Ingreso del libro\n2.-Regresar al menú");
        opcs=Integer.parseInt(opc);
        
        //case dependiendo de la opcion que se selecciono
        switch(opcs){
            case 1://Pide informacion y la envia a la clase de libro
                titulo=JOptionPane.showInputDialog("Nombre del Libro");
                autor=JOptionPane.showInputDialog("Autor del Libro");
                isbn=JOptionPane.showInputDialog("ISBN del Libro");
                Libro book=new Libro(titulo,autor,isbn);
                list1.QUEUE(book);
                list1.ver();
                break;
            
            case 2://Sale del menu
              
                break;
          
            default:
                System.out.println("No existe la opcion");
                break;
        }
    System.out.println("Datos\n"+list1.ver());
        }
            }
    public static void Eliminar(){//Metodo para eliminar un elemento en la cola
     int opcs=0;
        String opc=JOptionPane.showInputDialog("Eliminación de Libro.\n1.-Eliminar libro\n2.- Volver al menu principal");
        
          opcs=Integer.parseInt(opc);
        
        //Opciones segun la opcion seleccionada
        switch(opcs){
            case 1:
                 nvs=JOptionPane.showConfirmDialog(null,"Seguro que desea eliminar el primero?","Eliminación", JOptionPane.YES_NO_OPTION);
                    if(nvs==JOptionPane.YES_OPTION){
                            list1.DEQUEUE(); 
                            list1.ver();
                    }else if(nvs==JOptionPane.NO_OPTION){
                        break;
                    }
               
                break;
            case 2:
               //Sale del menu al menu principal
                break;
                                  default:
                System.out.println("No existe la opcion");
                break;
        }
        
        
    System.out.println("Datos\n"+list1.ver());
        }

   
    

 public static void obtener(){
    //Metodo para obtener el primer dato de la cola
        System.out.println("El libro en la ultima posición es:\n "+list1.TOP().getTitulo());
        
    }
    public static void tamanio(){
        //Obtiene el tamaño de la cola
        JOptionPane.showMessageDialog(null, "El tamaño de la cola es de:  "+list1.contar());
    }
    
      
}



