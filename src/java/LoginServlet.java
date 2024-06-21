/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;
import utilisateur.Users;

/**
 *
 * @author jessy
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username!= null && password!= null) {
            try {
                Users u= new Users();
                ArrayList<Users> users = u.getAllUsers();
                for (Users user : users) {
                    if (user.getUsername().equals(username)) {
                        if (BCrypt.checkpw(password, user.getHashedPassword())) { // Vérifiez le mot de passe
                            HttpSession session = req.getSession();
                            session.setAttribute("user", user);
                            resp.sendRedirect("dashboard.jsp");
                            break;
                        } else {
                            resp.sendRedirect("login.jsp?error=invalid");
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                resp.sendRedirect("login.jsp?error=database");
            }
        } else {
            resp.sendRedirect("login.jsp?error=missing");
        }
    }
}
