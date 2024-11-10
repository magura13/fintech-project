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

        System.out.println("Tipo recebido: " + type);
        System.out.println("ID recebido: " + idParam);

        if (idParam != null && !idParam.isEmpty() && type != null) {
            try {
                int id = Integer.parseInt(idParam);
                boolean isDeleted = false;

                if ("income".equals(type)) {
                    isDeleted = incomeDAO.deleteIncome(id);
                    System.out.println("Exclusão de income resultado: " + isDeleted);
                } else if ("expense".equals(type)) {
                    System.out.println("Exclusão de expense resultado: " + isDeleted);
                }

                if (isDeleted) {
                    response.sendRedirect("home");
                } else {
                    response.sendRedirect("home?error=Não foi possível remover o " + type);
                }
            } catch (NumberFormatException e) {
                System.out.println("ID inválido fornecido: " + idParam);
                response.sendRedirect("home?error=ID inválido");
            }
        } else {
            response.sendRedirect("home?error=Parâmetros inválidos");
        }
    }
}
