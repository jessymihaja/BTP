<%-- 
    Document   : listeDevis
    Created on : 14 mai 2024, 16:38:30
    Author     : jessy
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="utilisateur.Client" %>
<%@ page import="devis.Devis" %>
<%@ page import="btp.Type_maison" %>


<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session = request.getSession(false);
    Client c=(Client) session.getAttribute("client");
    Devis d= new Devis();
   ArrayList<Devis> devis_liste= c.getDevisByClient();
 %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/acceuil.css"/>
        <title>liste de devis</title>
    </head> 
    <body>
        <div id="header">
            <img src="assets/img/logo.png" alt="alt"/>
            <div id="tollsbar">
            <%
                
                if (session!= null) {
                    Client client = (Client) session.getAttribute("client");
                    if (client!= null) {
            %>
                        compte: <%= client.getNumero() %>
            <%
                } else {
            %>
                Vous n'êtes pas connecté.
            <%
                    }
               }
            %>
            <a href="listeDevis.jsp" class="menu">Devis</a>
            <a href="DeconnexionServlet" id="deconnexion">Déconnexion</a>
            </div>
        </div>
            <table class="table table-dark table-bordered">
        <thead>
            <tr>
                <th>ref</th>
                <th>Type maison</th>
                <th>Type finition</th>
                <th>Date debut de travaux</th>
                <th>Date debut de devis</th>
            </tr>
        </thead>
        <tbody>
            <% for( Devis dev : devis_liste) { %>
                <tr>
                    <td><%= dev.getRef_devis() %></td>
                    <td><%= dev.getType_maison().getDesignation() %></td>
                    <td><%= dev.getType_finition().getDesignation() %></td>
                    <td><%= dev.getDateDebut() %></td>
                    <td><%= dev.getDateDevis() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
    </body>
</html>
