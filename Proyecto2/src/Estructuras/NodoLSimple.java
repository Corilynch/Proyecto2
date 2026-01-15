/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 * Clase nodo que guarda un NodoHash de información
 * @author alexandraloynaz
 */
public class NodoLSimple {
    private NodoHash datos; 
    private NodoLSimple pNext; 
/**
 * Contructor de la clase
 * @param datos el dato que se va a guardar en el nodo 
 */
    public NodoLSimple(NodoHash datos) {
        this.datos = datos;
        this.pNext = null;
    }

    /**
     * Obtiene el string del nodo 
     * @return the datos
     */
    public NodoHash getDatos() {
        return datos;
    }

    /**
     * establece el string de un nodo 
     * @param datos el nuevo dato que tendra 
     */
    public void setDatos(NodoHash datos) {
        this.datos = datos;
    }

   
    /**
     * Obtiene el nodo siguiente al que estamos
     * @return the pNext
     */
    public NodoLSimple getpNext() {
        return pNext;
    }

    /**
     * Establece el nodo siguiente al que estamos 
     * @param pNext the pNext to set
     */
    public void setpNext(NodoLSimple pNext) {
        this.pNext = pNext;
    }
    
    
    
    
}

