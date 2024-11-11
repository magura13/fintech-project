package com.fiap.fintech;

import com.fiap.fintech.dao.ConnectionManager;
import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        try (Connection connection = ConnectionManager.getConnection()) {
            if (connection != null) {
                System.out.println("conected");
            } else {
                System.out.println("err");
            }
        } catch (SQLException e) {
            System.err.println("err=  " + e.getMessage());
        }
    }
}
