/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author alexandraloynaz
 */
public class NodoColision {
        int indice;
        String existente;
        String nuevo;
        NodoColision pNext;

    public NodoColision(int indice, String existente, String nuevo) {
        this.indice = indice;
        this.existente = existente;
        this.nuevo = nuevo;
        this.pNext = null;
    }
        

}
