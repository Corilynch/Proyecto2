/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesamiento;

import Estructuras.Hash;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;

public class ProcesadorADN {
    
  /**
 * Clase para procesar archivos de secuencias de ADN y extraer tripletes
 */
public class ADNProcessor {

    /**
     * Carga un archivo de texto con la secuencia de ADN mediante un diálogo de selección de archivos.
     * Permite al usuario seleccionar un archivo que contiene la secuencia de ADN a procesar.
     * 
     * @return Tabla hash con todos los tripletes encontrados y sus posiciones,
     *         o {@code null} si el usuario cancela la operación
     * @see Hash
     * @example 
     * Hash tablaADN = cargarArchivoADN();
     * if (tablaADN != null) {
     *     // Procesar la tabla hash
     * }
     */
    public Hash cargarArchivoADN() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            return procesarArchivo(archivo);
        }
        return null;
    }
    
    /**
     * Procesa el archivo de ADN línea por línea y extrae los tripletes válidos.
     * Método interno que lee el archivo y construye la tabla hash.
     * 
     * @param archivo Archivo de texto con la secuencia de ADN
     * @return Tabla hash con los tripletes encontrados
     * @throws RuntimeException Si ocurre algún error durante la lectura del archivo
     * @see #procesarLinea(String, Hash)
     */
    private Hash procesarArchivo(File archivo) {
        Hash tabla = new Hash();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                procesarLinea(linea, tabla);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al procesar el archivo de ADN", e);
        }
        return tabla;
    }
    
    /**
     * Procesa una línea de texto de ADN, extrayendo todos los tripletes válidos.
     * Un triplete válido debe:
     * - Tener exactamente 3 caracteres
     * - Contener solo bases nitrogenadas válidas (A, T, C, G)
     * - No contener espacios ni caracteres especiales
     * 
     * @param linea Línea de texto del archivo de ADN
     * @param tabla Tabla hash donde se almacenarán los tripletes
     * @see Hash#Guardar(String, int)
     * @implNote Las posiciones se calculan desde 0 para cada línea
     */
    private void procesarLinea(String linea, Hash tabla) {
        // Eliminar espacios y convertir a mayúsculas
        String secuencia = linea.replaceAll("\\s+", "").toUpperCase();
        
        // Procesar la secuencia en tripletes
        for (int i = 0; i <= secuencia.length() - 3; i++) {
            String triplete = secuencia.substring(i, i + 3);
            // Verificar que solo contenga A, T, C, G
            if (triplete.matches("[ATCG]+")) {
                tabla.Guardar(triplete, i);
            }
        }
    }
}

}
