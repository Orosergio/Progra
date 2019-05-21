
package arbolBB;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author
 */
public class SimuladorArbolBinario {

    ArbolBB ABBmiArbol = new ArbolBB();

    public SimuladorArbolBinario() {
    }

    public boolean insertar(Integer dato) {
        return (this.ABBmiArbol.insertar(dato));//Regresa el valor que se encuentra en el metodo
    }
    //metodo para mostrar los recorridos del arbol
    public String preOrden() {
        LinkedList lkit = this.ABBmiArbol.preOrden();
        return (recorrido(lkit, "Recorrido PreOrden"));//regresa el calor que se encuentra en ese metodo
    }

    public String inOrden() {
        LinkedList lkit = this.ABBmiArbol.inOrden();
        return (recorrido(lkit, "Recorrido InOrden"));//regresa el calor que se encuentra en ese metodo
    }

    public String postOrden() {
        LinkedList lkit = this.ABBmiArbol.postOrden();
        return (recorrido(lkit, "Recorrido PosOrden"));//regresa el calor que se encuentra en ese metodo
    }
    
    //metodo para poder mostrar los tipos d recorrido
    private String recorrido(LinkedList lkit, String strmsg) {
        int i = 0;
        String strr = strmsg + "\n"; //Muesta mensaje y un salto de pagina
        while (i < lkit.size()) {//Entra en un bucle 
            strr += "\t" + lkit.get(i).toString() + "";
            i++;
        }
        return (strr);
    }
    
    
    //Metodo para buscar dato en el nodo
    public String buscar(Integer intdato) {
        boolean boolsiEsta = this.ABBmiArbol.existe(intdato); //Pone en variable booleana lo que esta en ese metodo
        String strr = "El dato:" + intdato.toString() + "\n";//Muesta un mensaje con el dato
        strr += boolsiEsta ? "Si se encuentra en el arbol" : "No se encuentra en el arbol";//Verificacion de existencia
        return (strr);
    }

    public JPanel getDibujo() {
        return this.ABBmiArbol.getdibujo();
    }
}
