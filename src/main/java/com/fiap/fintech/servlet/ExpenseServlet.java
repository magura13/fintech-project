package com.fiap.fintech.servlet;

import com.fiap.fintech.dao.ExpenseDAO;
import com.fiap.fintech.model.Expense;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/expense")
public class ExpenseServlet extends HttpServlet {

    private final ExpenseDAO expenseDAO = new ExpenseDAO();
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId == null) {
            System.out.println("Usuário não logado. Redirecionando para login.jsp.");
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            String source = request.getParameter("source");
            String description = request.getParameter("description");
            String amountParam = request.getParameter("amount");
            String expenseDateParam = request.getParameter("expenseDate");

            double amount = Double.parseDouble(amountParam);
            Date expenseDate = dateFormat.parse(expenseDateParam);

            Expense expense = new Expense(userId, source, description, amount, expenseDate);

            boolean isAdded = expenseDAO.addExpense(expense);
            if (isAdded) {
                response.sendRedirect("home");
            } else {
                response.sendRedirect("expense_form.jsp?error=true");
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("expense_form.jsp?error=true&message=Formato inválido para número.");
        } catch (ParseException e) {
            e.printStackTrace();
            response.sendRedirect("expense_form.jsp?error=true&message=Data inválida.");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("expense_form.jsp?error=true&message=Erro inesperado.");
        }
    }
}
