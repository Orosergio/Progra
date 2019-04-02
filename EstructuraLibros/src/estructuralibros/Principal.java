/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuralibros;

import javax.swing.JOptionPane;

/**
 *
 * @author yavhe
 */
public class Principal  {
   
    static String titulo="",isbn="",autor="";
    static int nv=0,nvs=0;
     static Lista list1=new Lista();
    public static void main(String [] args){
     
     int opcion=0;   
        while(opcion!=7){
        String op=JOptionPane.showInputDialog(null,"     Bienvenido al Registro de Libros \n"+
                "1.- Ingreso de un libro\n2.-Eliminación de un libro\n3.- Busqueda de un libro\n4.Longitud de la Lista-\n5.-Estado de la lista\n6.- Ver todos los libros\n7.- Salir");
         opcion=Integer.parseInt(op);
        switch(opcion){
            case 1:
                ingreso();
                break;
            case 2:
                Eliminar();                
                break;
            case 3:
                Buscar();
                break;
            case 4:
                tamanio();
                break;
            case 5:
                if(list1.estaVacia()==true){
                 JOptionPane.showMessageDialog(null, "La lista esta vacia ");
                
                }else{
                     JOptionPane.showMessageDialog(null, "La lista contiene datos ");
                }
                   break;
            case 6:
                 System.out.println("TOTAL DE LIBROS: \n"+list1.ver());
                break;
                }    //switch
        }//while
    }
    
    public static void ingreso(){
        int opcs=0;
      
         while(opcs!=4){
        String opc=JOptionPane.showInputDialog("Ingreso de Libro.\n1.-Ingreso al inicio\n2.-Ingreso al final\n3.- Ingreso despues de una posicion\n4.-Regresar al menú");
        opcs=Integer.parseInt(opc);
        
        
        switch(opcs){
            case 1:
                titulo=JOptionPane.showInputDialog("Nombre del Libro");
                autor=JOptionPane.showInputDialog("Autor del Libro");
                isbn=JOptionPane.showInputDialog("ISBN del Libro");
                Libro book=new Libro(titulo,autor,isbn);
                list1.insertarPrincipio(book);
                list1.ver();
                break;
            case 2:
               
                titulo=JOptionPane.showInputDialog("Nombre del Libro");
                autor=JOptionPane.showInputDialog("Autor del Libro");
                isbn=JOptionPane.showInputDialog("ISBN del Libro");
                Libro index=new Libro(titulo,autor,isbn);
                list1.insertarFinal(index);
                list1.ver();
                break;
            case 3:
                //Ingreso en Posicion
                String pos=JOptionPane.showInputDialog("Posicion en que desea agregar?");
                int p=Integer.parseInt(pos);
                titulo=JOptionPane.showInputDialog("Nombre del Libro");
                autor=JOptionPane.showInputDialog("Autor del Libro");
                isbn=JOptionPane.showInputDialog("ISBN del Libro");
                Libro bk=new Libro(titulo,autor,isbn);
                list1.insertarDespues(p,bk);
                list1.ver();
                break;
            case 4:
              
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
        String opc=JOptionPane.showInputDialog("Eliminación de Libro.\n1.-Eliminar primero\n2.-Eliminar último\n3.- Eliminar en posición");
        
          opcs=Integer.parseInt(opc);
        
        
        switch(opcs){
            case 1:
                 nvs=JOptionPane.showConfirmDialog(null,"Seguro que desea eliminar el primero?","Eliminación", JOptionPane.YES_NO_OPTION);
                    if(nvs==JOptionPane.YES_OPTION){
                            list1.eliminaPrincipio(); 
                            list1.ver();
                    }else if(nvs==JOptionPane.NO_OPTION){
                        break;
                    }
               
                break;
            case 2:
                nvs=JOptionPane.showConfirmDialog(null,"Seguro que desea eliminar el Ultimo?","Eliminación", JOptionPane.YES_NO_OPTION);
                    if(nvs==JOptionPane.YES_OPTION){
                            list1.eliminarUltimo();
                    }else if(nvs==JOptionPane.NO_OPTION){
                        break;
                    }
                list1.ver();
                break;
            case 3:
                //Ingreso en Posicion
                 nvs=JOptionPane.showConfirmDialog(null,"Seguro que desea un libro?","Eliminación", JOptionPane.YES_NO_OPTION);
                    if(nvs==JOptionPane.YES_OPTION){
                            String l=JOptionPane.showInputDialog("Ingrese la posicion para eliminar");
                            int ll=Integer.parseInt(l);
                            list1.eliminarLibro(ll);
                    }else if(nvs==JOptionPane.NO_OPTION){
                        break;
                    }
              
                list1.ver();
                break;
                       default:
                System.out.println("No existe la opcion");
                break;
        }
    System.out.println("Datos\n"+list1.ver());
        }

    public static void Buscar(){
        String b=JOptionPane.showInputDialog("Posicion buscada");
        int bs=Integer.parseInt(b);
        //list1.obtener(bs);
        System.out.println("EL libro en la Posición "+b+" es\n "+list1.obtener(bs-1).getTitulo());
        
    }
    
    public static void tamanio(){
        
        JOptionPane.showMessageDialog(null, "El tamaño de la lista es de:  "+list1.contar());
    }
    
      
}
