/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesamiento;

import Estructuras.Hash;
import Estructuras.ArbolBinario;
import Estructuras.ListaPatrones;
import Estructuras.NodoHash;
import java.util.List;


public class ConectorADN {
    private Hash tablaHash;
    private ArbolBinario arbolFrecuencias;
    private ListaPatrones listaPatrones;
    
    public ConectorADN() {
        this.tablaHash = new Hash();
        this.arbolFrecuencias = new ArbolBinario();
        this.listaPatrones = new ListaPatrones();
    }
    
    /**
     * Procesa una secuencia de ADN y carga todas las estructuras
     * @param secuenciaADN Cadena de ADN a procesar
     */
    public void procesarADN(String secuenciaADN) {
        // Limpiar estructuras previas
        tablaHash = new Hash();
        arbolFrecuencias = new ArbolBinario();
        listaPatrones = new ListaPatrones();
        
        // Procesar la secuencia en tripletes
        for (int i = 0; i <= secuenciaADN.length() - 3; i++) {
            String triplete = secuenciaADN.substring(i, i + 3);
            if (triplete.matches("[ATCG]+")) {
                tablaHash.Guardar(triplete, i);
            }
        }
        
        // Cargar el árbol binario y la lista de patrones
        cargarEstructurasAuxiliares();
    }
    
    /**
     * Carga el árbol binario y la lista de patrones desde la tabla hash
     */
    private void cargarEstructurasAuxiliares() {
        for (NodoHash nodo : tablaHash.getTabla()) {
            NodoHash current = nodo;
            while (current != null) {
                arbolFrecuencias.insertarPorFrecuencia(current);
                current = current.getpNext();
            }
        }
        listaPatrones.cargarDesdeHash(tablaHash);
    }
    
    // Métodos de acceso a las estructuras
    public Hash getTablaHash() { return tablaHash; }
    public ArbolBinario getArbolFrecuencias() { return arbolFrecuencias; }
    public ListaPatrones getListaPatrones() { return listaPatrones; }
    
    /**
     * Busca un patrón específico con complejidad O(1) promedio
     * @param triplete Patrón a buscar
     * @return NodoHash con la información o null si no existe
     */
    public NodoHash buscarPatron(String triplete) {
        return tablaHash.Buscar(triplete);
    }
    
    /**
     * Obtiene el patrón más frecuente con complejidad O(log n)
     * @return NodoHash del patrón más frecuente
     */
    public NodoHash obtenerPatronMasFrecuente() {
        return arbolFrecuencias.Mayor(null).getNodo();
    }
    
    /**
     * Obtiene el patrón menos frecuente con complejidad O(log n)
     * @return NodoHash del patrón menos frecuente
     */
    public NodoHash obtenerPatronMenosFrecuente() {
        return arbolFrecuencias.Menor(null).getNodo();
    }
    
    /**
     * Obtiene todos los patrones ordenados por frecuencia
     * @return Lista de nodos hash ordenados por frecuencia descendente
     */
    public List<NodoHash> obtenerPatronesOrdenados() {
        return listaPatrones.getPatrones();
    }
    
    /**
     * Genera reporte de colisiones
     * @return Lista de strings con el reporte
     */
    public List<String> generarReporteColisiones() {
        return tablaHash.getReporteColisiones();
    }
}
