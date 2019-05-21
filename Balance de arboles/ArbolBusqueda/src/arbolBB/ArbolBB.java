/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolBB;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author .
 */

public class ArbolBB {

    private Nodo raiz;
    int num_nodos;
    int alt;
//Se inicializa el constructor
    public ArbolBB() {
        raiz = null;
    }
    public int obtenerqe(Nodo r){
        if(r==null){
        return -1;
        }else{
        return r.intFacEq;
        } 
    }//EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
    public Nodo rotaizq(Nodo r){
    Nodo aux= r.nodoIzquierda;
    r.nodoIzquierda=aux.nodoDerecha;
    aux.nodoDerecha=r;
    r.intFacEq=Math.max(obtenerqe(r.nodoIzquierda), obtenerqe(r.nodoDerecha))+1;
    aux.intFacEq=Math.max(obtenerqe(aux.nodoIzquierda),obtenerqe(aux.nodoDerecha))+1;
    return aux;
    }
        public Nodo rotader(Nodo r){
    Nodo aux= r.nodoDerecha;
    r.nodoDerecha=aux.nodoIzquierda;
    aux.nodoIzquierda=r;
    r.intFacEq=Math.max(obtenerqe(r.nodoIzquierda), obtenerqe(r.nodoDerecha))+1;
    aux.intFacEq=Math.max(obtenerqe(aux.nodoIzquierda),obtenerqe(aux.nodoDerecha))+1;
    return aux;
    }
        public Nodo rotadobleizq(Nodo r){
        Nodo aux;
        r.nodoIzquierda=rotader(r.nodoIzquierda);
        aux=rotaizq(r);
        return aux;
        }
        public Nodo rotadobleder(Nodo r){
        Nodo aux;
        r.nodoDerecha=rotaizq(r.nodoDerecha);
        aux=rotader(r);
        return aux;
        }
        public Nodo insertaravl(Nodo nuevo, Nodo sub){
        Nodo nuevop=sub;
         if(nuevo.intdato<sub.intdato){
             if(sub.nodoIzquierda==null){
             sub.nodoIzquierda=nuevo;
             }else{
             sub.nodoIzquierda=insertaravl(nuevo, sub.nodoIzquierda);
            if(obtenerqe(sub.nodoIzquierda)-obtenerqe(sub.nodoDerecha)==2){
            if(nuevo.intdato<sub.nodoIzquierda.intdato){
                nuevop=rotaizq(sub);
            }else{
            nuevop=rotadobleizq(sub);
            }
            }
             }
         }else if(nuevo.intdato>sub.intdato){
         if(sub.nodoDerecha==null){
         sub.nodoDerecha=nuevo;
         }else{
         sub.nodoDerecha=insertaravl(nuevo,sub.nodoDerecha);
         if(obtenerqe(sub.nodoDerecha)-obtenerqe(sub.nodoIzquierda)==2){
             if(nuevo.intdato>sub.nodoDerecha.intdato){
             nuevop=rotader(sub);
             }else{
             nuevop=rotadobleder(sub);
             
             }
         }
         }
         }else{
         System.out.println("Nodo duplicado, no se puede colocar nodos duplicados");
         }
         //actualizando altura
         if((sub.nodoIzquierda==null)&&(sub.nodoDerecha!=null)){
         sub.intFacEq=sub.nodoDerecha.intFacEq+1;
         }else if((sub.nodoDerecha==null)&&(sub.nodoIzquierda!=null)){
            sub.intFacEq=sub.nodoIzquierda.intFacEq+1;         
         }else{
         sub.intFacEq=Math.max(obtenerqe(sub.nodoIzquierda),obtenerqe(sub.nodoDerecha))+1;         
         }
         return nuevop;
        }
        public boolean insertar(int d){
          Nodo nuevo= new Nodo(d,null,null);
        if(raiz==null){
        raiz=nuevo;
        }else{
        raiz=insertaravl(nuevo,raiz);
        }
        return true;
        }//EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
    public Nodo getRaiz() {
        return raiz;
    } 

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    //Recorrido preorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList preOrden() {
        LinkedList rec = new LinkedList();
        preorden(raiz, rec);
        return rec;
    }
    
    public void preorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            recorrido.add(aux.getDato());
            preorden(aux.getIzquierda(), recorrido);
            preorden(aux.getDerecha(), recorrido);
        }
    }

    //Recorrido inorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList inOrden() {
        LinkedList rec = new LinkedList();
        inorden(raiz, rec);
        return rec;
    }
    
    public void inorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            inorden(aux.getIzquierda(), recorrido);
            recorrido.add(aux.getDato());
            inorden(aux.getDerecha(), recorrido);
        }
    }

    //Recorrido postorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList postOrden() {
        LinkedList rec = new LinkedList();
        postorden(raiz, rec);
        return rec;
    }
    public void postorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            postorden(aux.getIzquierda(), recorrido);
            postorden(aux.getDerecha(), recorrido);
            recorrido.add(aux.getDato());
        }
    }

    //Metodo para verificar si hay un nodo en el arbol
    public boolean existe(int dato) {
        Nodo aux = raiz;
        while (aux != null) {
            if (dato == aux.getDato()) {
                return true;
            } else if (dato > aux.getDato()) {
                aux = aux.getDerecha();
            } else {
                aux = aux.getIzquierda();
            }
        }
        return false;
    }

     public JPanel getdibujo() {
        return new ArbolExpresionGrafico(this);
    }
}
