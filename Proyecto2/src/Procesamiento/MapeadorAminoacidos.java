/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesamiento;

import Estructuras.Hash;
import Estructuras.NodoHash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Clase para mapear tripletes de ADN a aminoácidos y generar reportes detallados.
 * Incluye funcionalidades para obtener información sobre aminoácidos, codones de inicio/parada,
 * y genera reportes completos organizados por frecuencia y tipo de aminoácido.
 */
public class MapeadorAminoacidos {
    private static final Map<String, String> codonToAminoacido = new HashMap<>();
    private static final Map<String, String> codonToAbrev3 = new HashMap<>();
    private static final Map<String, String> codonToAbrev1 = new HashMap<>();
    private static final Map<String, String> aminoacidoToTipo = new HashMap<>();

    static {
        inicializarMapeoCodones();
        inicializarTiposAminoacidos();
    }

    private static void inicializarMapeoCodones() {
        // Primera base U (T en ADN)
        agregarCodon("TTT", "Fenilalanina", "Phe", "F");
        agregarCodon("TTC", "Fenilalanina", "Phe", "F");
        agregarCodon("TTA", "Leucina", "Leu", "L");
        agregarCodon("TTG", "Leucina", "Leu", "L");
        
        agregarCodon("TCT", "Serina", "Ser", "S");
        agregarCodon("TCC", "Serina", "Ser", "S");
        agregarCodon("TCA", "Serina", "Ser", "S");
        agregarCodon("TCG", "Serina", "Ser", "S");
        
        agregarCodon("TAT", "Tirosina", "Tyr", "Y");
        agregarCodon("TAC", "Tirosina", "Tyr", "Y");
        agregarCodon("TAA", "STOP (Ocre)", "STOP", "-");
        agregarCodon("TAG", "STOP (Ámbar)", "STOP", "-");
        
        agregarCodon("TGT", "Cisteína", "Cys", "C");
        agregarCodon("TGC", "Cisteína", "Cys", "C");
        agregarCodon("TGA", "STOP (Ópalo)", "STOP", "-");
        agregarCodon("TGG", "Triptófano", "Trp", "W");

        // Primera base C
        agregarCodon("CTT", "Leucina", "Leu", "L");
        agregarCodon("CTC", "Leucina", "Leu", "L");
        agregarCodon("CTA", "Leucina", "Leu", "L");
        agregarCodon("CTG", "Leucina", "Leu", "L");
        
        agregarCodon("CCT", "Prolina", "Pro", "P");
        agregarCodon("CCC", "Prolina", "Pro", "P");
        agregarCodon("CCA", "Prolina", "Pro", "P");
        agregarCodon("CCG", "Prolina", "Pro", "P");
        
        agregarCodon("CAT", "Histidina", "His", "H");
        agregarCodon("CAC", "Histidina", "His", "H");
        agregarCodon("CAA", "Glutamina", "Gln", "Q");
        agregarCodon("CAG", "Glutamina", "Gln", "Q");
        
        agregarCodon("CGT", "Arginina", "Arg", "R");
        agregarCodon("CGC", "Arginina", "Arg", "R");
        agregarCodon("CGA", "Arginina", "Arg", "R");
        agregarCodon("CGG", "Arginina", "Arg", "R");

        // Primera base A
        agregarCodon("ATT", "Isoleucina", "Ile", "I");
        agregarCodon("ATC", "Isoleucina", "Ile", "I");
        agregarCodon("ATA", "Isoleucina", "Ile", "I");
        agregarCodon("ATG", "Metionina (Inicio)", "Met", "M");
        
        agregarCodon("ACT", "Treonina", "Thr", "T");
        agregarCodon("ACC", "Treonina", "Thr", "T");
        agregarCodon("ACA", "Treonina", "Thr", "T");
        agregarCodon("ACG", "Treonina", "Thr", "T");
        
        agregarCodon("AAT", "Asparagina", "Asn", "N");
        agregarCodon("AAC", "Asparagina", "Asn", "N");
        agregarCodon("AAA", "Lisina", "Lys", "K");
        agregarCodon("AAG", "Lisina", "Lys", "K");
        
        agregarCodon("AGT", "Serina", "Ser", "S");
        agregarCodon("AGC", "Serina", "Ser", "S");
        agregarCodon("AGA", "Arginina", "Arg", "R");
        agregarCodon("AGG", "Arginina", "Arg", "R");

        // Primera base G
        agregarCodon("GTT", "Valina", "Val", "V");
        agregarCodon("GTC", "Valina", "Val", "V");
        agregarCodon("GTA", "Valina", "Val", "V");
        agregarCodon("GTG", "Valina", "Val", "V");
        
        agregarCodon("GCT", "Alanina", "Ala", "A");
        agregarCodon("GCC", "Alanina", "Ala", "A");
        agregarCodon("GCA", "Alanina", "Ala", "A");
        agregarCodon("GCG", "Alanina", "Ala", "A");
        
        agregarCodon("GAT", "Ácido Aspártico", "Asp", "D");
        agregarCodon("GAC", "Ácido Aspártico", "Asp", "D");
        agregarCodon("GAA", "Ácido Glutámico", "Glu", "E");
        agregarCodon("GAG", "Ácido Glutámico", "Glu", "E");
        
        agregarCodon("GGT", "Glicina", "Gly", "G");
        agregarCodon("GGC", "Glicina", "Gly", "G");
        agregarCodon("GGA", "Glicina", "Gly", "G");
        agregarCodon("GGG", "Glicina", "Gly", "G");
    }

    private static void inicializarTiposAminoacidos() {
        // Aminoácidos no polares (hidrofóbicos)
        aminoacidoToTipo.put("Fenilalanina", "No polar");
        aminoacidoToTipo.put("Leucina", "No polar");
        aminoacidoToTipo.put("Isoleucina", "No polar");
        aminoacidoToTipo.put("Metionina (Inicio)", "No polar");
        aminoacidoToTipo.put("Valina", "No polar");
        aminoacidoToTipo.put("Prolina", "No polar");
        aminoacidoToTipo.put("Triptófano", "No polar");
        aminoacidoToTipo.put("Alanina", "No polar");
        aminoacidoToTipo.put("Glicina", "No polar");
        
        // Aminoácidos polares (neutros)
        aminoacidoToTipo.put("Serina", "Polar");
        aminoacidoToTipo.put("Treonina", "Polar");
        aminoacidoToTipo.put("Cisteína", "Polar");
        aminoacidoToTipo.put("Tirosina", "Polar");
        aminoacidoToTipo.put("Asparagina", "Polar");
        aminoacidoToTipo.put("Glutamina", "Polar");
        
        // Aminoácidos con carga positiva
        aminoacidoToTipo.put("Lisina", "Carga positiva");
        aminoacidoToTipo.put("Arginina", "Carga positiva");
        aminoacidoToTipo.put("Histidina", "Carga positiva");
        
        // Aminoácidos con carga negativa
        aminoacidoToTipo.put("Ácido Aspártico", "Carga negativa");
        aminoacidoToTipo.put("Ácido Glutámico", "Carga negativa");
        
        // Codones de parada
        aminoacidoToTipo.put("STOP (Ocre)", "STOP");
        aminoacidoToTipo.put("STOP (Ámbar)", "STOP");
        aminoacidoToTipo.put("STOP (Ópalo)", "STOP");
    }

    private static void agregarCodon(String codon, String aminoacido, String abrev3, String abrev1) {
        codonToAminoacido.put(codon, aminoacido);
        codonToAbrev3.put(codon, abrev3);
        codonToAbrev1.put(codon, abrev1);
    }

    // Métodos básicos de consulta (se mantienen igual)
    public static String obtenerAminoacido(String tripleteADN) {
        return codonToAminoacido.getOrDefault(tripleteADN, "Triplete no válido");
    }

    public static String obtenerAbreviatura3Letras(String tripleteADN) {
        return codonToAbrev3.getOrDefault(tripleteADN, "Inv");
    }

    public static String obtenerAbreviatura1Letra(String tripleteADN) {
        return codonToAbrev1.getOrDefault(tripleteADN, "?");
    }

    public static String obtenerTipoAminoacido(String aminoacido) {
        return aminoacidoToTipo.getOrDefault(aminoacido, "Desconocido");
    }

    public static boolean esCodonInicio(String triplete) {
        return "ATG".equals(triplete);
    }

    public static boolean esCodonParada(String triplete) {
        return codonToAminoacido.getOrDefault(triplete, "").startsWith("STOP");
    }

    // Métodos de reporte corregidos

    /**
     * Genera un reporte completo de aminoácidos con estadísticas detalladas
     * @param tablaHash Tabla hash con los tripletes y sus frecuencias
     * @return Lista de strings formateados para mostrar el reporte
     */
    public static List<String> generarReporteCompletoAminoacidos(Hash tablaHash) {
        List<String> reporte = new ArrayList<>();
        
        // Primero generamos el mapa de tres niveles
        Map<String, Map<String, Map<String, Integer>>> datosCompletos = generarDatosCompletosPorTipo(tablaHash);
        
        // Luego procesamos para el reporte
        Map<String, Integer> frecuenciasTotales = new HashMap<>();
        Map<String, Integer> conteoTripletes = new HashMap<>();
        
        // Calcular frecuencias totales por aminoácido
        for (Map.Entry<String, Map<String, Map<String, Integer>>> entryTipo : datosCompletos.entrySet()) {
            for (Map.Entry<String, Map<String, Integer>> entryAmino : entryTipo.getValue().entrySet()) {
                String aminoacido = entryAmino.getKey();
                int frecuenciaTotal = entryAmino.getValue().values().stream().mapToInt(Integer::intValue).sum();
                frecuenciasTotales.put(aminoacido, frecuenciaTotal);
                conteoTripletes.put(aminoacido, entryAmino.getValue().size());
            }
        }
        
        // Ordenar aminoácidos por frecuencia total (descendente)
        List<Map.Entry<String, Integer>> aminoacidosOrdenados = frecuenciasTotales.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .collect(Collectors.toList());
        
        // Generar encabezado del reporte
        reporte.add("═".repeat(80));
        reporte.add(String.format("%-25s %-12s %-15s %-10s %-15s %s", 
            "AMINOÁCIDO", "FRECUENCIA", "TRIPLETES", "TIPO", "ABREV. 3", "ABREV. 1"));
        reporte.add("-".repeat(80));
        
        // Agregar datos de cada aminoácido al reporte
        for (Map.Entry<String, Integer> entry : aminoacidosOrdenados) {
            String aminoacido = entry.getKey();
            int frecuenciaTotal = entry.getValue();
            int numTripletes = conteoTripletes.get(aminoacido);
            String tipo = obtenerTipoAminoacido(aminoacido);
            
            // Obtener abreviatura (usamos el primer triplete como referencia)
            String tipoAmino = datosCompletos.keySet().stream()
                .filter(t -> datosCompletos.get(t).containsKey(aminoacido))
                .findFirst()
                .orElse("");
            
            Map<String, Integer> tripletes = datosCompletos.get(tipoAmino).get(aminoacido);
            String primerTriplete = tripletes.keySet().iterator().next();
            String abrev3 = obtenerAbreviatura3Letras(primerTriplete);
            String abrev1 = obtenerAbreviatura1Letra(primerTriplete);
            
            // Línea principal del aminoácido
            reporte.add(String.format("%-25s %-12d %-15d %-10s %-15s %s", 
                aminoacido, frecuenciaTotal, numTripletes, tipo, abrev3, abrev1));
            
            // Detalle de tripletes para este aminoácido
            List<Map.Entry<String, Integer>> tripletesOrdenados = tripletes.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());
            
            for (Map.Entry<String, Integer> tripleteEntry : tripletesOrdenados) {
                reporte.add(String.format("   ├─ %s: %d ocurrencias (%.1f%%)", 
                    tripleteEntry.getKey(), 
                    tripleteEntry.getValue(),
                    (tripleteEntry.getValue() * 100.0 / frecuenciaTotal)));
            }
            
            reporte.add("   └─" + "─".repeat(76));
        }
        
        // Estadísticas generales y sección especial (se mantienen igual)
        // ... (resto del método igual que antes)
        
        return reporte;
    }

    /**
     * Genera un mapa completo con la estructura: Tipo -> Aminoácido -> Triplete -> Frecuencia
     * @param tablaHash Tabla hash con los datos de ADN
     * @return Mapa con cuatro niveles de anidamiento
     */
    private static Map<String, Map<String, Map<String, Integer>>> generarDatosCompletosPorTipo(Hash tablaHash) {
        Map<String, Map<String, Map<String, Integer>>> datosCompletos = new HashMap<>();
        
        for (NodoHash nodo : tablaHash.getTabla()) {
            NodoHash current = nodo;
            while (current != null) {
                String triplete = current.getCadena();
                String aminoacido = obtenerAminoacido(triplete);
                String tipo = obtenerTipoAminoacido(aminoacido);
                
                datosCompletos.putIfAbsent(tipo, new HashMap<>());
                datosCompletos.get(tipo).putIfAbsent(aminoacido, new HashMap<>());
                datosCompletos.get(tipo).get(aminoacido).put(triplete, current.getFrecuencia());
                
                current = current.getpNext();
            }
        }
        
        return datosCompletos;
    }

    /**
     * Genera compatibilidad con código existente
     * @param tablaHash Tabla hash con los datos
     * @return Mapa con estructura: Aminoácido -> (Triplete -> Frecuencia)
     */
    public static Map<String, Map<String, Integer>> generarReportePorAminoacido(Hash tablaHash) {
        Map<String, Map<String, Integer>> reporte = new HashMap<>();
        
        for (NodoHash nodo : tablaHash.getTabla()) {
            NodoHash current = nodo;
            while (current != null) {
                String triplete = current.getCadena();
                String aminoacido = obtenerAminoacido(triplete);
                
                reporte.putIfAbsent(aminoacido, new HashMap<>());
                reporte.get(aminoacido).put(triplete, current.getFrecuencia());
                
                current = current.getpNext();
            }
        }
        
        return reporte;
    }
}