/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 * Implementación de árbol binario de búsqueda ordenado por frecuencia.
 */
public class ArbolBinario {
    private NodoArbol Root;

    /**
     * Inserta un nodo hash en el árbol ordenado por frecuencia.
     * @param nodoHash Nodo a insertar
     */
    public void insertarPorFrecuencia(NodoHash nodoHash) {
        Root = insertarRec(Root, nodoHash);
    }

    private NodoArbol insertarRec(NodoArbol raiz, NodoHash nodoHash) {
        if (raiz == null) {
            NodoArbol nuevo = new NodoArbol();
            nuevo.setNodoTriplete(nodoHash);
            return nuevo;
        }
        
        if (nodoHash.getFrecuencia() < raiz.getNodo().getFrecuencia()) {
            raiz.setLeftTree(insertarRec(raiz.getLeftTree(), nodoHash));
        } else {
            raiz.setRightTree(insertarRec(raiz.getRightTree(), nodoHash));
        }
        
        return raiz;
    }

    /**
     * Encuentra el nodo con mayor frecuencia.
     * @param Hoja Nodo desde donde comenzar (null para comenzar desde raíz)
     * @return Nodo con mayor frecuencia
     */
    public NodoArbol Mayor(NodoArbol Hoja) {
        if(Hoja == null) {
            Hoja = this.Root;
        }
        if(Hoja.getRightTree() != null) {
            return Mayor(Hoja.getRightTree());
        } 
        return Hoja;
    }

    /**
     * Encuentra el nodo con menor frecuencia.
     * @param Hoja Nodo desde donde comenzar (null para comenzar desde raíz)
     * @return Nodo con menor frecuencia
     */
    public NodoArbol Menor(NodoArbol Hoja) {
        if(Hoja == null) {
            Hoja = this.Root;
        }
        if(Hoja.getLeftTree() != null) {
            return Menor(Hoja.getLeftTree());
        } 
        return Hoja;
    }

    /**
     * @return Nodo raíz del árbol
     */
    public NodoArbol getRoot() {
        return Root;
    }
}