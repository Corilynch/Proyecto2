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
     * @return the LeftTree
     */
    public NodoArbol getLeftTree() {
        return LeftTree;
    }

    /**
     * @param LeftTree the LeftTree to set
     */
    public void setLeftTree(NodoArbol LeftTree) {
        this.LeftTree = LeftTree;
    }

    /**
     * @return the RightTree
     */
    public NodoArbol getRightTree() {
        return RightTree;
    }

    /**
     * @param RightTree the RightTree to set
     */
    public void setRightTree(NodoArbol RightTree) {
        this.RightTree = RightTree;
    }

    /**
     * @return the NodoTriplete
     */
    public NodoHash getNodo() {
        return NodoTriplete;
    }
    
     public void setNodoTriplete(NodoHash nodo) {
        this.NodoTriplete = nodo;
    }
}
