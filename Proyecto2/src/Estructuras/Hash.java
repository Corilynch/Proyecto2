/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import static java.lang.Math.abs;

/**
 *
 * @author corinalynch
 */
public class Hash {
    NodoHash[] Tabla;
    int size;
    
    public Hash(){
    this.size = 10;
    this.Tabla = new NodoHash[size];
    }
    
    public void Guardar(String triplete, int posicion){
        int clave = Hasheo(triplete);
        if(this.Tabla[clave]==null){
            NodoHash nodo = new NodoHash(triplete, posicion);
            this.Tabla[clave] = nodo;
        } else{
            GuardarHit(triplete, posicion, clave);
        }
    }
    
    private void GuardarHit(String triplete, int posicion, int clave){
        NodoHash current = this.Tabla[clave];
        NodoHash aux;
        do {
            if(current.getCadena().equals(triplete)){
                current.Repetido(posicion);
                return;
            }
            aux = current;
            current = current.getpNext();
        } while (current!=null);
        aux.setpNext(new NodoHash(triplete, posicion));
    }
    
    public NodoHash Buscar(String triplete){
        int clave = Hasheo(triplete);
        NodoHash nodo = this.Tabla[clave];
        while(nodo!=null){
            if(triplete.equals(nodo.getCadena())){
                return nodo;
            }
            nodo = nodo.getpNext();
        }
        return nodo;
    }
    
    private int Hasheo(String triplete){
        int valor = abs(triplete.hashCode());
        return valor % size;
    }
}
