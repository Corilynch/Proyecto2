/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author corinalynch
 */
public class ArbolBinario {
    private NodoArbol Root;

    /**
     * @return the Root
     */
    public NodoArbol getRoot() {
        return Root;
    }

    /**
     * @param Root the Root to set
     */
    public void setRoot(NodoArbol Root) {
        this.Root = Root;
    }
    
    public NodoArbol Mayor(NodoArbol Hoja){
        if(Hoja==null){
            Hoja = this.Root;
        }
        if(Hoja.getRightTree()!=null){
            return Mayor(Hoja.getRightTree());
        } 
        return Hoja;
    }
    
    public NodoArbol Menor(NodoArbol Hoja){
        if(Hoja==null){
            Hoja = this.Root;
        }
        if(Hoja.getLeftTree()!=null){
            return Mayor(Hoja.getLeftTree());
        } 
        return Hoja;
    }
    
}
