/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *  Clase que contiene las primitivas de una lista simple pero sirve para guardar las colisiones.. 
 * @author alexandraloynaz
 */
public class ListaColisiones {
    private NodoColision pFirst;
    private int cont;
/**
 * Constructor que inicializa este lista
 */
    public ListaColisiones() {
        this.pFirst = null;
        this.cont = 0;
    }
/**
 * Verifica si la lista esta vacia
 * @return verdadero si esta vacia, falso si no se encuntra vacía
 */
    public boolean esVacio() {
        return getpFirst() == null;
    }
    /**
     * Inserta una colisión al final de la lista.
     * @param indice el indice de la HashTable donde ocurre la colision
     * @param existente la cadena que ya estaba almacenada
     * @param nuevo la cadena que causó la colisión al tratar de insertarse
     */
    public void insertarFinal(int indice, String existente, String nuevo) {
        NodoColision nuevoNodo = new NodoColision(indice, existente, nuevo);
        if (esVacio()) {
            setpFirst(nuevoNodo);
        } else {
            NodoColision aux = getpFirst();
            while (aux.pNext != null) {
                aux = aux.pNext;
            }
            aux.pNext = nuevoNodo;
        }
        cont++;
    }

    /**
     * Vacía la lista.
     */
    public void vaciar() {
        setpFirst(null);
        setCont(0);
    }

    /**
     * Imprime todas las colisiones en la lista.
     */
    public void imprimir() {
        if (esVacio()) {
            System.out.println("No se registraron colisiones.");
            return;
        }
        NodoColision aux = getpFirst();
        while (aux != null) {
            System.out.printf("Colisión en índice %d: '%s' con '%s'%n", aux.indice, aux.existente, aux.nuevo);
            aux = aux.pNext;
        }
    }

    /**
     * Devuelve la cantidad de colisiones registradas.
     */
    public int getCont() {
        return cont;
    }

    /**
     * Obtiene el primer nodo de la lista
     * @return el primer nodo de la lista
     */
    public NodoColision getpFirst() {
        return pFirst;
    }

    /**
     * Establece el primer nodo de la lista
     * @param pFirst el nodo que se convertira en el primero 
     */
    public void setpFirst(NodoColision pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * Establece el contador 
     * @param cont el valor del contador uqe se estableció,
     */
    public void setCont(int cont) {
        this.cont = cont;
    }
    
}
