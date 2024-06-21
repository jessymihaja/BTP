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
import java.util.logging.Level;
import java.util.logging.Logger;
import utilisateur.Client;

/**
 *
 * @author jessy
 */
@WebServlet(urlPatterns = {"/LoginClientServlet"})
public class LoginClientServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String numero=req.getParameter("numero");
        Client c=new Client();
        ArrayList<Client> allClient=c.getAllClient();
        if(allClient.isEmpty()==false){
            for (Client client : allClient) {
                if(client.getNumero().equals(numero)){
                    HttpSession session = req.getSession();
                    session.setAttribute("client", client);
                    resp.sendRedirect("acceuil.jsp");
                    break;
                }else{
                    
                    try {
                        Client newClient=new Client(numero);
                        newClient.insertWithoutId("Client");
                        HttpSession session = req.getSession();
                   session.setAttribute("client", newClient.getClientByNumero(numero));
                    resp.sendRedirect("acceuil.jsp");
                    break;
                    
                    } catch (Exception ex) {
                        resp.sendRedirect("loginClient.jsp?error="+ex.getMessage());                    
                        break;
                    }
                }
            }
        }else{
                    
                    try {
                        Client newClient=new Client(numero);
                        newClient.insertWithoutId("Client");
                        HttpSession session = req.getSession();
                   session.setAttribute("client", newClient.getClientByNumero(numero));
                    resp.sendRedirect("acceuil.jsp");
                    
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        resp.sendRedirect("loginClient.jsp?error="+ex.getMessage());                    }
                }
    }
    
}
