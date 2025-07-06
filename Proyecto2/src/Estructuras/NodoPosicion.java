/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 * Clase que guarda una posición donde aparece un triplete en la secuencia de ADN.
 * Cada nodo enlaza con otro para formar una lista de posiciones.
 * @author corinalynch
 */
public class NodoPosicion {
    private final int posicion;
    private NodoPosicion pNext;
    /**
     * Constructor del nodo de posición.
     * @param p La posición donde se encontró el triplete   
     */
    public NodoPosicion(int p){
        this.posicion = p;
    }

    /**
     * Obtiene la posición almacenada en este nodo.
     * @return la posición de la secuencia 
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * Obtiene el nodo siguiente al actual.
     * @return el nodo siguiente
     */
    public NodoPosicion getpNext() {
        return pNext;
    }

    /**
     * Establece el nodo siguiente al actual
     * @param pNext el nodo siguiente al actual
     */
    public void setpNext(NodoPosicion pNext) {
        this.pNext = pNext;
    }
}
