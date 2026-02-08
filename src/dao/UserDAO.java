package dao;

import metier.User;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class UserDAO implements IUserDAO {

    private Connection connection;

    public UserDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void ajouter(User user) {
        String sql = "INSERT INTO users (nom, prenom, email) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getNom());
            stmt.setString(2, user.getPrenom());
            stmt.setString(3, user.getEmail());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "User ajouté avec succès!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout: " + e.getMessage());
        }
    }

    @Override
    public void modifier(User user) {
        String sql = "UPDATE users SET nom=?, prenom=?, email=? WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getNom());
            stmt.setString(2, user.getPrenom());
            stmt.setString(3, user.getEmail());
            stmt.setInt(4, user.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "User modifié avec succès!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la modification: " + e.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        String sql = "DELETE FROM users WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "User supprimé avec succès!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la suppression: " + e.getMessage());
        }
    }

    @Override
    public User trouverParId(int id) {
        String sql = "SELECT * FROM users WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la recherche: " + e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<User> trouverTous() {
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email")
                ));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la récupération: " + e.getMessage());
        }
        return users;
    }
}