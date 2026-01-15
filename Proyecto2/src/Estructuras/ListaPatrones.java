/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;


/**
 * Clase para manejar la lista de patrones ordenados por frecuencia
 * @author alexandraloynaz
 */
public class ListaPatrones {
    /**
     * Constructor que inicializa una ListaSimple llamada patrones.
     */
    private ListaSimple patrones;
    /**
     * Crear una nueva lista Simple llamada patrones para ir guardando todos lo que se encuntran
     */
    public ListaPatrones() {
        patrones = new ListaSimple();
    }
    
    /**
     * Carga los patrones desde la tabla hash
     * @param tabla Hash table con los patrones
     */
    public void cargarDesdeHash(Hash tabla) {
        patrones.vaciar();
        NodoHash [] tablaHash = tabla.getTabla();
        for (NodoHash nodo : tabla.getTabla()) {
            while (nodo != null) {
                patrones.insertarFinal(nodo);
                nodo = nodo.getpNext();
            }
        }
        ordenarPorFrecuencia();
    }
    
    /**
     * Ordena los patrones por frecuencia (de mayor a menor)
     * Ordenando utilizando una ListSimple
     */
    private void ordenarPorFrecuencia() {
        if(patrones.esVacio()){
            return;
        }
        boolean intercambio;
        do{
            intercambio = false;
            NodoLSimple actual = patrones.getpFirst();
            while(actual!= null && actual.getpNext()!= null){
            NodoLSimple siguiente = actual.getpNext();
                if (actual.getDatos().getFrecuencia() < siguiente.getDatos().getFrecuencia()) {
                    
                    NodoHash temp = actual.getDatos();
                    actual.setDatos(siguiente.getDatos());
                    siguiente.setDatos(temp);
                    intercambio = true;
                }
                actual = siguiente;
            }
        } while (intercambio);
    }
        

            
  
    /**
     * Obtiene un arreglo de patrones
     * @return Arreglo de los patrones ordenados
     */
    public NodoHash[] getPatrones() {
        NodoHash[] arreglo = new NodoHash[patrones.getCont()];
        NodoLSimple aux = patrones.getpFirst();
        int i = 0;
        while (aux != null) {
            arreglo[i++] = aux.getDatos();
            aux = aux.getpNext();
        }
        return arreglo;
    }
    
    /**
     * Busca un patrón específico
     * @param triplete Patrón a buscar
     * @return NodoHash con la información o null si no existe
     */
    public NodoHash buscarPatron(String triplete) {
        NodoLSimple aux = patrones.getpFirst();
        while (aux != null) {
            if (aux.getDatos().getCadena().equals(triplete)) {
                return aux.getDatos();
            }
            aux = aux.getpNext();
        }
        return null;
    }
    
    /**
     * Obtiene el valor mas frecuente
     * @return El patrón más frecuente
     */
    public NodoHash getMasFrecuente() {
        if (patrones.esVacio()) {
            return null;
        }   
        else {
        return patrones.getpFirst().getDatos();
    }
}

    
    /**
     * Obteine el valor menos frecuente
     * @return El patrón menos frecuente
     */
    public NodoHash getMenosFrecuente() {
        if (patrones.esVacio()) return null;

        NodoLSimple aux = patrones.getpFirst();
        while (aux.getpNext() != null) {
            aux = aux.getpNext();
        }
        return aux.getDatos();
    }
}
    