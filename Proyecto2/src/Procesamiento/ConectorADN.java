/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesamiento;

import Estructuras.Hash;
import Estructuras.ArbolBinario;
import Estructuras.NodoHash;


/**
 * Facilita la interacción entre las estructuras de datos y el procesamiento.
 */
public class ConectorADN {
    private Hash tablaHash;
    private ArbolBinario arbolFrecuencias;

    /**
     * Constructor que inicializa las estructuras vacías.
     */
    public ConectorADN() {
        this.tablaHash = new Hash();
        this.arbolFrecuencias = new ArbolBinario();
    }

    /**
     * Procesa una secuencia de ADN y carga todas las estructuras.
     * @param secuenciaADN Cadena de ADN a procesar
     */
    public void procesarADN(String secuenciaADN) {
        tablaHash = new Hash();
        arbolFrecuencias = new ArbolBinario();
        
        for (int i = 0; i <= secuenciaADN.length() - 3; i++) {
            String triplete = secuenciaADN.substring(i, i + 3);
            if (esTripleteValido(triplete)) {
                tablaHash.guardar(triplete, i);
            }
        }
        
        cargarArbol();
    }

    /**
     * Valida que un triplete contenga solo caracteres válidos.
     * @param triplete Cadena a validar
     * @return true si es válido
     */
    private boolean esTripleteValido(String triplete) {
        for (int i = 0; i < triplete.length(); i++) {
            char c = triplete.charAt(i);
            if (c != 'A' && c != 'T' && c != 'C' && c != 'G') {
                return false;
            }
        }
        return true;
    }

    /**
     * Carga todos los nodos de la tabla hash en el árbol binario.
     */
    private void cargarArbol() {
        for (int i = 0; i < tablaHash.getTabla().length; i++) {
            NodoHash current = tablaHash.getTabla()[i];
            while (current != null) {
                arbolFrecuencias.insertarPorFrecuencia(current);
                current = current.getpNext();
            }
        }
    }

    /**
     * @return Tabla hash con los tripletes
     */
    public Hash getTablaHash() {
        return tablaHash;
    }

    /**
     * Busca un triplete en la tabla hash.
     * @param triplete Patrón a buscar
     * @return Nodo con la información o null si no existe
     */
    public NodoHash buscarPatron(String triplete) {
        return tablaHash.buscar(triplete);
    }
}