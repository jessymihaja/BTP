/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import org.mindrot.jbcrypt.BCrypt;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utilisateur.Users;

/**
 *
 * @author jessy
 */
@WebServlet(urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username!= null && password!= null) {
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            try {
                Users user=new Users(username, hashedPassword);
                user.insertWithoutId("users");
                resp.sendRedirect("login.jsp");
            } catch (Exception e) {
                e.printStackTrace();
                resp.sendRedirect("register.jsp?error=database");
            }
        } else {
            resp.sendRedirect("register.jsp?error=missing");
        }
    }
}
