/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de un árbol binario para almacenar y buscar nodos hash organizados por frecuencia.
 * @author corinalynch
 * @version 1.0
 */
public class ArbolBinario {
    private NodoArbol Root;

    /**
     * Obtiene la raíz del árbol binario.
     * @return Nodo raíz del árbol
     */
    public NodoArbol getRoot() {
        return Root;
    }

    /**
     * Establece la raíz del árbol binario.
     * @param Root Nuevo nodo raíz
     */
    public void setRoot(NodoArbol Root) {
        this.Root = Root;
    }
    
    /**
     * Encuentra el nodo con el valor máximo (más a la derecha) en el subárbol.
     * @param Hoja Nodo desde donde comenzar la búsqueda (si es null, comienza desde la raíz)
     * @return Nodo con el valor máximo
     */
    public NodoArbol Mayor(NodoArbol Hoja) {
        if(Hoja==null){
            Hoja = this.Root;
        }
        if(Hoja.getRightTree()!=null){
            return Mayor(Hoja.getRightTree());
        } 
        return Hoja;
    }
    
    /**
     * Encuentra el nodo con el valor mínimo (más a la izquierda) en el subárbol.
     * @param Hoja Nodo desde donde comenzar la búsqueda (si es null, comienza desde la raíz)
     * @return Nodo con el valor mínimo
     */
    public NodoArbol Menor(NodoArbol Hoja) {
        if(Hoja==null){
            Hoja = this.Root;
        }
        if(Hoja.getLeftTree()!=null){
            return Menor(Hoja.getLeftTree());
        } 
        return Hoja;
    }
    
    /**
     * Busca todos los nodos hash con una frecuencia específica.
     * @param frecuencia Frecuencia a buscar
     * @return Lista de nodos hash que coinciden con la frecuencia
     */
    public List<NodoHash> buscarPorFrecuencia(int frecuencia) {
        List<NodoHash> resultados = new ArrayList<>();
        buscarFrecRec(Root, frecuencia, resultados);
        return resultados;
    }
    
    /**
     * Método recursivo auxiliar para buscar por frecuencia.
     * @param nodo Nodo actual en la recursión
     * @param frecuencia Frecuencia buscada
     * @param resultados Lista donde se almacenan los resultados
     */
    private void buscarFrecRec(NodoArbol nodo, int frecuencia, List<NodoHash> resultados) {
        if (nodo == null) return;
        
        if (nodo.getNodo().getFrecuencia() == frecuencia) {
            resultados.add(nodo.getNodo());
        }
        
        buscarFrecRec(nodo.getLeftTree(), frecuencia, resultados);
        buscarFrecRec(nodo.getRightTree(), frecuencia, resultados);
    }
    
    /**
     * Busca nodos hash dentro de un rango de frecuencias.
     * @param min Frecuencia mínima (inclusive)
     * @param max Frecuencia máxima (inclusive)
     * @return Lista de nodos hash en el rango especificado
     */
    public List<NodoHash> buscarPorRango(int min, int max) {
        List<NodoHash> resultados = new ArrayList<>();
        buscarRangoRec(Root, min, max, resultados);
        return resultados;
    }
    
    /**
     * Método recursivo auxiliar para búsqueda por rango.
     * @param nodo Nodo actual en la recursión
     * @param min Límite inferior del rango
     * @param max Límite superior del rango
     * @param resultados Lista donde se almacenan los resultados
     */
    private void buscarRangoRec(NodoArbol nodo, int min, int max, List<NodoHash> resultados) {
        if (nodo == null) return;
        
        int freq = nodo.getNodo().getFrecuencia();
        if (freq >= min && freq <= max) {
            resultados.add(nodo.getNodo());
        }
        
        buscarRangoRec(nodo.getLeftTree(), min, max, resultados);
        buscarRangoRec(nodo.getRightTree(), min, max, resultados);
    }
    
    /**
     * Recorrido preorden del árbol (raíz, izquierdo, derecho).
     * @return Lista de nodos en orden preorden
     */
    public List<NodoHash> preorden() {
        List<NodoHash> resultado = new ArrayList<>();
        preordenRec(Root, resultado);
        return resultado;
    }
    
    /**
     * Método recursivo auxiliar para recorrido preorden.
     * @param nodo Nodo actual en la recursión
     * @param resultado Lista donde se almacena el recorrido
     */
    private void preordenRec(NodoArbol nodo, List<NodoHash> resultado) {
        if (nodo != null) {
            resultado.add(nodo.getNodo());
            preordenRec(nodo.getLeftTree(), resultado);
            preordenRec(nodo.getRightTree(), resultado);
        }
    }
    
    /**
     * Recorrido postorden del árbol (izquierdo, derecho, raíz).
     * @return Lista de nodos en orden postorden
     */
    public List<NodoHash> postorden() {
        List<NodoHash> resultado = new ArrayList<>();
        postordenRec(Root, resultado);
        return resultado;
    }
    
    /**
     * Método recursivo auxiliar para recorrido postorden.
     * @param nodo Nodo actual en la recursión
     * @param resultado Lista donde se almacena el recorrido
     */
    private void postordenRec(NodoArbol nodo, List<NodoHash> resultado) {
        if (nodo != null) {
            postordenRec(nodo.getLeftTree(), resultado);
            postordenRec(nodo.getRightTree(), resultado);
            resultado.add(nodo.getNodo());
        }
    }
    
    /**
     * Recorrido inorden del árbol (izquierdo, raíz, derecho).
     * @return Lista de nodos en orden inorden
     */
    public List<NodoHash> inorden() {
        List<NodoHash> resultado = new ArrayList<>();
        inordenRec(Root, resultado);
        return resultado;
    }
    
    /**
     * Método recursivo auxiliar para recorrido inorden.
     * @param nodo Nodo actual en la recursión
     * @param resultado Lista donde se almacena el recorrido
     */
    private void inordenRec(NodoArbol nodo, List<NodoHash> resultado) {
        if (nodo != null) {
            inordenRec(nodo.getLeftTree(), resultado);
            resultado.add(nodo.getNodo());
            inordenRec(nodo.getRightTree(), resultado);
        }
    }
    
    /**
     * Busca un triplete específico en el árbol.
     * @param triplete Cadena a buscar
     * @return NodoHash que contiene el triplete, o null si no se encuentra
     */
    public NodoHash buscarTriplete(String triplete) {
        return buscarTripleteRec(Root, triplete);
    }
    
    /**
     * Método recursivo auxiliar para búsqueda de tripletes.
     * @param nodo Nodo actual en la recursión
     * @param triplete Cadena a buscar
     * @return NodoHash encontrado o null
     */
    private NodoHash buscarTripleteRec(NodoArbol nodo, String triplete) {
        if (nodo == null) return null;
        
        if (nodo.getNodo().getCadena().equals(triplete)) {
            return nodo.getNodo();
        }
        
        NodoHash izq = buscarTripleteRec(nodo.getLeftTree(), triplete);
        if (izq != null) return izq;
        
        return buscarTripleteRec(nodo.getRightTree(), triplete);
    }
    
    /**
     * Inserta un nuevo nodo hash en el árbol ordenado por frecuencia.
     * @param nodoHash Nodo hash a insertar
     */
    public void insertarPorFrecuencia(NodoHash nodoHash) {
        Root = insertarRec(Root, nodoHash);
    }
    
    /**
     * Método recursivo auxiliar para inserción ordenada.
     * @param raiz Raíz del subárbol actual
     * @param nodoHash Nodo hash a insertar
     * @return Nueva raíz del subárbol
     */
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
}