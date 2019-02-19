/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Otaku
 */
public class Consultas extends Database {

    public Consultas(String db, String user, String pass, String ip, String port) {
        super.setDb(db);
        super.setUser(user);
        super.setPassword(pass);
        super.setUrl(ip, port);
        super.conectar();
    }

    public boolean iniciarSesion(String usuario, String pass) {
        String contraseña = "";
        boolean log = false;
        try {
            String q = "SELECT contraseña FROM persona WHERE nombre = '" + usuario + "'";
            PreparedStatement pstm = this.getConexion().prepareStatement(q);
            ResultSet res = pstm.executeQuery();
            while (res.next()) {
                contraseña = res.getString("contraseña");
            }
            res.close();
            if (pass.equals(contraseña)) {
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión\n\n" + e.getMessage());
            e.printStackTrace();
        }
        return log;
    }

    public boolean Logeo(String user, String pass) {
        int ad = 0;
        try {
            String q = "SELECT * FROM persona";
            PreparedStatement pstm = this.getConexion().prepareStatement(q);
            ResultSet res = pstm.executeQuery();
            while (res.next()) {
                ad = res.getInt("contraseña");
            }
            res.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión\n\n" + e.getMessage());
            e.printStackTrace();
        }
        return true;
    }
    
    
    
    //PERSONAS
    
    
    
    //PRODUCTOS
    
    
    
    //TICKETS
}
