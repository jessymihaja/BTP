/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import converter.DateConverter;
import devis.Details_devis;
import devis.Devis;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilisateur.Client;

/**
 *
 * @author jessy
 */
@WebServlet(urlPatterns = {"/DevisServlet"})
public class DevisServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idType_maison=Integer.parseInt(req.getParameter("type_maison"));
        int idType_finition=Integer.parseInt(req.getParameter("type_finition"));
        String lieu=req.getParameter("lieu");
        Date dateDebut=Date.valueOf(req.getParameter("dateDebut"));
        HttpSession session = req.getSession();
        Client client=(Client)session.getAttribute("client");
        Devis devis=new Devis(client.getIdClient(), idType_maison, idType_finition, dateDebut, lieu);
        try {
            devis.insertWithoutId("devis");
            Devis newDevis=devis.getLastDevis();
            ArrayList<Details_devis> details_devis_liste=newDevis.createDevis_detail();
            for (Details_devis details_devis : details_devis_liste) {
                details_devis.insertWithoutId("detail_devis");
            }
            resp.sendRedirect("acceuil.jsp");
        } catch (Exception ex) {
            resp.sendRedirect("acceuil.jsp?error="+ex.getMessage());
        }
        
        
    }
    

}
