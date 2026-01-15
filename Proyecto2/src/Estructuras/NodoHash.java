/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 * Representa un nodo de una tabla hash con manejo de colisiones por encadenamiento.
 * Almacena una cadena, su frecuencia y las posiciones donde aparece.
 */
public class NodoHash {
    private String cadena;
    private NodoPosicion posiciones;
    private int frecuencia;
    private NodoHash pNext;

    /**
     * Constructor que crea un nuevo nodo con una cadena y su posición inicial.
     * 
     * @param cadena La cadena de texto a almacenar en el nodo
     * @param posicion La posición inicial donde aparece la cadena
     */
    public NodoHash(String cadena, int posicion) {
        this.cadena = cadena;
        this.posiciones = new NodoPosicion(posicion);
        this.frecuencia = 1;
    }
    
    /**
     * Incrementa la frecuencia del nodo y añade una nueva posición donde aparece la cadena.
     * 
     * @param posicion La nueva posición donde se encontró la cadena
  
     */
    public void Repetido(int posicion) {
        this.frecuencia++;
        NodoPosicion current = this.getPosiciones();
        while(current.getpNext()!=null) {
            current = current.getpNext();
        }
        current.setpNext(new NodoPosicion(posicion));
    }
    

     /**
     * Obtiene la cadena almacenada en este nodo.
     * @return La cadena de texto almacenada
     */
    public String getCadena() {
        return cadena;
    }

    /**
     * Obtiene la lista de posiciones donde aparece la cadena.
     * @return Primer nodo de la lista de posiciones
     */
    public NodoPosicion getPosiciones() {
        return posiciones;
    }

    /**
     * Obtiene la frecuencia con que aparece la cadena.
     * @return Número de veces que aparece la cadena
     */
    public int getFrecuencia() {
        return frecuencia;
    }

    /**
     * Obtiene el siguiente nodo en la cadena de colisiones.
     * @return Siguiente nodo hash, o null si es el último
     */
    public NodoHash getpNext() {
        return pNext;
    }

    /**
     * Establece el siguiente nodo en la cadena de colisiones.
     * @param pNext Nuevo nodo siguiente
     */
    public void setpNext(NodoHash pNext) {
        this.pNext = pNext;
    }
    
/**
 * Genera una cadena con todas las posiciones almacenadas en este nodo,
 * formateadas como una lista separada por comas.
 * 
 * @return String que contiene todas las posiciones en formato "pos1, pos2, ..., posN".
 *         Si solo hay una posición, devuelve directamente esa posición como String.
 */    
    public String Getposicion(){
        String s = "";
        NodoPosicion current = this.posiciones;
        s += current.getPosicion();
        current = current.getpNext();
        
        while(current!=null){
        s = s + ", " + current.getPosicion();
        current = current.getpNext();

        }
        
        return s;
    }
    
}
