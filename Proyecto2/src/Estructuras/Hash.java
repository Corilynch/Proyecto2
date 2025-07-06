/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;


/**
 * Implementación  una tabla hash que maneja colisiones mediante encadenamiento (listas enlazadas).
 * Permite almacenar, buscar tripletas y registrar colisiones.
 * 
 * @author alexandraloynaz
 */
public class Hash {
  
    private NodoHash[] Tabla;
    private int size;
    private int totalColisiones;
    private ListaColisiones listaColisiones;
    /**
     * Constructor que inicializa una tabla hash con tamaño por defecto (503), se eligió este número porque es un primo grande que va a evitar mejor las colisiones.
     * Inicializa los contadores y la lista de colisiones vacía.
     */
    public Hash() {
        this.size = 503;
        this.Tabla = new NodoHash[size];
        this.totalColisiones = 0;
        this.listaColisiones = new ListaColisiones();
    }
/**
 * Calcula el índice hash para una cadena de 3 utilizando un número primo 31.
 * Este método multiplica el valor acumulado por 31 y suma el valor ASCII del carácter actual, asegurando que el resultado sea positivo para evitar índices negativos.
 * 
 * @param tripleta cadena que se desea utilizar
 * @return  índice válido dentro del arreglo de la tabla hash
 */
    private int hasheo(String tripleta){
        int hash = 0;
        int primo = 31;
        for (int i = 0; i < tripleta.length(); i++) {
            hash = primo * hash + tripleta.charAt(i);
            if(hash<0){
                hash = -hash;}
        }
        return hash % getSize();
    }
    
    /**
     * Inserta una pribleta en la HashTable con su posición asociada, si la posición calculada está vacía, inserta el nodo directamente.
     * Si hay colisión (misma posición pero distinto tripleta), registra la colisión y la maneja insertando en la lista enlazada.
     * @param tripleta cadena que se desea almacenar 
     * @param posicion posición donde aparece la tripleta
     */
    public void guardar(String tripleta, int posicion){
        int clave = hasheo(tripleta);
        if(this.getTabla()[clave]==null){
            NodoHash nodo = new NodoHash(tripleta,posicion);
            this.getTabla()[clave]= nodo;
        }
        else{
        if(!this.Tabla[clave].getCadena().equals(tripleta)){
            registrarColision(clave, this.getTabla()[clave].getCadena(), tripleta);
            }
            guardarHit(tripleta, posicion, clave);
        }
        
        }
    /**
     * Función que regresa el menos frecuente en String
     * @return la cadena menos frecuente.
     */
    public String MenosFrecuenteString() {
        NodoHash nodo = getMenosFrecuente();
        if (nodo == null) {
            return "No hay datos disponibles.";
        }
        return "Cadena: " + nodo.getCadena() + "\nFrecuencia: " + nodo.getFrecuencia() + "\nPosiciones: " + nodo.Getposicion()+"\n";
    }
    /**
     * Función que regresa el más frecuente en String
     * @return la cadena mas frecuente.
     */
    public String MasFrecuenteString() {
    NodoHash nodo = getMasFrecuente();
    if (nodo == null) {
        return "No hay datos disponibles.";
    }
    return "Cadena: " + nodo.getCadena() + "\nFrecuencia: " + nodo.getFrecuencia() + "\nPosiciones: " + nodo.Getposicion()+"\n";
}


    /**
     * Funcion que buscar la cadena menos frecuente
     * @return la cadena menos frecuente. 
     */
    public NodoHash getMenosFrecuente() {
        NodoHash menosFrecuente = null;
        int menorFrecuencia = -1;   
        for (int i = 0; i < Tabla.length; i++) {
            NodoHash actual = Tabla[i];
            while (actual != null) {
                if (menosFrecuente == null || actual.getFrecuencia() < menorFrecuencia) {
                menosFrecuente = actual;
                menorFrecuencia = actual.getFrecuencia();
            }
            actual = actual.getpNext();
        }
    }
    return menosFrecuente;
}
    
    /**
     * Función que buscar el mas frecuente.
     * @return el NodoHash mas frecuente 
     */
    public NodoHash getMasFrecuente() {
        NodoHash masFrecuente = null;
        int mayorFrecuencia = -1;
        for (int i = 0; i < Tabla.length; i++) {
        NodoHash actual = Tabla[i];
        while (actual != null) {
            if (masFrecuente == null || actual.getFrecuencia() > mayorFrecuencia) {
                masFrecuente = actual;
                mayorFrecuencia = actual.getFrecuencia();
            }
            actual = actual.getpNext();
        }
    }
    return masFrecuente;
}
    /**
     * Funcion que regresa todos los aminoácidos de mi HashTable
     * @return el string con todos los aminoácidos 
     */
      public String obtenerTodos() {
            String resultado = "";
            for (int i = 0; i < Tabla.length; i++) {
            NodoHash actual = Tabla[i];
            while (actual != null) {
                resultado += actual.getCadena()+":" + "  Frecuencia: " + actual.getFrecuencia() + "  Posiciones: " + actual.Getposicion()+ "\n"; 
//                resultado += "\n";
            actual = actual.getpNext();
        }
    }
    return resultado;
}

   /**
    * Método que maneja la inserción en la lista enlazada dentro de la tabla hash en caso de colisión.
     * Si la tripleta ya existe, actualiza la frecuencia y posiciones.
     * Si no, agrega un nuevo nodo al final de la lista.
    * @param tripleta cadena que se desea insertar.
    * @param posicion posición asociada a la cadena.
    * @param clave índice donde se desea insertar.
    */
    public void guardarHit(String tripleta, int posicion, int clave){
        NodoHash actual = this.getTabla()[clave]; 
        NodoHash aux = null; 
        while(actual!= null){
            if(actual.getCadena().equals(tripleta)){
            actual.Repetido(posicion);
            return;
            
        }
        aux= actual; 
        actual = actual.getpNext();
        }
        aux.setpNext(new NodoHash(tripleta,posicion));
    }
    /**
     * Registra una colisión en la lista de colisiones, incrementando el contador total y guardando el detalle
     * @param indice el índice donde ocurre la colisión
     * @param existente cadena que ya estaba almacenada
     * @param nuevo cadena que causó la colisión al tratar de insertarse
     */
    public void registrarColision(int indice, String existente, String nuevo){
        setTotalColisiones(getTotalColisiones() + 1);
        getListaColisiones().insertarFinal(indice, existente, nuevo);
    } 
    
    /**
     * Busca una tripleta en la HashTable y devuelve el nodo asociado. Devuelve null si no lo encuntra
     * @param tripleta Cadena que se desea buscar
     * @return el nodoHash asosiado a esa tripleta o null si no existe.
     */
    public NodoHash buscar(String tripleta){
        int clave = hasheo(tripleta);
        NodoHash nodo = this.getTabla()[clave];
        while (nodo != null) {
            if (tripleta.equals(nodo.getCadena())) {
                return nodo;
            }
            nodo = nodo.getpNext();
        }
        return null;
    }
    /**
     * Devuelve un reporte de las colisiones ocurridas. 
     */
    public String mostrarColisiones() {
        if (getTotalColisiones() == 0) {
            return "No se registran colisiones.";
    } else {
        return getListaColisiones().mostrar();
    }
}
    /**
     * Devuelve la cantidad total de colisiones registradas
     * @return el numero total de colisiones
     */
    public int getTotalColisiones() {
        return totalColisiones;
    }

    /**
     * Obtiene la HashTabla
     * @return la tabla
     */
    public NodoHash[] getTabla() {
        return Tabla;
    }

/**
 * Establece la tabla 
 * @param Tabla la tabla que se establecio 
 */
    public void setTabla(NodoHash[] Tabla) {
        this.Tabla = Tabla;
    }

    /**
     * Obtiene el tamaño de la HashTable
     * @return el tamaño 
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el tamaño de la HashTable
     * @param size el tamaño que se desea establecer
     */
    public void setSize(int size) {
        this.size = size;
    }



    /**
     * Obtiene la lista de colisiones
     * @return la lista de colisiones
     */
    public ListaColisiones getListaColisiones() {
        return listaColisiones;
    }

    /**
     * Establece el total de colisiones
     * @param totalColisiones el número nuevo de colisiones
     */
    public void setTotalColisiones(int totalColisiones) {
        this.totalColisiones = totalColisiones;
    }

    /**
    * Establece la lista de colisiones.
    * @param listaColisiones la lista a establecer
    */
    public void setListaColisiones(ListaColisiones listaColisiones) {
        this.listaColisiones = listaColisiones;
}
} 

