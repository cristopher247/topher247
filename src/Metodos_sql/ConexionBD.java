/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */

public class ConexionBD {
    private Connection con;
        public  static String cadenaConexion= "jdbc:postgresql://localhost:5432/usuarios";
    public  static String pgUsuario="postgres";
     public  static String pgPass="1234";
    // public  static Connection con;//conexion
     public  static String clase ="org.postgresql.Driver";
    
     public  static Connection conectar(){
        Connection conexion=null;
        
        try {
           Class.forName(clase);
            conexion=(Connection)DriverManager.getConnection(cadenaConexion, pgUsuario, pgPass);
            if(conexion!=null){
                System.out.println("Conectado a la Base de Datos");
            }else{
                System.out.println("Error en la conexion");
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            
        }
        
        return conexion;
    }
      public PreparedStatement getPS(String sql){
         try {
             return con.prepareStatement(sql);
         } catch (SQLException ex) {
             Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
         return null;
         }
         
    }

    void setString(int i, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      public class pgConect {
     String cadenaConexion= "jdbc:postgresql://localhost:5432/postgres";
    String pgUsuario="postgres";
     String pgPass="1234";
    private Connection con;//conexion
    
    private Statement st;// comeando:sql
    private ResultSet rs;//Resultados de la consulta
    
    public pgConect(){
        //fijar clase de conexion
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pgConect.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        try {
            con= DriverManager.getConnection(cadenaConexion, pgUsuario, pgPass);
            System.out.println("conectado");
        } catch (SQLException ex) {
            Logger.getLogger(pgConect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    Connection conectar = null;
    public Connection conexion(){
        try{
          Class.forName("org.postgresql.Driver");
          conectar = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");
        }catch(ClassNotFoundException | SQLException e){
            System.out.print(e.getMessage());
        }
        return conectar;
    }
    public Connection conectar(){
        Connection link=null;
        
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link=DriverManager.getConnection(cadenaConexion, pgUsuario, pgPass);
            if(link!=null){
                System.out.println("Conectado a la Base de Datos");
            }else{
                System.out.println("Error en la conexion");
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            
        }
        
        return link;
    }
    public PreparedStatement getPS(String sql){
         try {
             return con.prepareStatement(sql);
         } catch (SQLException ex) {
             Logger.getLogger(pgConect.class.getName()).log(Level.SEVERE, null, ex);
         return null;
         }
         
    }
    //polimorfismo con el PreparedStatement
    public SQLException noQuery(PreparedStatement ps) {
        try{
            int res = ps.executeUpdate();
            return null;
        } catch (SQLException ex) {
             Logger.getLogger(pgConect.class.getName()).log(Level.SEVERE, null, ex);
        return ex; 
        }}
    
    public SQLException noQuery(String sql){
        try {
            st= con.createStatement();
            st.execute(sql);
            st.close();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(pgConect.class.getName()).log(Level.SEVERE, null, ex);
       return ex;
        }
        
    }
    
    public ResultSet query(String sql){
        try {
            st=con.createStatement();
             rs=st.executeQuery(sql);
             return rs;
        } catch (SQLException ex) {
            Logger.getLogger(pgConect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
}
     
    
}

}
