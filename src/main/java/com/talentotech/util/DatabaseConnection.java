package com.talentotech.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Configuración de Conexión
    private static final String URL =  "jdbc:mysql://mysql-b0fd576-jburiticamorales-240d.f.aivencloud.com:23680/energy_communities?sslMode=REQUIRED";
    private static final String USER = "avnadmin";          // Cambia por tu usuario
    private static final String PASSWORD = "CONTRASEÑA";   // Cambia por tu contraseña

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Falta el Driver MySQL", e);
        }
    }

    public static boolean testConnection() {
        try (Connection conn = getConnection()) {
            System.out.println("✓ Conexión exitosa a BD");
            return true;
        } catch (SQLException e) {
            System.err.println("✗ Error de conexión: " + e.getMessage());
            return false;
        }
    }
}