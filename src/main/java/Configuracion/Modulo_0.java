/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Configuracion;
import javax.swing.*;
import java.io.*;
/**
 *
 * @author daniel
 */
public class Modulo_0 {

    public static void main(String[] args) {
    try {
            if (!Login.iniciarSesion()) {
                System.exit(0);
            }

            String rutaArchivo = "prod.txt";
            Configuracion configuracion;

            File archivo = new File(rutaArchivo);
            if (archivo.exists()) {
                configuracion = Configuracion.cargarConfiguracion(rutaArchivo);
                JOptionPane.showMessageDialog(null, "Configuración cargada correctamente:\n"
                        + "Banco: " + configuracion.getNombreBanco() + "\n"
                        + "Cajas totales: " + configuracion.getCantidadCajas() + "\n"
                        + "Cajas preferenciales: " + configuracion.getCajasPreferenciales() + "\n"
                        + "Cajas rápidas: " + configuracion.getCajasRapidas() + "\n"
                        + "Cajas normales: " + configuracion.getCajasNormales());
            } else {
                configuracion = Configuracion.configurarSistema();
                configuracion.guardarConfiguracion(rutaArchivo);
                JOptionPane.showMessageDialog(null, "Configuración guardada correctamente.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage());
        }
    }
}
