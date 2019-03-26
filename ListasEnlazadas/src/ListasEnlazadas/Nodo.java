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
public class Nodo 
{
    //Creación del nodo
    	int info;
	public Nodo Siguiente;
	public Nodo (int dato)
	{
		info=dato;
	}
	public void verNodo()
	{
		System.out.print("(  "+info+" )");
	}

}
