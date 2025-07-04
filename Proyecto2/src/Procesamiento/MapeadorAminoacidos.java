/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesamiento;

import java.util.HashMap;
import java.util.Map;
import Estructuras.Hash;  
import Estructuras.NodoHash;

public class MapeadorAminoacidos {
    private static final Map<String, String> codonToAminoacido = new HashMap<>();
    private static final Map<String, String> codonToAbrev3 = new HashMap<>();
    private static final Map<String, String> codonToAbrev1 = new HashMap<>();

    static {
        // Inicialización de los mapas estáticos
        inicializarMapeoCodones();
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

    private static void agregarCodon(String codon, String aminoacido, String abrev3, String abrev1) {
        codonToAminoacido.put(codon, aminoacido);
        codonToAbrev3.put(codon, abrev3);
        codonToAbrev1.put(codon, abrev1);
    }

    /**
     * Obtiene el nombre completo del aminoácido para un triplete de ADN
     */
    public static String obtenerAminoacido(String tripleteADN) {
        return codonToAminoacido.getOrDefault(tripleteADN, "Triplete no válido");
    }

    /**
     * Obtiene la abreviatura de 3 letras del aminoácido
     */
    public static String obtenerAbreviatura3Letras(String tripleteADN) {
        return codonToAbrev3.getOrDefault(tripleteADN, "Inv");
    }

    /**
     * Obtiene la abreviatura de 1 letra del aminoácido
     */
    public static String obtenerAbreviatura1Letra(String tripleteADN) {
        return codonToAbrev1.getOrDefault(tripleteADN, "?");
    }

    /**
     * Genera un reporte completo de aminoácidos con sus tripletes
     */
    public static Map<String, Map<String, Integer>> generarReporteAminoacidos(Hash tablaHash) {
        Map<String, Map<String, Integer>> reporte = new HashMap<>();

        for (NodoHash nodo : tablaHash.getTabla()) {
            NodoHash current = nodo;
            while (current != null) {
                String triplete = current.getCadena();
                String aminoacido = obtenerAminoacido(triplete);
                
                if (!reporte.containsKey(aminoacido)) {
                    reporte.put(aminoacido, new HashMap<>());
                }
                
                reporte.get(aminoacido).put(triplete, current.getFrecuencia());
                
                current = current.getpNext();
            }
        }

        return reporte;
    }

    /**
     * Verifica si un triplete es un codón de inicio
     */
    public static boolean esCodonInicio(String triplete) {
        return "ATG".equals(triplete);
    }

    /**
     * Verifica si un triplete es un codón de parada
     */
    public static boolean esCodonParada(String triplete) {
        return codonToAminoacido.getOrDefault(triplete, "").startsWith("STOP");
    }
}