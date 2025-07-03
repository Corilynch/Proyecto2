/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementación de una tabla hash que maneja colisiones mediante encadenamiento.
 * Incluye funcionalidad para registrar y reportar colisiones.
 * 
 * @author corinalynch
 * @version 1.0
 */
public class Hash {
  
    private NodoHash[] Tabla;
    private int size;
    private int totalColisiones;
    private Map<Integer, List<String>> registroColisiones;
    private List<String> listaColisiones;
    
    /**
     * Constructor que inicializa una tabla hash con tamaño por defecto (10).
     */
    public Hash() {
        this.size = 10;
        this.Tabla = new NodoHash[size];
        this.totalColisiones = 0;
        this.registroColisiones = new HashMap<>();
        this.listaColisiones = new ArrayList<>();
    }
    
    /**
     * Almacena un triplete en la tabla hash.
     * @param triplete Cadena a almacenar
     * @param posicion Posición asociada al triplete
     */
    public void Guardar(String triplete, int posicion) {
        int clave = Hasheo(triplete);
        if(this.Tabla[clave]==null){
            NodoHash nodo = new NodoHash(triplete, posicion);
            this.Tabla[clave] = nodo;
        } else{
            if(!this.Tabla[clave].getCadena().equals(triplete)) {
                registrarColision(clave, this.Tabla[clave].getCadena(), triplete);
            }
            GuardarHit(triplete, posicion, clave);
        }
    }
    
    /**
     * Maneja la inserción cuando ocurre una colisión (método auxiliar).
     * @param triplete Cadena a almacenar
     * @param posicion Posición asociada
     * @param clave Índice hash calculado
     */
    private void GuardarHit(String triplete, int posicion, int clave) {
        NodoHash current = this.Tabla[clave];
        NodoHash aux;
        do {
            if(current.getCadena().equals(triplete)){
                current.Repetido(posicion);
                return;
            }
            aux = current;
            current = current.getpNext();
        } while (current!=null);
        aux.setpNext(new NodoHash(triplete, posicion));
    }
    
    /**
     * Busca un triplete en la tabla hash.
     * @param triplete Cadena a buscar
     * @return NodoHash que contiene el triplete, o null si no se encuentra
     */
    public NodoHash Buscar(String triplete) {
        int clave = Hasheo(triplete);
        NodoHash nodo = this.Tabla[clave];
        while(nodo!=null){
            if(triplete.equals(nodo.getCadena())){
                return nodo;
            }
            nodo = nodo.getpNext();
        }
        return nodo;
    }
    
    /**
     * Calcula el valor hash para un triplete.
     * @param triplete Cadena a hashear
     * @return Índice en la tabla hash
     */
    private int Hasheo(String triplete) {
        int valor = abs(triplete.hashCode());
        return valor % size;
    }
    
    /**
     * Registra internamente una colisión detectada.
     * @param indice Índice donde ocurrió la colisión
     * @param existente Valor previamente almacenado
     * @param nuevo Valor que causó la colisión
     */
    private void registrarColision(int indice, String existente, String nuevo) {
        totalColisiones++;
        
        String colision = String.format("Colisión en índice %d: '%s' con '%s'", 
                                      indice, existente, nuevo);
        listaColisiones.add(colision);
        
        if (!registroColisiones.containsKey(indice)) {
            registroColisiones.put(indice, new ArrayList<>());
        }
        registroColisiones.get(indice).add(existente + " <> " + nuevo);
    }
    
    /**
     * Genera un reporte detallado de todas las colisiones registradas.
     * @return Lista formateada con el reporte de colisiones
     */
    public List<String> getReporteColisiones() {
        List<String> reporte = new ArrayList<>();
        
        reporte.add("=== REPORTE DE COLISIONES ===");
        reporte.add("Total de colisiones: " + totalColisiones);
        reporte.add("");
        
        if (totalColisiones > 0) {
            reporte.add("Detalle por índices:");
            for (Map.Entry<Integer, List<String>> entry : registroColisiones.entrySet()) {
                reporte.add("Índice " + entry.getKey() + ":");
                for (String colision : entry.getValue()) {
                    reporte.add("  • " + colision);
                }
            }
            
            reporte.add("");
            reporte.add("Listado cronológico:");
            for (String colision : listaColisiones) {
                reporte.add(colision);
            }
        } else {
            reporte.add("No se registraron colisiones en la tabla hash.");
        }
        
        return reporte;
    }
    
    /**
     * Obtiene el número total de colisiones registradas.
     * @return Contador total de colisiones
     */
    public int getTotalColisiones() {
        return totalColisiones;
    }
    
    /**
     * Obtiene el mapa detallado de colisiones organizado por índices.
     * @return Mapa donde la clave es el índice y el valor es la lista de colisiones
     */
    public Map<Integer, List<String>> getMapaColisiones() {
        return registroColisiones;
    }
}