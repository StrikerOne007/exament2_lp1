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

    private static final String URL = System.getenv("DATABASE_URL") != null
        ? System.getenv("DATABASE_URL")
        : "jdbc:postgresql://aws-1-us-east-1.pooler.supabase.com:6543/postgres?sslmode=require";

    private static final String USER = System.getenv("DATABASE_USER") != null
        ? System.getenv("DATABASE_USER")
        : "postgres.qhdfgpyytllmsczpelgx";

    private static final String PASSWORD = System.getenv("DATABASE_PASSWORD") != null
        ? System.getenv("DATABASE_PASSWORD")
        : "fGaWyONPynaqjDjg";

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
