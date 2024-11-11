package com.fiap.fintech.servlet;

import com.fiap.fintech.dao.UserDAO;
import com.fiap.fintech.model.User;
import com.fiap.fintech.middleware.PasswordValidator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String validationMessage = PasswordValidator.validatePassword(password);
        if (validationMessage != null) {
            request.setAttribute("error", validationMessage);
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        String passwordHash = PasswordValidator.hashPassword(password);
        User newUser = new User(0, name, email, passwordHash);

        try {
            boolean userCreated = userDAO.createUser(newUser);
            if (userCreated) {
                response.sendRedirect("login.jsp");
            } else {
                request.setAttribute("error", "err");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "err " + e.getMessage());
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
