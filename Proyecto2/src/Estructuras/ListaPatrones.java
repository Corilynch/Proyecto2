/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Clase para manejar la lista de patrones ordenados por frecuencia
 */
public class ListaPatrones {
    private ArrayList<NodoHash> patrones;
    
    public ListaPatrones() {
        patrones = new ArrayList<>();
    }
    
    /**
     * Carga los patrones desde la tabla hash
     * @param tabla Hash table con los patrones
     */
    public void cargarDesdeHash(Hash tabla) {
        patrones.clear();
        for (NodoHash nodo : tabla.getTabla()) {
            while (nodo != null) {
                patrones.add(nodo);
                nodo = nodo.getpNext();
            }
        }
        ordenarPorFrecuencia();
    }
    
    /**
     * Ordena los patrones por frecuencia (de mayor a menor)
     */
    private void ordenarPorFrecuencia() {
        Collections.sort(patrones, new Comparator<NodoHash>() {
            @Override
            public int compare(NodoHash o1, NodoHash o2) {
                return Integer.compare(o2.getFrecuencia(), o1.getFrecuencia());
            }
        });
    }
    
    /**
     * @return Lista de patrones ordenados
     */
    public ArrayList<NodoHash> getPatrones() {
        return patrones;
    }
    
    /**
     * Busca un patrón específico
     * @param triplete Patrón a buscar
     * @return NodoHash con la información o null si no existe
     */
    public NodoHash buscarPatron(String triplete) {
        for (NodoHash nodo : patrones) {
            if (nodo.getCadena().equals(triplete)) {
                return nodo;
            }
        }
        return null;
    }
    
    /**
     * @return El patrón más frecuente
     */
    public NodoHash getMasFrecuente() {
        return patrones.isEmpty() ? null : patrones.get(0);
    }
    
    /**
     * @return El patrón menos frecuente
     */
    public NodoHash getMenosFrecuente() {
        return patrones.isEmpty() ? null : patrones.get(patrones.size()-1);
    }
}

