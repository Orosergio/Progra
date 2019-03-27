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
public class ListasEnlazadas
{
    	Nodo Primero;
        //Inicialización del nodo como nulo
	public ListasEnlazadas()
	{
		Primero=null;
	}
	public boolean vacia()
	{       //Verifica si existen elementos  en la lista
		if (Primero==null)
		{
			return(true);
		} else
		{
			return(false);
		}
	}
	public void InsertarEnPrimero(int Dato)
	{
		Nodo Temporal=new Nodo(Dato); //Crea el nodo temporal
		Temporal.Siguiente=Primero; //corre al primero
		Primero=Temporal;   //lo coloca de primero
	}
	public void borrarPrimero()
	{
		Primero=Primero.Siguiente;
                //Elimina un nodo, omitiendo el primero
	}
	public String Listar()
	{
		String Dato=" ";
		Nodo aux=Primero;
		while (aux!=null)
		{
			Dato+="{" + aux.info + "}";
			aux=aux.Siguiente;
		}//Muesta los nodos, en lista
		return(Dato);
	}
	public void borrarUltimo()
	{   //Omite el ultimo nodo
		Nodo anterior=Primero;
		Nodo actual=Primero;
		while (actual.Siguiente!=null)//Mientras que el nodo no sea vacio
		{
			anterior=actual;
			actual=actual.Siguiente;
		}
		anterior.Siguiente=null;
	}
	public void borrarPosicion(int pos)
	{   
                //Elimina la posicion en la que se encuentra al terminar el metdo
		Nodo anterior=Primero;
		Nodo actual=Primero;
		int k=0;
		if (pos>0)
		{
			while (k!=pos && actual.Siguiente != null)
			{ //Ciclo para eliminar la posición e ir corriendo espacios
				anterior=actual;
				actual=actual.Siguiente;
				k++;
				System.out.println("K       "+k);
			}
			anterior.Siguiente=actual.Siguiente;
		}
	}
        
        public void insertarEntre(int pos, int Dato){
                
                Nodo Temporal=new Nodo(Dato); //Crea el nodo temporal
                Nodo anterior=Primero;
		Nodo actual=Primero;
		int k=0;
		if (pos>0)
		{
			while (k!=pos && actual.Siguiente != null)
			{ //Ciclo para eliminar la posición e ir corriendo espacios
				anterior=actual;
				actual=actual.Siguiente;
                                Temporal.Siguiente=actual;
				k++;
			}
			//anterior.Siguiente=actual.Siguiente;
              
		anterior.Siguiente=Temporal;
                actual=Temporal.Siguiente;
                //Temporal.Siguiente=anterior.Siguiente; //corre al primero
		//Primero=Temporal;   //lo coloca de primero
		} 
        }
        
        public int localizar(int Dato){
                int s=0;
		Nodo aux=Primero;
		while (aux.info!=Dato)
		{
			aux=aux.Siguiente;
                        s++;
		}//Muesta los nodos, en lista
		return(s);
        }

}
