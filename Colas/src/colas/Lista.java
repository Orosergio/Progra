/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colas;

/**
 *
 * @author alumno
 */
public class Lista {
	private Nodo cabeza=null;
	private int longitud=0;
        
	private class Nodo {
		public Libro libro;
		public Nodo siguiente=null;
		public Nodo(Libro libro) {
			this.libro=libro;
		}
	}
        
	        
	public void QUEUE(Libro libro) {
		Nodo nodo=new Nodo(libro);//Paso 1)Recibe parametro "libro"
		if (cabeza==null) {//si no hay ninguna dato
			cabeza=nodo;
		} else {
			Nodo puntero=cabeza;//Creacion de variable tipo nodo llamada puntero que sera lo que tiene cabeza
			while (puntero.siguiente!=null) { //Mientras que exista algo en puntero.siguiente
				puntero=puntero.siguiente;//Va recorriendo cada lugar
			}
			puntero.siguiente=nodo;//Al estar vacio puntero.siguiente asigna el ultimo valor
		}
		longitud++;//Incremento en la longitud
               
	}
	
	public Libro TOP() {
		if (cabeza==null) {
			return null;//Si la lista esta vacia, regreso que esta vacia 
		} else {
			Nodo puntero=cabeza; //Creo variable puntero y tomo el valor de cabeza(que tiene el ultimo nodo)
			return puntero.libro; //Regresa el libro que busca
			
		}
	}
	public int contar() {
		return longitud; //Toma ventaja de todos los contadores de longitud de las demas funciones
	}
        public boolean estaVacia() {
            return cabeza==null; //cabeza se vuelve null
        }
      
         public void DEQUEUE() {
            if (cabeza!=null){//Si hay algo en cabeza
                Nodo primer = cabeza;
                cabeza=cabeza.siguiente;
                longitud--;//Decrementa
            }
        }
     
        
        public String ver(){
            String dato="";
            Nodo aux=cabeza;
            while(aux!=null){
                
                dato+= "{Titulo: "+aux.libro.getTitulo()+"         Autor: "+aux.libro.getAutor()+"         ISBN: "+aux.libro.getIsbn()+"}\n\n";
               
                aux=aux.siguiente;
            }
                 
          return (dato);
        }
        
   
}
