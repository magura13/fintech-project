package com.fiap.fintech.servlet;

import com.fiap.fintech.dao.IncomeDAO;
import com.fiap.fintech.model.Income;
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

@WebServlet("/income")
public class IncomeServlet extends HttpServlet {

    private final IncomeDAO incomeDAO = new IncomeDAO();
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            String source = request.getParameter("source");
            String description = request.getParameter("description");
            String amountParam = request.getParameter("amount");
            String incomeDateParam = request.getParameter("incomeDate");

            double amount = Double.parseDouble(amountParam);
            Date incomeDate = dateFormat.parse(incomeDateParam);

            Income income = new Income(userId, source, description, amount, incomeDate);

            boolean isAdded = incomeDAO.addIncome(income);
            if (isAdded) {
                response.sendRedirect("home");
            } else {
                response.sendRedirect("income_form.jsp?error=true");
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("income_form.jsp?error=true&message=Formato inválido para número.");
        } catch (ParseException e) {
            e.printStackTrace();
            response.sendRedirect("income_form.jsp?error=true&message=Data inválida.");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("income_form.jsp?error=true&message=Erro inesperado.");
        }
    }
}
