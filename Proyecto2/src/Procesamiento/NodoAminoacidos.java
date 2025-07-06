/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesamiento;

/**
 *Clase que guarda la informacion de cada aminoácido
 * @author alexandraloynaz
 */
public class NodoAminoacidos {
    private String cadena;
    private int frecuencia;
    private String tipo;
    private NodoAminoacidos pNext;
/**
 * Inicializa un nuevo nodo con su información
 * @param dato todo la información de ese aminoacido
 */
    public NodoAminoacidos(String cadena, int frecuencia, String tipo) {
        this.cadena = cadena;
        this.frecuencia = frecuencia;
        this.tipo = tipo;
        this.pNext = null;

    }     

/**
 * Obtiene el nodo siguiente al actual
 * @return el nodo siguiente al actual
 */
    public NodoAminoacidos getpNext() {
        return pNext;
    }
/**
 * Establece el nodo siguiente al actual
 * @param pNext el nodo establecido como el siguiente al actual.
 */
    public void setpNext(NodoAminoacidos pNext) {
        this.pNext = pNext;
    }

    /**
     * Obtiene la cadena de ese nodo 
     * @return la cadena dentro del nodo
     */
    public String getCadena() {
        return cadena;
    }

    /**
     * Establece la cadena del nodo 
     * @param cadena la cadena del nodo a establecer 
     */
    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    /**
     * Obtiene la frecuencia de esa cadena
     * @return la cantidad de veces que esa cadena aparece (frecuencia)
     */
    public int getFrecuencia() {
        return frecuencia;
    }

    /**
     * Establece la frecuencia de esa cadena 
     * @param frecuencia la nueva frecuencia de esa cadena 
     */
    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    /**
     * Obtiene el tipo de aminoácido que ese esa cadena 
     * @return el tipo de aminoácido.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de aminoácido de ese cadena 
     * @param tipo el tipo de aminoácido.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
    

