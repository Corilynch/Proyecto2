/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 * Clase que guarda la información de una colisión en la tabla hash. Guarda el índice donde ocurrió y las cadenas involucradas.
 * También enlaza con otros nodos de colisión..
 * @author alexandraloynaz
 */
public class NodoColision {
        int indice;
        String existente;
        String nuevo;
        NodoColision pNext;
    /**
     * Constructor del nodo de colisión.
     */
        
    public NodoColision(int indice, String existente, String nuevo) {
        this.indice = indice;
        this.existente = existente;
        this.nuevo = nuevo;
        this.pNext = null;
    }
        

}
