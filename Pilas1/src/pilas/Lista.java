/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

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
        
	public void PUSH(Libro libro) {
		Nodo nodo=new Nodo(libro);//paso 1)Recibe parametro de libro
		nodo.siguiente=cabeza; //paso 2)cabeza esta actualmente en null
		cabeza=nodo;//paso 3) cabeza toma parametro de paso 1.
		longitud++;//La longitud se incrementa en 1.	
               
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
        public void POP() {
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
