/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Otaku
 */
public class Database {

    private String db = "";
    private String user = "";
    private String password = "";
    private String url = "";
    private Connection conn = null;

    public void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Conexion MySQL realizada con exito.");
        } catch (SQLException e) {
            System.out.println("Conexion NO realizada con exito por error de SQL.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Conexion NO realizada con exito por error de Class.");
            e.printStackTrace();
        }
    }

    public Connection getConexion() {
        try {
            if (this.conn.isClosed()) {
                Class.forName("com.mysql.jdbc.Driver");
                this.conn = DriverManager.getConnection(this.url, this.user, this.password);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return this.conn;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrl(String ip, String puerto) {
        this.url = "jdbc:mysql://" + ip + ":" + puerto + "/" + db;
    }

}
