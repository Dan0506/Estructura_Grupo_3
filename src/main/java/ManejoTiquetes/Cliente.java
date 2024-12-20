/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoTiquetes;

/**
 *
 * @author Daniel Barrantes
 */
public class Cliente {
    private String nombre;
    private int id;
    private int edad;

    public Cliente(String nombre, int id, int edad) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Cliente: " +
                nombre + '\'' +
                ", id= " + id +
                ", edad= " + edad +
                '}';
    }
}
