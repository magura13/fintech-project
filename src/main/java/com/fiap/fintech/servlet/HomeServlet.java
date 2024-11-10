package com.fiap.fintech.servlet;

import com.fiap.fintech.dao.IncomeDAO;
import com.fiap.fintech.dao.ExpenseDAO;
import com.fiap.fintech.model.Income;
import com.fiap.fintech.model.Expense;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private final IncomeDAO incomeDAO = new IncomeDAO();
    private final ExpenseDAO expenseDAO = new ExpenseDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        List<Income> incomes = incomeDAO.getAllIncomesByUserId(userId);
        List<Expense> expenses = expenseDAO.getAllExpensesByUserId(userId);

        double totalIncome = incomes.stream()
                .mapToDouble(Income::getAmount)
                .sum();
        System.out.println("Total de Receitas: " + totalIncome);

        double totalExpense = expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();
        System.out.println("Total de Despesas: " + totalExpense);

        double balance = totalIncome - totalExpense;
        System.out.println("Saldo Atual: " + balance);

        request.setAttribute("incomes", incomes);
        request.setAttribute("expenses", expenses);
        request.setAttribute("totalIncome", totalIncome);
        request.setAttribute("totalExpense", totalExpense);
        request.setAttribute("balance", balance);

        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
