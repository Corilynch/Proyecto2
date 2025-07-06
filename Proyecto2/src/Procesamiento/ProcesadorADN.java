/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesamiento;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import Estructuras.Hash;

/**
 * Procesa archivos con secuencias de ADN y carga los datos en estructuras.
 */
public class ProcesadorADN {
    /**
     * Procesa un archivo y construye la tabla hash.
     * @param archivo Archivo de texto con secuencia de ADN
     * @return Tabla hash con los tripletes encontrados
     * @throws Exception Si hay error al leer el archivo
     */
    public Hash procesarArchivo(File archivo) throws Exception {
        Hash tabla = new Hash();
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;
        
        while ((linea = br.readLine()) != null) {
            procesarLinea(linea, tabla);
        }
        
        br.close();
        return tabla;
    }

    /**
     * Procesa una línea de texto, extrae tripletes válidos y los guarda.
     * @param linea Línea de texto del archivo
     * @param tabla Tabla hash donde almacenar los tripletes
     */
    private void procesarLinea(String linea, Hash tabla) {
        String secuencia = linea.replaceAll("\\s+", "").toUpperCase();
        
        for (int i = 0; i <= secuencia.length() - 3; i++) {
            String triplete = secuencia.substring(i, i + 3);
            if (esTripleteValido(triplete)) {
                tabla.guardar(triplete, i);
            }
        }
    }

    /**
     * Valida que un triplete contenga solo caracteres A, T, C, G.
     * @param triplete Cadena a validar
     * @return true si es válido, false si no
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
}