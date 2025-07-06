/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 * Implementación de tabla hash con manejo de colisiones por encadenamiento.
 * Almacena tripletes de ADN y sus posiciones en la secuencia.
 */
public class Hash {
    private NodoHash[] Tabla;
    private int size;
    private int totalColisiones;

    /**
     * Constructor que inicializa la tabla con tamaño por defecto (10).
     */
    public Hash() {
        this.size = 10;
        this.Tabla = new NodoHash[size];
        this.totalColisiones = 0;
    }

    /**
     * Almacena un triplete y su posición en la tabla hash.
     * @param triplete Cadena de 3 caracteres (A, T, C, G)
     * @param posicion Índice en la secuencia de ADN
     */
    public void Guardar(String triplete, int posicion) {
        int clave = Hasheo(triplete);
        if(this.Tabla[clave] == null) {
            NodoHash nodo = new NodoHash(triplete, posicion);
            this.Tabla[clave] = nodo;
        } else {
            if(!this.Tabla[clave].getCadena().equals(triplete)) {
                totalColisiones++;
            }
            GuardarHit(triplete, posicion, clave);
        }
    }

    /**
     * Maneja la inserción cuando ocurre una colisión.
     * @param triplete Cadena a insertar
     * @param posicion Índice en la secuencia
     * @param clave Índice calculado en la tabla
     */
    private void GuardarHit(String triplete, int posicion, int clave) {
        NodoHash current = this.Tabla[clave];
        NodoHash aux;
        do {
            if(current.getCadena().equals(triplete)) {
                current.Repetido(posicion);
                return;
            }
            aux = current;
            current = current.getpNext();
        } while (current != null);
        aux.setpNext(new NodoHash(triplete, posicion));
    }

    /**
     * Busca un triplete en la tabla hash.
     * @param triplete Cadena a buscar
     * @return NodoHash con la información o null si no existe
     */
    public NodoHash Buscar(String triplete) {
        int clave = Hasheo(triplete);
        NodoHash nodo = this.Tabla[clave];
        while(nodo != null) {
            if(triplete.equals(nodo.getCadena())) {
                return nodo;
            }
            nodo = nodo.getpNext();
        }
        return nodo;
    }

    /**
     * Función hash personalizada para tripletes de ADN.
     * @param triplete Cadena de 3 caracteres
     * @return Índice en la tabla hash
     */
    private int Hasheo(String triplete) {
        int valor = 0;
        for(int i = 0; i < triplete.length(); i++) {
            valor = 31 * valor + triplete.charAt(i);
        }
        return Math.abs(valor) % size;
    }

    /**
     * @return Número total de colisiones registradas
     */
    public int getTotalColisiones() {
        return totalColisiones;
    }

    /**
     * @return Arreglo principal de la tabla hash
     */
    public NodoHash[] getTabla() {
        return Tabla;
    }
}