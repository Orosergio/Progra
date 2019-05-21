/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolBB;

/**
 *
 * @Yavhé Sergio Enrique Orozco Valle
 * 0901-17-6739
 */
public class Nodo {
    public int intdato, intFacEq;
    public Nodo nodoIzquierda,nodoDerecha;
    //Inicializa el constructor de la clase Nodo
    public Nodo(int dato, Nodo izq, Nodo der) {//Recibe parametros 
        this.intdato = dato; //Asignacion a variables lo recibido en parametros
        this.nodoIzquierda = izq;
        this.nodoDerecha = der;
        this.intFacEq=0;//Inicializacion de la variable factor de equilibrio
    }

    public int getDato() {
        return intdato;//retorna dato
    }

    public void setDato(int dato) {
        this.intdato = dato; //Asigna a variable el dato obtenido
    }

    public Nodo getIzquierda() {
        return nodoIzquierda;//retorna el nodo
    }

    public void setIzquierda(Nodo izq) {
        this.nodoIzquierda = izq; //Asigna valor obtenido a variable
    }

    public Nodo getDerecha() {
        return nodoDerecha;//Retorna derecha
    }

    public void setDerecha(Nodo der) {
        this.nodoDerecha = der;//Asignacion a variable
    }
 
}
