/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ASUS
 */
public class Conexion {

    private static final String URL =
        "jdbc:postgresql://aws-1-us-east-1.pooler.supabase.com:6543/postgres?sslmode=require";

    private static final String USER = "postgres.qhdfgpyytllmsczpelgx";
    private static final String PASSWORD = "fGaWyONPynaqjDjg";

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a Supabase");
        } catch (Exception e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }

        return con;
    }
}
