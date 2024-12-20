/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoTiquetes;

/**
 *
 * @author Daniel Barrantes
 */
import Configuracion.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.*;

public class ManejoCajas {
    private List<ColaDePrioridad> cajas = new ArrayList<>();
    private ConexionDB connectionDB = new ConexionDB();
    ResultSet resultado = null;

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
    
    public void reporte(){
        try {
            connectionDB.setConexion();
            connectionDB.setConsulta("SELECT id FROM log_cajas GROUP BY id ORDER BY COUNT(*) DESC");
            resultado = connectionDB.getResultado();
            System.out.print("La caja que mas ha atendido es la ");
            while (resultado.next()) {
                System.out.println(resultado.getInt("id"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionDB.cerrarConexion();
        }
        
        try {
            connectionDB.setConexion();
            connectionDB.setConsulta("SELECT COUNT(*) AS atendidos FROM log_cajas");
            resultado = connectionDB.getResultado();
            System.out.print("Se han atendido ");
            while (resultado.next()) {
                System.out.print(resultado.getInt("atendidos"));
            }
            System.out.println(" clientes");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionDB.cerrarConexion();
        }
    }
        
}
