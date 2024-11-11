package com.fiap.fintech.dao;

import com.fiap.fintech.model.Income;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IncomeDAO {

    public boolean addIncome(Income income) {
        String sql = "INSERT INTO INCOMES (DESCRIPTION, AMOUNT, INCOME_DATE, USER_ID, SOURCE) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, income.getDescription());
            stmt.setDouble(2, income.getAmount());
            stmt.setDate(3, new java.sql.Date(income.getIncomeDate().getTime()));
            stmt.setInt(4, income.getUserId());
            stmt.setString(5, income.getSource());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("err: " + income.getDescription());
                return true;
            }

        } catch (SQLException e) {
            System.err.println("err:" + e.getMessage());
        }
        return false;
    }

    public List<Income> getAllIncomesByUserId(int userId) {
        List<Income> incomes = new ArrayList<>();
        String sql = "SELECT * FROM INCOMES WHERE USER_ID = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Income income = new Income(
                        rs.getInt("INCOME_ID"),
                        rs.getInt("USER_ID"),
                        rs.getString("SOURCE"),
                        rs.getString("DESCRIPTION"),
                        rs.getDouble("AMOUNT"),
                        rs.getDate("INCOME_DATE")
                );
                incomes.add(income);
            }

        } catch (SQLException e) {
            System.err.println("err: " + userId + " - " + e.getMessage());
        }
        return incomes;
    }

    public boolean deleteIncome(int incomeId) {
        String sql = "DELETE FROM INCOMES WHERE INCOME_ID = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, incomeId);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("err " + e.getMessage());
            return false;
        }
    }
}
