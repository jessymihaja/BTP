<%-- 
    Document   : acceuil
    Created on : 14 mai 2024, 09:32:30
    Author     : jessy
--%>
<%@ page import="btp.Type_maison" %>
<%@ page import="btp.Type_finition" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="utilisateur.Client" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%
    Type_maison m=new Type_maison();
    ArrayList<Type_maison> allType_maison=m.getAllType_maison();
    Type_finition f=new Type_finition();
    ArrayList<Type_finition> allType_finition=f.getAllType_finition();

    

    
    
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/acceuil.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div id="header">
            <img src="assets/img/logo.png" alt="alt"/>
            <div id="tollsbar">
            <%
                session = request.getSession(false);
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
    
    <br>
    <br>
    <h1 style="margin-left: 30px;">Creation d'un nouveau devis</h1>
    <div>
        <form action="DevisServlet" method="post">
            <h3>choix type de maison</h3>
                <div id="contenant">
                    
                    <% for(Type_maison maison : allType_maison){ %>
                        <div class="card">
                            <input type="radio" name="type_maison" id="<% out.print(maison.getIdType_Maison());%>" value="<% out.print(maison.getIdType_Maison());%>">
                            <label for="<% out.print(maison.getIdType_Maison());%>">
                                <p><%= maison.getDesignation() %></p>
                                <p><%= maison.getDescription() %></p>
                                <p>surface: <%= maison.getSurface() %></p>
                                <p>duree: <%= maison.getDuree_travaux() %></p>
                            </label>
                        </div>
                    <% } %>

                </div>
                    <br>
                <h3>choix type de finition</h3>
                <div id="contenant">
                    
                    <% for(Type_finition finition : allType_finition){ %>
                    <div class="card">
                           <input type="radio" id="id" name="type_finition" value="<% out.print(finition.getIdType_finition());%>">
                           <label for="<% out.print(finition.getIdType_finition());%>">
                                <p><%= finition.getDesignation() %></p>
                                <h2>
                                    
                                    <%= finition.getPourcentage() %>
                                    <span>%</span>
                                </h2>
                           </label>
                        </div>
                    <% } %>
                </div>
                <br><!-- comment -->
              
                <br>
                <div id="date"> 
                    lieux des travaux: <input type="texte" name="lieu">
                </div>
                <div id="date"> 
                    date debut des travaux: <input type="date" name="dateDebut">
                </div>
                <input type="submit" value="envoyer" class="btn">
        </form>
        
    </div>
    <% if (request.getParameter("error")!= null) { %>
        <p style="color:red;">Erreur: <%= request.getParameter("error") %> </p>
    <% } %>
    </body>
</html>
