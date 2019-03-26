/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListasEnlazadas;

/**
 *
 * @author Yavhé Sergio Enrique Orozco Valle
 * 0901-17-6739
 * Sección A
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creacion de un objeto 
        ListasEnlazadas miLista=new ListasEnlazadas();
	miLista.InsertarEnPrimero(10); //Asignacion de valores a la clase
	miLista.InsertarEnPrimero(15);
	miLista.InsertarEnPrimero(30);
	miLista.InsertarEnPrimero(50);
	miLista.InsertarEnPrimero(40);
	miLista.InsertarEnPrimero(60);
	System.out.println(miLista.Listar());
	System.out.println("borrar");
	miLista.borrarUltimo();
        miLista.borrarPrimero();
	
	System.out.println(miLista.Listar());
// TODO code application logic here
    }
    
}
