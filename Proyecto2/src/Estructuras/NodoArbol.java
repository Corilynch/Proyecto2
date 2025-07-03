/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author corinalynch
 */
public class NodoArbol {
    private NodoArbol LeftTree;
    private NodoArbol RightTree;
    private NodoHash NodoTriplete;

 /**
 * @return El subárbol izquierdo (puede ser {@code null})
 */
    public NodoArbol getLeftTree() {
        return LeftTree;
    }

   /**
 * Establece el subárbol izquierdo de este nodo.
 * @param LeftTree El nodo hijo izquierdo (puede ser {@code null})
 */
    public void setLeftTree(NodoArbol LeftTree) {
        this.LeftTree = LeftTree;
    }

   /**
 * Obtiene el subárbol derecho del nodo actual.
 * 
 * @return El nodo derecho de tipo {@link NodoArbol}, o {@code null} si no existe subárbol derecho.
 */
    public NodoArbol getRightTree() {
        return RightTree;
    }

   /**
 * Establece el subárbol derecho del nodo actual.
 * 
 * @param RightTree El nodo que se asignará como subárbol derecho. 
 *                  Puede ser {@code null} para indicar que no hay subárbol derecho.
 */
    public void setRightTree(NodoArbol RightTree) {
        this.RightTree = RightTree;
    }

   /**
 * Obtiene el nodo triplete asociado a este objeto.
 * 
 * @return El nodo de tipo {@link NodoHash} almacenado, o {@code null} si no hay ningún nodo asignado.
 */
    public NodoHash getNodo() {
        return NodoTriplete;
    }
    
    /**
 * Establece el nodo triplete asociado a este objeto.
 * 
 * @param nodo El nodo de tipo {@link NodoHash} que se asignará como nodo triplete.
 *                            Puede ser {@code null} si se desea eliminar la referencia actual.
 */
    
     public void setNodoTriplete(NodoHash nodo) {
        this.NodoTriplete = nodo;
    }
}
