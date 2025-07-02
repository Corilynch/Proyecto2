/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author corinalynch
 */
public class NodoHash {
    private String cadena;
    private NodoPosicion posiciones;
    private int frecuencia;
    private NodoHash pNext;

    public NodoHash(String cadena, int posicion) {
        this.cadena = cadena;
        this.posiciones = new NodoPosicion(posicion);
        this.frecuencia = 1;
    }
    
    public void Repetido(int posicion){
        this.frecuencia++;
        NodoPosicion current = this.getPosiciones();
        while(current.getpNext()!=null){
            current = current.getpNext();
        }
        current.setpNext(new NodoPosicion(posicion));
    }
    
    

    /**
     * @return the cadena
     */
    public String getCadena() {
        return cadena;
    }

    /**
     * @return the frecuencia
     */
    public int getFrecuencia() {
        return frecuencia;
    }

    /**
     * @return the posiciones
     */
    public NodoPosicion getPosiciones() {
        return posiciones;
    }

    /**
     * @return the pNext
     */
    public NodoHash getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(NodoHash pNext) {
        this.pNext = pNext;
    }
    
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
