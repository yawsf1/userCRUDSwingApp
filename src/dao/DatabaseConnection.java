package dao;
import java.sql.*;
import javax.swing.*;
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/SwingApp";
    private static final String USER = "root";
    private static final String PASSWORD = "@malikaoui11";
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to database!");
            return conn;
        }
        catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "MySQL Driver not found!");
            e.printStackTrace();
            return null;
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Connection failed: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}