/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bioinformatica;

/**
 * Clase que contiene las primitivas de una lista simple. 
 * @author alexandraloynaz
 */
public class ListaSimple {
    private NodoLSimple pFirst; 
    private int cont; 
/**
 * Constructor
 */
    public ListaSimple() {
        this.pFirst = null;
        this.cont = 0;
    }
    /**
     * Metodo para revisar si una lista esta vacía
     * @return verdadero si esta vacía, falso si ocurre el caso contrario
     */
    public boolean esVacio(){
        return pFirst == null;
    }
    /**
     * Elimina el ultimo elemento de una lista
     */
    public void eliminarUltimo(){
        if(pFirst== null){
            return;}
        if(pFirst.getpNext()== null){
            pFirst = null;
            return;
        }
        NodoLSimple aux = pFirst;
        while(aux.getpNext().getpNext()!= null){
            aux = aux.getpNext();
        }
        aux.setpNext(null);
    }
    /**
     * Inserta un nodo al inicio de la lista
     * @param dato el dato que va a contener el nodo que se esta agregando 
     */

    public void insertarInicio(String dato){
        NodoLSimple nuevo = new NodoLSimple(dato); 
        nuevo.setpNext(getpFirst());
        setpFirst(nuevo); 
        cont++; }
    
    
    
    /**
     * Inserta un nodo al final de la lista
     * @param dato el dato que va a contener el nodo que se esta agregando al final
     */
    public void insertarFinal(String dato){
        NodoLSimple  nuevo = new NodoLSimple(dato); 
        if (esVacio()){
            setpFirst(nuevo);
        
        }
        else{
            NodoLSimple aux = getpFirst(); 
            while(aux.getpNext()!= null){
                aux = aux.getpNext(); 
        }
            aux.setpNext(nuevo);            
        }
            cont ++;  
    }
    /**
     * Función para imprimir los datos de una lista. 
     */
    public void imprimir(){
    NodoLSimple aux = pFirst; 
    String palabra = "";
    while (aux!= null){
        palabra += aux.getDatos();
        aux=aux.getpNext();}
        System.out.println(palabra);
    }
    /**
     * Busca el último nodo de la lista
     * @return el último nodo de la lista, o null si es vacía
     */
    public NodoLSimple buscarUltimo(){
        NodoLSimple  aux = pFirst; 
        if(pFirst == null){
            return null;}
        else{
            while(aux.getpNext()!= null){
            aux=aux.getpNext();
            }
            return aux;
        }
    }
    
    /**
     * Obtiene el primer nodo de la lista 
     * @return el primer nodo de la lista
     */
    public NodoLSimple getpFirst() {
        return pFirst;
    }

    /**
     * Establece el primer nodo de la lista 
     * @param pFirst el nodo que se va a establecer como primero
     */
    public void setpFirst(NodoLSimple pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * Obtiene el contador de nodos
     * @return la cantidad de nodos en esa lista
     */
    public int getCont() {
        return cont;
    }

     /**
     * Establece el contador de nodos 
     * @param cont el valor a establecer 
     */
    public void setCont(int cont) {
        this.cont = cont;
    }
    
    
}
