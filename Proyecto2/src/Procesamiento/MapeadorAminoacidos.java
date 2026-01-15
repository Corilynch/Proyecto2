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
            if(codonAminoacido[i][1].equals(tripleta)){
                return codonAminoacido[i][2];}
        }
          return "Invalido";  
        }
    
    public String abrebiatura1(String tripleta){
        for (int i = 0; i < codonAminoacido.length; i++) {
            if(codonAminoacido[i][1].equals(tripleta)){ 
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
    * Genera una lista con todos los Aminoácidos del hashTable
    * @param tabla la hashTable que desea desa evaluar
    * @param lista la lista a la cual se ira insertando cada nodo, guardadno la información.
    */ 
    public void generarListaAmino(Hash tabla, ListaAminoacidos lista){
        lista.vaciar();
        NodoHash[] tablaDatos = tabla.getTabla();
        for (int i = 0; i < tablaDatos.length; i++) {
            NodoHash nodo = tablaDatos[i];
        while (nodo != null) {
        String cadena = nodo.getCadena();
        int frecuencia = nodo.getFrecuencia();
        String tipo = obtenerTipo(cadena);
        lista.insertarFinal(cadena, frecuencia, tipo);
        nodo = nodo.getpNext();
            }
            
        }
    }
    
  /**
 * Genera un reporte con los aminoácidos y sus cadenas ordenados por frecuencia total. El numero máximo de cadenas es 4*12, ya que son 4 letras y 12 combinaciones con cada una al inicio
 * @param tabla La tabla hash procesada con los cadenas.
 * @return Una ListaSimpleReportes.
 */
public ListaSimpleReportes generarReporteAminoacidos(Hash tabla) {
    MapeadorAminoacidos mapeador = new MapeadorAminoacidos();
    ListaSimpleReportes reporte = new ListaSimpleReportes();
    
    
    String[] aminoacidos = new String[64];
    int[] frecuenciasTotales = new int[64];
    int count = 0;
    NodoHash[] tablaDatos = tabla.getTabla();
    for (int i = 0; i < tablaDatos.length; i++) {
        NodoHash nodo = tablaDatos[i];
        while (nodo != null) {
            String cadena = nodo.getCadena();
            int frecuencia = nodo.getFrecuencia();
            String aminoacido = mapeador.obtenerAminoacido(cadena);
            int posicion = -1;
            for (int j = 0; j < count; j++) {
                if (aminoacidos[j].equals(aminoacido)) {
                    posicion = j;
                    break;
                }
            }

            if (posicion == -1) {
                aminoacidos[count] = aminoacido;
                frecuenciasTotales[count] = frecuencia;
                count++;
            } else {
                frecuenciasTotales[posicion] += frecuencia;
            } nodo = nodo.getpNext();
        }
    }
    for (int i = 0; i < count - 1; i++) {
        for (int j = 0; j < count - i - 1; j++) {
            if (frecuenciasTotales[j] < frecuenciasTotales[j + 1]) {
                int temp = frecuenciasTotales[j];
                frecuenciasTotales[j] = frecuenciasTotales[j + 1];
                frecuenciasTotales[j + 1] = temp;

                String tempAmino = aminoacidos[j];
                aminoacidos[j] = aminoacidos[j + 1];
                aminoacidos[j + 1] = tempAmino;
            }
        }
    }


    for (int i = 0; i < count; i++) {
        String aminoacido = aminoacidos[i];
        int total = frecuenciasTotales[i];
        String tipo = mapeador.obtenerTipo(aminoacido);
        String abrev3 = mapeador.abrebiatura3(aminoacido);
        String abrev1 = mapeador.abrebiatura1(aminoacido);
        reporte.insertarFinal("-------------------------------------");
        reporte.insertarFinal("AMINOÁCIDO: " + aminoacido + "  " + abrev3 + " - " + abrev1 );
        reporte.insertarFinal("Tipo: " + tipo);
        reporte.insertarFinal("Total frecuencia: " + total);
        reporte.insertarFinal("Tripletes:");
        for (int j = 0; j < tablaDatos.length; j++) {
            NodoHash nodo = tablaDatos[j];
            while (nodo != null) {
                String triplete = nodo.getCadena();
                if (mapeador.obtenerAminoacido(triplete).equals(aminoacido)) {
                    reporte.insertarFinal("   " + triplete + " - " + nodo.getFrecuencia() + " ocurrencias");
                }
                nodo = nodo.getpNext();
            }
        }
                 reporte.insertarFinal("\n");

    }
    return reporte;
}

    

    /**
     * Funcion para encontrar que tipo de aminoácido es la cadena.
     * @param cadena la cadena que se va a evaluar
     * @return el tipo que se encontro.
     */
    public String obtenerTipo(String amino){
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

    
    