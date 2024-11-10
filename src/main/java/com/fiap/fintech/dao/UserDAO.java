package com.fiap.fintech.dao;

import com.fiap.fintech.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public User getUserByEmailAndPasswordHash(String email, String passwordHash) {
        String sql = "SELECT USER_ID, NAME, EMAIL, PASSWORD_HASH FROM users WHERE EMAIL = ? AND PASSWORD_HASH = ?";
        User user = null;

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, passwordHash);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int userId = rs.getInt("USER_ID");
                    String name = rs.getString("NAME");
                    String userEmail = rs.getString("EMAIL");
                    String userPasswordHash = rs.getString("PASSWORD_HASH");

                    user = new User(userId, name, userEmail, userPasswordHash);
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário pelo email: " + email + " - " + e.getMessage());
        }
        return user;
    }

    public boolean createUser(User user) throws SQLException {
        String sql = "INSERT INTO users (name, email, password_hash) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPasswordHash());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuário cadastrado com sucesso: " + user.getEmail());
                return true;
            } else {
                System.out.println("Falha ao cadastrar usuário: " + user.getEmail());
            }

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar usuário: " + user.getEmail() + " - " + e.getMessage());
            throw e; // Lança a exceção para que o servlet possa lidar com ela
        }
        return false;
    }
}
