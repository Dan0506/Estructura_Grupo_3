/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Configuracion;
import java.io.*;
/**
 *
 * @author daniel
 */
public class Archivo {
    // método para escribir en un archivo
    public static void escribir(String ruta, String contenido) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {
            writer.write(contenido);
        }
    }

    // método para leer un archivo y retornar su contenido
    public static String leer(String ruta) throws IOException {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        }
        return contenido.toString().trim();
    }
}
