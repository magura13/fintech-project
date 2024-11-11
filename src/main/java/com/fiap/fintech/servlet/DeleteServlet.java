package com.fiap.fintech.servlet;

import com.fiap.fintech.dao.ExpenseDAO;
import com.fiap.fintech.dao.IncomeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    private final IncomeDAO incomeDAO = new IncomeDAO();
    private final ExpenseDAO expenseDAO = new ExpenseDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String idParam = request.getParameter("id");

        if (idParam != null && !idParam.isEmpty() && type != null) {
            try {
                int id = Integer.parseInt(idParam);
                boolean isDeleted = false;

                if ("income".equals(type)) {
                    isDeleted = incomeDAO.deleteIncome(id);
                } else if ("expense".equals(type)) {
                    isDeleted = expenseDAO.deleteExpense(id);
                }

                if (isDeleted) {
                    response.sendRedirect("home");
                } else {
                    response.sendRedirect("home" + type);
                }
            } catch (NumberFormatException e) {
                response.sendRedirect("home");
            }
        } else {
            response.sendRedirect("home");
        }
    }
}
