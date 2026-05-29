package com.crm.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import io.github.cdimascio.dotenv.Dotenv;

public class DatabaseConnection {

  
    private static final Dotenv dotenv = Dotenv.load();
    private static final String URL = dotenv.get("DB_URL");
    private static final String USER = dotenv.get("DB_USER");
    private static final String PASSWORD = dotenv.get("DB_PASS");

  
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


    public static void initializeDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS leads (" +
                     "id SERIAL PRIMARY KEY, " +
                     "client_name VARCHAR(100) NOT NULL, " +
                     "phone_number VARCHAR(11) NOT NULL, " +
                     "status VARCHAR(20) NOT NULL, " +
                     "deal_value DECIMAL(10, 2) NOT NULL" +
                     ");";

       
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            
            stmt.execute(sql);
            System.out.println("[System] Database and 'leads' table verified/created successfully.");
            
        } catch (SQLException e) {
            System.err.println("[Error] Failed to initialize database: " + e.getMessage());
        }
    }
}