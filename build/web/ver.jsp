<%-- 
    Document   : ver
    Created on : 10/10/2012, 06:50:28 PM
    Author     : rperez
--%>

<%@page import="mensajeria.DBhandler"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="mensajeria.Mensaje"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
    public String addLinebreaks(String input, int maxLineLength) {
        StringTokenizer tok = new StringTokenizer(input, " ");
        StringBuilder output = new StringBuilder(input.length());
        int lineLen = 0;
        while (tok.hasMoreTokens()) {
            String word = tok.nextToken();

            if (lineLen + word.length() > maxLineLength) {
                output.append(word + "<br/>");
                lineLen = 0;
            } else {
                output.append(word + " ");
                lineLen += word.length() + 1;
            }
        }
        return output.toString();
    }
%>
<html>
    <head>
        <% 
            System.out.println("ver jsp invocado");
            String nombre = request.getParameter("nombre");
        %>
        <title>ver</title>
        <style>
            table {border-collapse: collapse}
            td, th {padding:4px}
            th{background-color:#96B537;
               color:#ffffff;}
            td {
                color:#000000;
                background-color:#EAF2D3;
            }
        </style>
    </head>
    <body>
    <center>
        <h1>
            Mensajes para NNNN
        </h1>
        <table border=1>
            <tr><th>Remitente</th><th>Mensaje</th></tr>
                    <%
                       ArrayList<Mensaje> mensajes = DBhandler.getMessages(nombre);
                        for (int i = 0; i < mensajes.size(); i++) {
                            Mensaje m = (Mensaje) mensajes.get(i);
                    %>
            <tr><td><%=m.getDe()%></td><td><%=addLinebreaks(m.getContenido(), 60)%></td></tr>
            <%}%>
        </table>
        <br/><br/>
        <a href="inicio.jsp">Inicio</a>
    </center>
        
        <form action="inicio.jsp" method="post">
            <input type="submit" value="Return">
        </form>
</body>
</html>