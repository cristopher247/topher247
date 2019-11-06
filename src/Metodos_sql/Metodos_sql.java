/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos_sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Acer
 */
public class Metodos_sql {
    public static ConexionBD conexion = new ConexionBD();
    public static PreparedStatement sentencia_preparada;
    public static  ResultSet resultado;
    public static String sql;
    
    public static int resultado_numero = 0;
    
    public int guardar(String nombre, String apellidos, String correo,String contrasena){
        int resultado = 0;
        Connection conexion = null;
            String sentencia_guardar= ("INSERT INTO usuarios  (nombre, apellidos, correo, contrasena) VALUES (?,?,?,?)");
            
            try {
                conexion = ConexionBD.conectar();
           
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
            sentencia_preparada.setString(1,nombre);
            sentencia_preparada.setString(2,apellidos);
            sentencia_preparada.setString(3,correo);
            sentencia_preparada.setString(4,contrasena);
            resultado = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();
            conexion.close();
        } catch (Exception e) {
                System.out.println(e);
        }
       return resultado;
    }
    public static String buscarNombre(String nombre){
        String busqueda_nombre = null;
        Connection conexion= null;
        
        try {
        conexion = ConexionBD.conectar();
        String sentencia_buscar =("SELECT *FROM usuarios WHERE nombre = '%"+nombre+"%'");
        sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
        resultado = sentencia_preparada.executeQuery();
        if(resultado.next()){
            String correo = resultado.getString("correo");
             String apellidos = resultado.getString("apellidos");
             busqueda_nombre =( nombre +" "+ apellidos);
             
        }
        conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_nombre;
    }
        public static String buscarUsuario(String nombre){
            String busqueda_usuario = null;
            Connection conexion = null;
            try {
                conexion = ConexionBD.conectar();
              
                String sentencia_buscar=("SELECT * FROM usuarios WHERE nombre = '%"+nombre+"%'  ");
                
               // "SELECT * FROM persona WHERE estado= 'A' AND (nombres like '%" +aguja+ "%'  or apellidos like '%" +aguja+  "%') ";
                sentencia_preparada =conexion.prepareStatement(sentencia_buscar);
                resultado = sentencia_preparada.executeQuery();
                if(resultado.next()){
                    busqueda_usuario = "USUARIO ENCONTRADO";
                    
                }else{
                    busqueda_usuario = "USUARIO NO ENCONTRADO 1";
                }
                conexion.close();
            } catch (Exception e) { System.out.println(e);
            }
        return busqueda_usuario;
        }
    
}
