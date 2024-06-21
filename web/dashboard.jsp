<%-- 
    Document   : dashboard
    Created on : 12 mai 2024, 22:38:47
    Author     : jessy
--%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="utilisateur.Users" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Tableau de bord</title>
</head>
<body>
<%
    session = request.getSession(false);
    if (session!= null) {
        Users user = (Users) session.getAttribute("user");
        if (user!= null) {
%>
            Bienvenue, <%= user.getUsername() %>!
<%
        } else {
%>
            Vous n'êtes pas connecté.
<%
        }
    }
%>
    <a href="DeconnexionServlet">Déconnexion</a>
</body>
</html>
