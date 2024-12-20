/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoTiquetes;

/**
 *
 * @author Daniel Barrantes
 */
public class Nodo {
    public Tiquete dato;  
    public Nodo siguiente;    

 
    public Nodo(Tiquete dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
