/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leerTXT;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author alexandraloynaz
 */
public class LeerTXT {
    private File archivo;
    
    
    public boolean cargarArchivo(){
        JFileChooser selcArchivo = new JFileChooser();
        selcArchivo.setDialogTitle("Seleccionar archivo de texto");
        selcArchivo.setFileFilter(new FileNameExtensionFilter("Archivos TXT","txt"));
        int seleccion = selcArchivo.showOpenDialog(null);
     
        if (seleccion != JFileChooser.APPROVE_OPTION){
            JOptionPane.showMessageDialog(null, "El archivo seleccionado no esta en formato txt o no funciona", "error", JOptionPane.ERROR_MESSAGE);
            return false; 
        }
        
            archivo = selcArchivo.getSelectedFile();
        return revisarArchivo(archivo);
    
    }
    
    
}
