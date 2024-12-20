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

public class Tiquete {
    private Cliente cliente;
    private LocalTime horaCreacion;
    private LocalTime horaAtencion;
    private String tramite; 
    private String tipo; // P: Preferencial, A: Un solo trámite, B: Dos o más trámites
    private int prioridad; 

    public Tiquete(Cliente cliente, String tipo) {
        this.cliente = cliente;
        this.tipo = tipo;
        this.horaCreacion = LocalTime.now();
        this.horaAtencion = null;

        // Asignar prioridad según tipo
        switch (tipo) {
            case "P":
                this.prioridad = 1; //Mayor prioridad preferencial
                break;
            case "A":
                this.prioridad = 2;
                break;
            case "B":
                this.prioridad = 3; //Menor prioridad
                break;
            default:
                this.prioridad = Integer.MAX_VALUE; // Tipo desconocido
        }
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setHoraAtencion(LocalTime horaAtencion) {
        this.horaAtencion = horaAtencion;
    }

    @Override
    public String toString() {
        return "Tiquete:  " +
                cliente +
                ", horaCreacion = " + horaCreacion +
                ", horaAtencion = " + (horaAtencion == null ? "Pendiente" : horaAtencion) +
                ", tipo='" + tipo + '\'' +
                ", prioridad = " + prioridad +
                '}';
    }    
}

