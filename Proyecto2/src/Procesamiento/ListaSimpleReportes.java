/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesamiento;

/**
 * Lista simple que guarda un string para los reportes.
 * @author alexandraloynaz
 */
public class ListaSimpleReportes {
    private NodoReportes pFirst; 
    private int cont; 

    public ListaSimpleReportes() {
        this.pFirst = null;
        this.cont = 0;
    }
    public boolean esVacio() {
        return pFirst == null;
    }

    public void insertarFinal(String dato) {
        NodoReportes nuevo = new NodoReportes(dato);
        if (esVacio()) {
            pFirst = nuevo;
        } else {
            NodoReportes aux = pFirst;
            while (aux.getpNext() != null) {
                aux = aux.getpNext();
            }
            aux.setpNext(nuevo);
        }
        cont++;
    }

    public void imprimir() {
        NodoReportes aux = pFirst;
        while (aux != null) {
            System.out.println(aux.getDato());
            aux = aux.getpNext();
        }
    }
    /**
     * @return the pFirsrt
     */
    public NodoReportes getpFirsrt() {
        return pFirst;
    }

    /**
     * @param pFirsrt the pFirsrt to set
     */
    public void setpFirsrt(NodoReportes pFirsrt) {
        this.pFirst = pFirst;
    }

    /**
     * @return the cont
     */
    public int getCont() {
        return cont;
    }

    /**
     * @param cont the cont to set
     */
    public void setCont(int cont) {
        this.cont = cont;
    }
    
    
    
}
