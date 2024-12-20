/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoTiquetes;

/**
 *
 * @author Daniel Barrantes
 */
public class ColaDePrioridad {
    private Nodo frente; 
    private Nodo fin;   
    public int capacidad = 0;
    
    public ColaDePrioridad() {
        this.frente = null;
        this.fin = null;
    }
    //Método para insertar un nodo según la prioridad
    public void insertar(Tiquete tiquete) {
        capacidad += 1;
        Nodo nuevo = new Nodo(tiquete);

        //Si la cola está vacía el nuevo nodo es el primero
        if (frente == null) {
            frente = nuevo;
            fin = nuevo;
        } else {
       
            Nodo actual = frente;
            Nodo anterior = null;

            //Recorremos buscando la posición adecuada
            while (actual != null && actual.dato.getPrioridad() <= tiquete.getPrioridad()) {
                anterior = actual;
                actual = actual.siguiente;
            }
            if (anterior == null) { 
                //El nodo nuevo tiene mayor prioridad va al frente
                nuevo.siguiente = frente;
                frente = nuevo;
            } else if (actual == null) {          
                fin.siguiente = nuevo;
                fin = nuevo;
            } else {
                anterior.siguiente = nuevo;
                nuevo.siguiente = actual;
            }
        }
    }

    //Método para atender al cliente de mayor prioridad
    public Tiquete atender() {
        if (frente == null) {
            System.out.println("La cola está vacía.");
            return null;
        }
        capacidad -= 1;
        Tiquete atendido = frente.dato;
        frente = frente.siguiente;

        if (frente == null) {
            fin = null;
        }
        return atendido;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void imprimirCola() {
        Nodo actual = frente;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }    
}
