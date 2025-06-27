/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author corinalynch
 */
public class NodoPosicion {
    private final int posicion;
    private NodoPosicion pNext;
    
    public NodoPosicion(int p){
        this.posicion = p;
    }

    /**
     * @return the posicion
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * @return the pNext
     */
    public NodoPosicion getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(NodoPosicion pNext) {
        this.pNext = pNext;
    }
}
