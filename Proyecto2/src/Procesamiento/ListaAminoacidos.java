/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesamiento;

/**
 *Lista que contiene todos los aminoacidos, con sus primitivas 
 * @author alexandraloynaz
 */
public class ListaAminoacidos {
    private NodoAminoacidos pFirst;
    private int cont;
/**
 * Funcion que inicializa la lista.
 */
    public ListaAminoacidos() {
        this.pFirst = null;
        this.cont = 0;
    }
/**
 * Revisa si la lista esta vacía
 * @return verdadero si esta vacía, false si es el caso contrario.
 */
    public boolean esVacio() {
        return pFirst == null;
    }
/**
 * Agregar un nodo al final de la lista 
 * @param dato el dato del nodo que se va a agregar
 */
    public void insertarFinal(String tripleta, int frecuencia, String tipo) {
        NodoAminoacidos nuevo = new NodoAminoacidos(tripleta, frecuencia, tipo);
        if (esVacio()) {
            pFirst = nuevo;
        } else {
            NodoAminoacidos aux = pFirst;
            while (aux.getpNext() != null) {
                aux = aux.getpNext();
            }
            aux.setpNext(nuevo);
        }
        cont++;
    }
/**
 * Vacia la lista 
 */
    public void vaciar() {
        pFirst = null;
        cont = 0;
    }
/**
 * Muestra todos lo valores dentro de la lista con una estructura ordenada.
 */
    public String imprimir() {
        String cadena = "";
        NodoAminoacidos aux = pFirst;
        while (aux != null) {
               cadena += "Cadena: " + aux.getCadena()+"\n";
                cadena +=  "Frecuencia: " + aux.getFrecuencia()+"\n"; 
                cadena += " Tipo: " + aux.getTipo()+"\n"; 
                cadena += "--------------------"+"\n";

            aux = aux.getpNext();
        }
        return cadena;
    }
/**
 * Obtiene el primer nodo de la lista.
 * @return el primer nodo
 */
    public NodoAminoacidos getpFirst() {
        return pFirst;
    }
/**
 * Obtiene la cantidad de nodos dentro de la lista 
 * @return el número de nodos dentro de esta lista.
 */
    public int getCont() {
        return cont;
    }
}
    

