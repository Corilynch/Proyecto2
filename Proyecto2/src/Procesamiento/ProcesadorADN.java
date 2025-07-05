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
import javax.swing.JOptionPane;

/**
 * Clase para procesar archivos de secuencias de ADN y extraer tripletes con validaciones
 */
public class ProcesadorADN {
    
    /**
     * Carga un archivo de texto con la secuencia de ADN mediante un diálogo de selección de archivos.
     * 
     * @return Tabla hash con todos los tripletes encontrados y sus posiciones,
     *         o null si el usuario cancela la operación o hay errores
     */
    public Hash cargarArchivoADN() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar archivo de secuencia de ADN");
        
        try {
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File archivo = fileChooser.getSelectedFile();
                return procesarArchivo(archivo);
            }
        } catch (Exception e) {
            mostrarError("Error al cargar archivo", e.getMessage());
        }
        return null;
    }
    
    /**
     * Procesa el archivo de ADN línea por línea con validaciones
     * 
     * @param archivo Archivo de texto con la secuencia de ADN
     * @return Tabla hash con los tripletes encontrados
     * @throws IllegalArgumentException Si el archivo no cumple con los requisitos
     */
    public Hash procesarArchivo(File archivo) throws IllegalArgumentException {
        validarArchivo(archivo);
        Hash tabla = new Hash();
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int numLinea = 1;
            boolean tieneContenidoValido = false;
            
            while ((linea = br.readLine()) != null) {
                try {
                    procesarLinea(linea, tabla);
                    tieneContenidoValido = true;
                } catch (IllegalArgumentException e) {
                    System.err.println("Error en línea " + numLinea + ": " + e.getMessage());
                    // Continuar procesando otras líneas
                }
                numLinea++;
            }
            
            if (!tieneContenidoValido) {
                throw new IllegalArgumentException("El archivo no contiene secuencias de ADN válidas");
            }
            
            if (tabla.getTotalColisiones() > 0) {
                System.out.println("Advertencia: Se detectaron " + tabla.getTotalColisiones() + " colisiones");
            }
            
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al leer el archivo: " + e.getMessage());
        }
        
        return tabla;
    }
    
    /**
     * Valida el archivo antes de procesarlo
     */
    private void validarArchivo(File archivo) throws IllegalArgumentException {
        if (archivo == null) {
            throw new IllegalArgumentException("Archivo no seleccionado");
        }
        
        if (!archivo.exists()) {
            throw new IllegalArgumentException("El archivo no existe");
        }
        
        if (archivo.length() == 0) {
            throw new IllegalArgumentException("El archivo está vacío");
        }
        
        if (!archivo.getName().toLowerCase().endsWith(".txt")) {
            throw new IllegalArgumentException("El archivo debe tener extensión .txt");
        }
    }
    
    /**
     * Procesa una línea de texto de ADN con validaciones estrictas
     */
    private void procesarLinea(String linea, Hash tabla) throws IllegalArgumentException {
        // Validación básica de línea
        if (linea == null || linea.trim().isEmpty()) {
            throw new IllegalArgumentException("Línea vacía ignorada");
        }
        
        // Normalización: eliminar espacios y convertir a mayúsculas
        String secuencia = linea.replaceAll("\\s+", "").toUpperCase();
        
        // Validación de caracteres permitidos
        if (!secuencia.matches("^[ATCG]+$")) {
            throw new IllegalArgumentException(
                "Secuencia contiene caracteres inválidos. Solo se permiten A, T, C, G."
            );
        }
        
        // Validación de longitud mínima
        if (secuencia.length() < 3) {
            throw new IllegalArgumentException(
                "Secuencia demasiado corta (" + secuencia.length() + 
                " caracteres). Se requieren al menos 3 caracteres para formar un triplete."
            );
        }
        
        // Procesar todos los tripletes válidos
        for (int i = 0; i <= secuencia.length() - 3; i++) {
            String triplete = secuencia.substring(i, i + 3);
            tabla.Guardar(triplete, i); // Posición relativa a la línea
        }
    }
    
    /**
     * Muestra un mensaje de error al usuario
     */
    private void mostrarError(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(
            null,
            mensaje,
            titulo,
            JOptionPane.ERROR_MESSAGE
        );
    }
    
    /**
     * Método alternativo para procesar directamente una cadena de ADN (útil para pruebas)
     */
    public Hash procesarCadenaADN(String cadenaADN) throws IllegalArgumentException {
        Hash tabla = new Hash();
        procesarLinea(cadenaADN, tabla);
        return tabla;
    }
}