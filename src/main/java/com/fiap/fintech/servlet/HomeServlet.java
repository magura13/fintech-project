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
import java.text.DecimalFormat;

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

        double totalExpense = expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();

        double balance = totalIncome - totalExpense;

        DecimalFormat df = new DecimalFormat("#.00");

        request.setAttribute("incomes", incomes);
        request.setAttribute("expenses", expenses);
        request.setAttribute("totalIncome", df.format(totalIncome));
        request.setAttribute("totalExpense", df.format(totalExpense));
        request.setAttribute("balance", df.format(balance));

        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
