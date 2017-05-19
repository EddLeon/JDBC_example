<%-- 
    Document   : Controlador
    Created on : 1/11/2015, 09:18:55 AM
    Author     : eddy_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controlador</title>

    </head>
    <body>
        <script>

            var getUrlParameter = function getUrlParameter(sParam) {
                var sPageURL = decodeURIComponent(window.location.search.substring(1)),
                        sURLVariables = sPageURL.split('&'),
                        sParameterName,
                        i;
                for (i = 0; i < sURLVariables.length; i++) {
                    sParameterName = sURLVariables[i].split('=');
                    if (sParameterName[0] === sParam) {
                        return sParameterName[1] === undefined ? true : sParameterName[1];
                    }
                }
            };
            var op = getUrlParameter('operacion');
            switch (op) {
                case 'compose':
                    //< a href = "envio.html" >
                    location.replace("envio.jsp");
                    break;
                case 'read':
                    location.replace("lectura.jsp");
                    break;
            }
        </script>
    </body>
</html>
