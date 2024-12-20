/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoTiquetes;

/**
 *
 * @author Daniel Barrantes
 */
import java.util.*;

public class ManejoCajas {
    private List<ColaDePrioridad> cajas = new ArrayList<>();

    public ManejoCajas() {
    }
    
    public void insertarCaja(ColaDePrioridad caja) {
        cajas.add(caja);
    }
    
    public void insertarTiquete(Tiquete tiquete) {
        if (cajas.isEmpty()){
            System.out.println("No hay cajas");
        }
        else {
            int shortest = -1;
            ColaDePrioridad caja = null;
            for (ColaDePrioridad c : cajas) {
                if (shortest == -1){
                    shortest = c.capacidad;
                    caja = c;
                }
                else if (c.capacidad < shortest){
                        shortest = c.capacidad;
                        caja = c;
                }
            }
            caja.insertar(tiquete);
        }
    }
    
    public void imprimirCajas(){
        if (cajas.isEmpty()){
            System.out.println("No hay cajas");
        }
        else {
            int id = 1;
            for (ColaDePrioridad c : cajas) {
                System.out.print("Caja ");
                System.out.println(id);
                c.imprimirCola();
                System.out.println("");
                id +=1;
            }
        }
    }
        
}
