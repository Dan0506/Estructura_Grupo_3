/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Configuracion;
import javax.swing.*;
import java.io.*;
/**
 *
 * @author daniel
 */
public class Configuracion {
    private String nombreBanco;
    private int cantidadCajas;
    private int cajasPreferenciales;
    private int cajasRapidas;
    private int cajasNormales;

    // constructor
    public Configuracion(String nombreBanco, int cantidadCajas, int cajasPreferenciales, int cajasRapidas, int cajasNormales) {
        this.nombreBanco = nombreBanco;
        this.cantidadCajas = cantidadCajas;
        this.cajasPreferenciales = cajasPreferenciales;
        this.cajasRapidas = cajasRapidas;
        this.cajasNormales = cantidadCajas - cajasPreferenciales - cajasRapidas;
    }

    // getters y setters
    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public int getCantidadCajas() {
        return cantidadCajas;
    }

    public void setCantidadCajas(int cantidadCajas) {
        this.cantidadCajas = cantidadCajas;
    }

    public int getCajasPreferenciales() {
        return cajasPreferenciales;
    }

    public void setCajasPreferenciales(int cajasPreferenciales) {
        this.cajasPreferenciales = cajasPreferenciales;
    }

    public int getCajasRapidas() {
        return cajasRapidas;
    }

    public void setCajasRapidas(int cajasRapidas) {
        this.cajasRapidas = cajasRapidas;
    }

    public int getCajasNormales() {
        return cajasNormales;
    }

    public void setCajasNormales(int cajasNormales) {
        this.cajasNormales = cajasNormales;
    }

    // guardar configuración en un archivo
    public void guardarConfiguracion(String rutaArchivo) throws IOException {
        String contenido = nombreBanco + "\n" + cantidadCajas + "\n" + cajasPreferenciales + "\n" + cajasRapidas + "\n" + cajasNormales;
        Archivo.escribir(rutaArchivo, contenido);
    }

    // cargar configuración desde un archivo
    public static Configuracion cargarConfiguracion(String rutaArchivo) throws IOException {
        String[] datos = Archivo.leer(rutaArchivo).split("\n");
        String nombreBanco = datos[0];
        int cantidadCajas = Integer.parseInt(datos[1]);
        int cajasPreferenciales = Integer.parseInt(datos[2]);
        int cajasRapidas = Integer.parseInt(datos[3]);
        int cajasNormales = Integer.parseInt(datos[4]);
        return new Configuracion(nombreBanco, cantidadCajas, cajasPreferenciales, cajasRapidas, cajasNormales);
    }

    // configurar el sistema (interactivo con JOptionPane)
    public static Configuracion configurarSistema() {
        String nombreBanco = JOptionPane.showInputDialog("Ingrese el nombre del banco:");
        int cantidadCajas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad total de cajas (mínimo 3):"));

        while (cantidadCajas < 3) {
            cantidadCajas = Integer.parseInt(JOptionPane.showInputDialog("La cantidad de cajas debe ser al menos 3. Intente de nuevo:"));
        }

        int cajasPreferenciales = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de cajas preferenciales (mínimo 1):"));
        while (cajasPreferenciales < 1) {
            cajasPreferenciales = Integer.parseInt(JOptionPane.showInputDialog("Debe haber al menos una caja preferencial. Intente de nuevo:"));
        }

        int cajasRapidas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de cajas rápidas (mínimo 1):"));
        while (cajasRapidas < 1) {
            cajasRapidas = Integer.parseInt(JOptionPane.showInputDialog("Debe haber al menos una caja rápida. Intente de nuevo:"));
        }

        int cajasNormales = cantidadCajas - cajasPreferenciales - cajasRapidas;
        if (cajasNormales < 0) {
            JOptionPane.showMessageDialog(null, "La configuración no es válida. Verifique los valores ingresados.");
            return configurarSistema(); // Reintentar
        }

        return new Configuracion(nombreBanco, cantidadCajas, cajasPreferenciales, cajasRapidas, cajasNormales);
    }
}