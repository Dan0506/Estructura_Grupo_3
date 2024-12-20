/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Configuracion;
import javax.swing.*;
/**
 *
 * @author daniel
 */
public class Login {
    private static final String[][] USUARIOS = {
        {"admin", "1234"},
        {"usuario", "abcd"}
    };

    public static boolean iniciarSesion() {
        for (int intentos = 3; intentos > 0; intentos--) {
            String usuario = JOptionPane.showInputDialog("Ingrese su usuario:");
            String contrasena = JOptionPane.showInputDialog("Ingrese su contraseña:");

            for (String[] credencial : USUARIOS) {
                if (credencial[0].equals(usuario) && credencial[1].equals(contrasena)) {
                    JOptionPane.showMessageDialog(null, "¡Bienvenido al sistema!");
                    return true;
                }
            }

            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos. Intentos restantes: " + (intentos - 1));
        }

        JOptionPane.showMessageDialog(null, "Demasiados intentos fallidos. El sistema se cerrará.");
        return false;
    }
}