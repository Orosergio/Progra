/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuralibros;

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
        
	public void insertarPrincipio(Libro libro) {
		Nodo nodo=new Nodo(libro);//paso 1)Recibe parametro de libro
		nodo.siguiente=cabeza; //paso 2)cabeza esta actualmente en null
		cabeza=nodo;//paso 3) cabeza toma parametro de paso 1.
		longitud++;//La longitud se incrementa en 1.	
               
	}
        
	public void insertarFinal(Libro libro) {
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
	public void insertarDespues(int n, Libro libro) {//Ingreso en una posición definida
		Nodo nodo=new Nodo(libro);//Recibe el parámetro "libro"
		if (cabeza==null) {
			cabeza=nodo;//Revisa que no este vacio la lista, si la esta la llena con el dato
		} else {
			Nodo puntero=cabeza;
			int contador=0;
			while (contador<n && puntero.siguiente!=null) {//Mientras que el contador sea menor que el numero dado y no este vacia la siguiente posicion
				puntero=puntero.siguiente;//Se ira recorriendo la lista hasta encontrar la posicion
				contador++;//Aumenta el valor del contador
			}
			nodo.siguiente=puntero.siguiente; 
			puntero.siguiente=nodo;
		}
		longitud++;//Incremento de la longitud
              
	}
	public Libro obtener(int n) {
		if (cabeza==null) {
			return null;//Si la lista esta vacia, regreso que esta vacia 
		} else {
			Nodo puntero=cabeza; //Creo variable puntero y tomo el valor de cabeza(que tiene el ultimo nodo)
			int contador=0;
			while (contador<n && puntero.siguiente!=null) {//Mientras el contador sea menor a parametro "n" y puntero.sig no este vacia
				puntero=puntero.siguiente;//Recorre lista
				contador++;//Aumenta contador
			}
			if (contador!=n) {
				return null; //No encuentra el número en esa posicion
			} else {
				return puntero.libro; //Regresa el libro que busca
			}
		}
	}
	public int contar() {
		return longitud; //Toma ventaja de todos los contadores de longitud de las demas funciones
	}
        public boolean estaVacia() {
            return cabeza==null; //cabeza se vuelve null
        }
        public void eliminaPrincipio() {
            if (cabeza!=null){//Si hay algo en cabeza
                Nodo primer = cabeza;
                cabeza=cabeza.siguiente;
                longitud--;//Decrementa
            }
        }
        public void eliminarUltimo() {
            if (cabeza!= null) {//Si hay algo en cabeza
                if (cabeza.siguiente==null) {//Si el que sigue despues es null, si se encuentra en la ultima posicion
                    cabeza=null;  //entonces cabeza es null
                    longitud--;//La longitud se decrementa
                } else {//Si no esta en la ultima posición
                    Nodo puntero=cabeza;//Variable tipo nodo "puntero" tomara el valor de cabeza
                    while (puntero.siguiente.siguiente!=null) {                    
                        puntero=puntero.siguiente;//Recorrera la lista
                    }
                    puntero.siguiente=null;
                    longitud--;//Decrementa la fila
                }
            }
        }
        public void eliminarLibro(int n) {
            if (cabeza!=null){//verifica si esta vacia "cabeza", mientras que no
                if (n==0){//si el parametro es igual a "0"...
                    Nodo primer=cabeza; //Crear variable tipo nodo "Primer" y asigna lo que tiene "cabeza"
                    cabeza=cabeza.siguiente;//cabeza tendra lo que tiene cabeza.siguiente
                    primer.siguiente=null;//primer(cabeza).siguiente será null
                    longitud--;//Decremento de longitud
                } else if (n<longitud) {//Si el parametro es menor que la longitud 
                    Nodo puntero=cabeza;//Crea variable tipo nodo "puntero" y le asigna "cabeza"
                    int contador=0;//Inicializa un contador
                    while (contador<(n-1)){//Mientras que el contador sea menor que n-1
                        puntero=puntero.siguiente;//recorrera la lista
                        contador++;//aumento de contador
                    }
                    Nodo temp=puntero.siguiente; //1 2 3 4 5 6 7 
                    puntero.siguiente=temp.siguiente;
                    temp.siguiente=null;
                    longitud--;
                }
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
