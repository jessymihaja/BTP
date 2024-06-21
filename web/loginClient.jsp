<%-- 
    Document   : loginClient
    Created on : 13 mai 2024, 15:46:24
    Author     : jessy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login client</title>
    </head>
    <body>
        <form action="LoginClientServlet" method="post">
        <label for="numero">numero</label><br>
        <input type="text" value="0" id="telephone" name="numero" pattern="\03\d{10}" title="Format attendu : 0*********" required/>
        <input type="submit" value="Se connecter">
    </form>
    <% if (request.getParameter("error")!= null) { %>
        <p style="color:red;">Erreur: <%= request.getParameter("error") %> </p>
    <% } %>
    </body>
</html>
