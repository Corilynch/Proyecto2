/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesamiento;

/**
 * Nodo para la lista simple de los reportes
 * @author alexandraloynaz
 */
public class NodoReportes {
    private String dato; 
    private NodoReportes pNext;

    public NodoReportes(String dato) {
        this.dato = dato;
        this.pNext = null;
    }

    /**
     * @return the dato
     */
    public String getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(String dato) {
        this.dato = dato;
    }

    /**
     * @return the pNext
     */
    public NodoReportes getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(NodoReportes pNext) {
        this.pNext = pNext;
    }
    
    
    
    
}
