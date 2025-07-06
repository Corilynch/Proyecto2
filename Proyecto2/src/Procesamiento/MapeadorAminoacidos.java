/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesamiento;

import Estructuras.Hash;
import Estructuras.NodoHash;


/**
 * Clase para mapear tripletes de ADN a aminoácidos y generar reportes detallados.
 * Incluye funcionalidades para obtener información sobre aminoácidos, codones de inicio/parada,
 * y genera reportes por frecuencia y tipo de aminoácido.
 * @author alexandraloynaz
 */
public class MapeadorAminoacidos {
    private String[] codones = {
        "TTT", "TTC", "TTA", "TTG","TCT", "TCC", "TCA", "TCG","TAT", "TAC", "TAA", "TAG","TGT", "TGC", "TGA", "TGG",
        "CTT", "CTC", "CTA", "CTG","CCT", "CCC", "CCA", "CCG","CAT", "CAC", "CAA", "CAG","CGT", "CGC", "CGA", "CGG",
        "ATT", "ATC", "ATA", "ATG","ACT", "ACC", "ACA", "ACG", "AAT", "AAC", "AAA", "AAG","AGT", "AGC", "AGA", "AGG",
        "GTT", "GTC", "GTA", "GTG","GCT", "GCC", "GCA", "GCG","GAT", "GAC", "GAA", "GAG","GGT", "GGC", "GGA", "GGG"};

    /**
     * Matriz que asocia todos los cadenas de tres posibles con tpda si información.
     */
    private String[][] codonAminoacido = {
        {"TTT", "Fenilalanina", "Phe", "F"},
        {"TTC", "Fenilalanina", "Phe", "F"},
        {"TTA", "Leucina", "Leu", "L"},
        {"TTG", "Leucina", "Leu", "L"},
        {"TCT", "Serina", "Ser", "S"},
        {"TCC", "Serina", "Ser", "S"},
        {"TCA", "Serina", "Ser", "S"},
        {"TCG", "Serina", "Ser", "S"},
        {"TAT", "Tirosina", "Tyr", "Y"},
        {"TAC", "Tirosina", "Tyr", "Y"},
        {"TAA", "STOP", "STOP", "-"},
        {"TAG", "STOP", "STOP", "-"},
        {"TGT", "Cisteína", "Cys", "C"},
        {"TGC", "Cisteína", "Cys", "C"},
        {"TGA", "STOP", "STOP", "-"},
        {"TGG", "Triptófano", "Trp", "W"},
        {"CTT", "Leucina", "Leu", "L"},
        {"CTC", "Leucina", "Leu", "L"},
        {"CTA", "Leucina", "Leu", "L"},
        {"CTG", "Leucina", "Leu", "L"},
        {"CCT", "Prolina", "Pro", "P"},
        {"CCC", "Prolina", "Pro", "P"},
        {"CCA", "Prolina", "Pro", "P"},
        {"CCG", "Prolina", "Pro", "P"},
        {"CAT", "Histidina", "His", "H"},
        {"CAC", "Histidina", "His", "H"},
        {"CAA", "Glutamina", "Gln", "Q"},
        {"CAG", "Glutamina", "Gln", "Q"},
        {"CGT", "Arginina", "Arg", "R"},
        {"CGC", "Arginina", "Arg", "R"},
        {"CGA", "Arginina", "Arg", "R"},
        {"CGG", "Arginina", "Arg", "R"},
        {"ATT", "Isoleucina", "Ile", "I"},
        {"ATC", "Isoleucina", "Ile", "I"},
        {"ATA", "Isoleucina", "Ile", "I"},
        {"ATG", "Metionina", "Met", "M"},
        {"ACT", "Treonina", "Thr", "T"},
        {"ACC", "Treonina", "Thr", "T"},
        {"ACA", "Treonina", "Thr", "T"},
        {"ACG", "Treonina", "Thr", "T"},
        {"AAT", "Asparagina", "Asn", "N"},
        {"AAC", "Asparagina", "Asn", "N"},
        {"AAA", "Lisina", "Lys", "K"},
        {"AAG", "Lisina", "Lys", "K"},
        {"AGT", "Serina", "Ser", "S"},
        {"AGC", "Serina", "Ser", "S"},
        {"AGA", "Arginina", "Arg", "R"},
        {"AGG", "Arginina", "Arg", "R"},
        {"GTT", "Valina", "Val", "V"},
        {"GTC", "Valina", "Val", "V"},
        {"GTA", "Valina", "Val", "V"},
        {"GTG", "Valina", "Val", "V"},
        {"GCT", "Alanina", "Ala", "A"},
        {"GCC", "Alanina", "Ala", "A"},
        {"GCA", "Alanina", "Ala", "A"},
        {"GCG", "Alanina", "Ala", "A"},
        {"GAT", "Aspártico", "Asp", "D"},
        {"GAC", "Aspártico", "Asp", "D"},
        {"GAA", "Glutámico", "Glu", "E"},
        {"GAG", "Glutámico", "Glu", "E"},
        {"GGT", "Glicina", "Gly", "G"},
        {"GGC", "Glicina", "Gly", "G"},
        {"GGA", "Glicina", "Gly", "G"},
        {"GGG", "Glicina", "Gly", "G"}
        
    };
    /**
     * Funcion para obtener el aminoacido de una tripleta
     * @param tres la tripleta a la cual ADN la cual se desea conseguir si aminoacido
     * @return El aminoácido o no Valido si no existe
     */
    public String obtenerAminoacido(String tres) {
        for (int i = 0; i < codonAminoacido.length; i++) {
            if (codonAminoacido[i][0].equals(tres)) {
            return codonAminoacido[i][1];
        }
    }
    return "No válido";
    }
    
    /**
     * Funcion que devuelve la abrebiatura de un aminoácido.
     * @param tripleta la parte del ADN a la cual se desea buscar su abrebiatura
     * @return la abrebiatura de la tripleta o invalido si no existe.
     */
    public String abrebiatura3(String tripleta){
        for (int i = 0; i < codonAminoacido.length; i++) {
            if(codonAminoacido[i][0].equals(tripleta)){
                return codonAminoacido[i][2];}
        }
          return "Invalido";  
        }
    
    public String abrebiatura1(String tripleta){
        for (int i = 0; i < codonAminoacido.length; i++) {
            if(codonAminoacido[i][0].equals(tripleta)){ 
                return codonAminoacido[i][3];}
        }
          return "Invalido";  
        }
    /**
     * Verifica si estamos en la tripleta de inicio 
     * @param triplete la cadena a evaluar
     * @return Verdadero si la de inicio, falso en el caso opuesto.
     */
    public boolean esInicio(String triplete) {
        return "ATG".equals(triplete);
    }
    /**
     * Verifica si es una tripleta de parada
     * @param triplete la cadena a revisar 
     * @return Verdadero si es parada, falso si es lo contrario
     */
    public boolean esParada(String triplete) {
        return triplete.equals("TAA") || triplete.equals("TAG") || triplete.equals("TGA");
    }
    
  /**
   * Clase para generar un reporte de lo obtenido por el TXT
   * @param tabla 
   * @param lista 
   */
    public void generarReporte(Hash tabla, ListaSimpleReportes lista) {
        NodoHash[] tablaDatos = tabla.getTabla();
        String reporte = "===== REPORTE BÁSICO =====\nTriplete\tFrecuencia\tAminoácido\n";

        for (NodoHash nodo : tablaDatos) {
            while (nodo != null) {
                String amino = obtenerAminoacido(nodo.getCadena());
                reporte += nodo.getCadena() + "     " + nodo.getFrecuencia() + "    " + amino + "      ";
                nodo = nodo.getpNext();
            }
        }
        lista.insertarFinal(reporte);
    }
    

    /**
     * Funcion para encontrar que tipo de aminoácido es la cadena.
     * @param cadena la cadena que se va a evaluar
     * @return el tipo que se encontro.
     */
    public String obtenerTipo(String cadena){
        String amino = obtenerAminoacido(cadena);
        String[] noPolares = {"Fenilalanina", "Leucina", "Isoleucina", "Metionina", "Valina", "Prolina", "Triptófano", "Alanina", "Glicina"};
        String[] polares = {"Serina", "Treonina", "Cisteína", "Tirosina", "Asparagina", "Glutamina"};
        String[] cargaPositiva = {"Lisina", "Arginina", "Histidina"};
        String[] cargaNegativa = {"Aspártico", "Glutámico"};
        String[] stop = {"STOP"};

        for (int i = 0; i < noPolares.length; i++) {
            if (amino.equals(noPolares[i])) {
                return "No polar";
            }
        }
        for (int i = 0; i < polares.length; i++) {
            if (amino.equals(polares[i])) {
                return "Polar";
            }}
        
        for (int i = 0; i < cargaPositiva.length; i++) {
            if (amino.equals(cargaPositiva[i])) {
                return "Carga positiva";
            }
        }
        for (int i = 0; i < cargaNegativa.length; i++) {
            if (amino.equals(cargaNegativa[i])) {
                return "Carga negativa";
            }
        }

        for (int i = 0; i < stop.length; i++) {
            if (amino.equals(stop[i])) {
                return "STOP";
            }
        }

        return "Desconocido";
    }
    /**
     * Función que determina si no es Polar 
     * @param tripleta la cadena que se evalua
     * @return verdadero si no es polar, false en caso contrario 
     */
    public boolean esNoPolar(String tripleta) {
        return obtenerTipo(tripleta).equals("No polar");
    }
    /**
     * Función que determina si es Polar 
     * @param tripleta la cadena que se evalua
     * @return verdadero si no es polar, false en caso contrario 
     */
    public boolean esPolar(String tripleta) {
        return obtenerTipo(tripleta).equals("Polar");
    }
    /**
     * Función que determina si es carga positiva 
     * @param tripleta la cadena que se evalua
     * @return verdadero si no es carga positiva, false en caso contrario 
     */
    public boolean esCargaPositiva(String tripleta) {
        return obtenerTipo(tripleta).equals("Carga positiva");
    }
    /**
     * Función que determina si es carga positiva 
     * @param tripleta la cadena que se evalua
     * @return verdadero si no es carga negativa, false en caso contrario 
     */
    public boolean esCargaNegativa(String tripleta) {
        return obtenerTipo(tripleta).equals("Carga negativa");
    }
    /**
     * Función que determina si es stop
     * @param tripleta la cadena que se evalua
     * @return erdadero si es stop, false en caso contrario 
     */
    public boolean esStop(String tripleta) {
        return obtenerTipo(tripleta).equals("STOP");
    }

        }

    
    