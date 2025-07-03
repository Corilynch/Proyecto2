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
 *
 * @author corinalynch
 */
public class Hash {
    private NodoHash[] Tabla;
    private int size;
    
    // Nuevos campos para el reporte de colisiones
    private int totalColisiones;
    private Map<Integer, List<String>> registroColisiones;
    private List<String> listaColisiones;
    
    public Hash(){
        this.size = 10;
        this.Tabla = new NodoHash[size];
        this.totalColisiones = 0;
        this.registroColisiones = new HashMap<>();
        this.listaColisiones = new ArrayList<>();
    }
    
    // Métodos existentes (se mantienen exactamente igual)
    public void Guardar(String triplete, int posicion){
        int clave = Hasheo(triplete);
        if(this.Tabla[clave]==null){
            NodoHash nodo = new NodoHash(triplete, posicion);
            this.Tabla[clave] = nodo;
        } else{
            // Antes de guardar, verificamos si es colisión real
            if(!this.Tabla[clave].getCadena().equals(triplete)) {
                registrarColision(clave, this.Tabla[clave].getCadena(), triplete);
            }
            GuardarHit(triplete, posicion, clave);
        }
    }
    
    private void GuardarHit(String triplete, int posicion, int clave){
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
    
    public NodoHash Buscar(String triplete){
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
    
    private int Hasheo(String triplete){
        int valor = abs(triplete.hashCode());
        return valor % size;
    }
    
    // Nuevos métodos para el reporte de colisiones
    private void registrarColision(int indice, String existente, String nuevo) {
        totalColisiones++;
        
        // Registrar en lista simple
        String colision = String.format("Colisión en índice %d: '%s' con '%s'", 
                                      indice, existente, nuevo);
        listaColisiones.add(colision);
        
        // Registrar en mapa detallado
        if (!registroColisiones.containsKey(indice)) {
            registroColisiones.put(indice, new ArrayList<>());
        }
        registroColisiones.get(indice).add(existente + " <> " + nuevo);
    }
    
    /**
     * Genera un reporte detallado de colisiones
     * @return Lista de strings con el reporte formateado
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
     * @return Número total de colisiones registradas
     */
    public int getTotalColisiones() {
        return totalColisiones;
    }
    
    /**
     * @return Mapa de colisiones por índice
     */
    public Map<Integer, List<String>> getMapaColisiones() {
        return registroColisiones;
    }
}