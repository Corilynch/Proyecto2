/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author corinalynch
 */
public class ArbolBinario {
    private NodoArbol Root;

    public NodoArbol getRoot() {
        return Root;
    }

    public void setRoot(NodoArbol Root) {
        this.Root = Root;
    }
    
    public NodoArbol Mayor(NodoArbol Hoja){
        if(Hoja==null){
            Hoja = this.Root;
        }
        if(Hoja.getRightTree()!=null){
            return Mayor(Hoja.getRightTree());
        } 
        return Hoja;
    }
    
    public NodoArbol Menor(NodoArbol Hoja){
        if(Hoja==null){
            Hoja = this.Root;
        }
        if(Hoja.getLeftTree()!=null){
            return Mayor(Hoja.getLeftTree());
        } 
        return Hoja;
    }
    
    public List<NodoHash> buscarPorFrecuencia(int frecuencia) {
        List<NodoHash> resultados = new ArrayList<>();
        buscarFrecRec(Root, frecuencia, resultados);
        return resultados;
    }
    
    private void buscarFrecRec(NodoArbol nodo, int frecuencia, List<NodoHash> resultados) {
        if (nodo == null) return;
        
        if (nodo.getNodo().getFrecuencia() == frecuencia) {
            resultados.add(nodo.getNodo());
        }
        
        buscarFrecRec(nodo.getLeftTree(), frecuencia, resultados);
        buscarFrecRec(nodo.getRightTree(), frecuencia, resultados);
    }
    
    public List<NodoHash> buscarPorRango(int min, int max) {
        List<NodoHash> resultados = new ArrayList<>();
        buscarRangoRec(Root, min, max, resultados);
        return resultados;
    }
    
    private void buscarRangoRec(NodoArbol nodo, int min, int max, List<NodoHash> resultados) {
        if (nodo == null) return;
        
        int freq = nodo.getNodo().getFrecuencia();
        if (freq >= min && freq <= max) {
            resultados.add(nodo.getNodo());
        }
        
        buscarRangoRec(nodo.getLeftTree(), min, max, resultados);
        buscarRangoRec(nodo.getRightTree(), min, max, resultados);
    }
    
    public List<NodoHash> preorden() {
        List<NodoHash> resultado = new ArrayList<>();
        preordenRec(Root, resultado);
        return resultado;
    }
    
    private void preordenRec(NodoArbol nodo, List<NodoHash> resultado) {
        if (nodo != null) {
            resultado.add(nodo.getNodo());
            preordenRec(nodo.getLeftTree(), resultado);
            preordenRec(nodo.getRightTree(), resultado);
        }
    }
    
    public List<NodoHash> postorden() {
        List<NodoHash> resultado = new ArrayList<>();
        postordenRec(Root, resultado);
        return resultado;
    }
    
    private void postordenRec(NodoArbol nodo, List<NodoHash> resultado) {
        if (nodo != null) {
            postordenRec(nodo.getLeftTree(), resultado);
            postordenRec(nodo.getRightTree(), resultado);
            resultado.add(nodo.getNodo());
        }
    }
    
    public List<NodoHash> inorden() {
        List<NodoHash> resultado = new ArrayList<>();
        inordenRec(Root, resultado);
        return resultado;
    }
    
    private void inordenRec(NodoArbol nodo, List<NodoHash> resultado) {
        if (nodo != null) {
            inordenRec(nodo.getLeftTree(), resultado);
            resultado.add(nodo.getNodo());
            inordenRec(nodo.getRightTree(), resultado);
        }
    }
    
    public NodoHash buscarTriplete(String triplete) {
        return buscarTripleteRec(Root, triplete);
    }
    
    private NodoHash buscarTripleteRec(NodoArbol nodo, String triplete) {
        if (nodo == null) return null;
        
        if (nodo.getNodo().getCadena().equals(triplete)) {
            return nodo.getNodo();
        }
        
        NodoHash izq = buscarTripleteRec(nodo.getLeftTree(), triplete);
        if (izq != null) return izq;
        
        return buscarTripleteRec(nodo.getRightTree(), triplete);
    }
    
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
}