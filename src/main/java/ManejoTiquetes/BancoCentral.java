/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoTiquetes;

/**
 *
 * @author Daniel Barrantes
 */
import java.time.LocalTime;
public class BancoCentral {

    public static void main(String[] args) {
     
        //crear una cola de prioridad para manejar los tiquetes
        ColaDePrioridad cola1 = new ColaDePrioridad(1);
        ColaDePrioridad cola2 = new ColaDePrioridad(2);
        ColaDePrioridad cola3 = new ColaDePrioridad(3);
        
        ManejoCajas mc = new ManejoCajas();
        mc.insertarCaja(cola1);
        mc.insertarCaja(cola2);
        mc.insertarCaja(cola3);
        
        System.out.println("Creando tiquetes...");
        mc.insertarTiquete(new Tiquete(new Cliente("Juan Pérez", 101, 65), "P")); //Cliente "p" preferencial
        mc.insertarTiquete(new Tiquete(new Cliente("Ana López", 102, 30), "A")); //Cliente con un solo trámite
        mc.insertarTiquete(new Tiquete(new Cliente("Carlos Ramírez", 103, 45), "B")); //Cliente con dos o más trámites
        mc.insertarTiquete(new Tiquete(new Cliente("Pedro Ruiz", 104, 41), "B"));
        mc.insertarTiquete(new Tiquete(new Cliente("Javier Contreras", 105, 32), "P"));
        mc.insertarTiquete(new Tiquete(new Cliente("Maria Ruiz", 106, 53), "A"));
        //Imprimir estado inicial de la cola
        System.out.println("\nEstado inicial de las colas:");
        mc.imprimirCajas();

        //Simular atención en la caja
        System.out.println("Atendiendo clientes...");
        while (!cola1.estaVacia()) {
            Tiquete atendido = cola1.atender();
            if (atendido != null) {
                System.out.println("Cliente atendido: " + atendido);
            }
        }

        //Verificar si la cola está vacía
        System.out.println("\nEstado final de la cola:");
        mc.imprimirCajas();
        
        //reporte
        mc.reporte();
    }
}

