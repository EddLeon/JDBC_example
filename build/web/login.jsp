<%-- 
    Document   : login
    Created on : 1/11/2015, 10:43:46 PM
    Author     : eddy_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <jsp:useBean id = "datos" scope= "session"
                     class = "mensajeria.DBhandler" />
        <form action="formHandler" method="post">
            <input type="hidden" name="origin" value="login">            
            <br/><br/>
            <b>Usuario: </b><input type="text" name="username"><br/><br/>
            <b>Password: </b><input type="text" name="password"><br/>
            <br/>
            <input type="submit" name="Submit" value="Send">
            <input type="reset" value="Reset">
        </form>
    </body>
</html>
