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
        private int indice;
        private String existente;
        private String nuevo;
        private NodoColision pNext;
    /**
     * Inicializa un nodo que guarda la colisión ocurrida
     * @param indice el indice donde ocurre la colisión
     * @param existente la cadena que ya se encontraba en ese indice
     * @param nuevo la cadena que causo la colisión
     */
    public NodoColision(int indice, String existente, String nuevo) {
        this.indice = indice;
        this.existente = existente;
        this.nuevo = nuevo;
        this.pNext = null;
    }

    /**
     * Obtiene el indice 
     * @return el indice
     */
    public int getIndice() {
        return indice;
    }

    /**
     * Establece el indice
     * @param indice el indice que se va a establecer
     */
    public void setIndice(int indice) {
        this.indice = indice;
    }

    /**
     * Obtiene la cadena que se encontraba en ese indice
     * @return la cadena 
     */
    public String getExistente() {
        return existente;
    }

    /**
     * Establece una cadena existente 
     * @param existente la nueva cadena que se encontrará en existente 
     */
    public void setExistente(String existente) {
        this.existente = existente;
    }

    /**
     * Obtiene la cadena nueva (que causó la colisión)
     * @return regresa la cadena que causó la colisión
     */
    public String getNuevo() {
        return nuevo;
    }

    /**
     * Establece la nueva cadena que causa la colisión
     * @param nuevo la nueva cadena que causará la colisión
     */
    public void setNuevo(String nuevo) {
        this.nuevo = nuevo;
    }

    /**
     * Obtiene el nodo siguiente a la colisión
     * @return el nodo siguiente 
     */
    public NodoColision getpNext() {
        return pNext;
    }

    /**
     * Establece el Nodo Siguiente a la colisión
     * @param pNext el Nodo que se convertirá en el siguiente
     */
    public void setpNext(NodoColision pNext) {
        this.pNext = pNext;
    }

    
        

}
