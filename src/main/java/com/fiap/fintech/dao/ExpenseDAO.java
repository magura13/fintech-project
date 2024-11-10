package com.fiap.fintech.dao;

import com.fiap.fintech.model.Expense;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {

    public boolean addExpense(Expense expense) {
        String sql = "INSERT INTO EXPENSES (DESCRIPTION, AMOUNT, EXPENSE_DATE, USER_ID, SOURCE) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, expense.getDescription());
            stmt.setDouble(2, expense.getAmount());
            stmt.setDate(3, new java.sql.Date(expense.getExpenseDate().getTime()));
            stmt.setInt(4, expense.getUserId());
            stmt.setString(5, expense.getSource());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Despesa cadastrada com sucesso: " + expense.getDescription());
                return true;
            }

        } catch (SQLException e) {
            System.err.println("Erro ao inserir despesa: " + e.getMessage());
        }
        return false;
    }

    public List<Expense> getAllExpensesByUserId(int userId) {
        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT * FROM EXPENSES WHERE USER_ID = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Expense expense = new Expense(
                        rs.getInt("EXPENSE_ID"),
                        rs.getInt("USER_ID"),
                        rs.getString("SOURCE"),
                        rs.getString("DESCRIPTION"),
                        rs.getDouble("AMOUNT"),
                        rs.getDate("EXPENSE_DATE")
                );
                expenses.add(expense);
            }
        } catch (SQLException e) {
            System.err.println("ExpenseDAO: Erro ao buscar despesas para userId = " + userId + " - " + e.getMessage());
        }
        return expenses;
    }

    public boolean deleteExpense(int expenseId) {
        String sql = "DELETE FROM EXPENSES WHERE EXPENSE_ID = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, expenseId);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao excluir despesa com ID: " + expenseId + " - " + e.getMessage());
            return false;
        }
    }

}
