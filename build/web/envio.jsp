<html>
    <head>
        <title>envio</title>
    </head>

    <body>
    <center>
        <h1>Nuevo Mensaje</h1>
        <form action="formHandler">
            <input type="hidden" name="origin" value="envio">            
            <br/><br/>
            <b>Datos del mensaje:</b><br/><br/>
            Para: <input type="text" name="para"><br/>
            <br/>
            De : <input type="text" name="de"><br/>
            <br/>
            Contenido <br/>
            <textarea name="contenido">
            </textarea>
            <hr/><br/>
            <input type="submit" name="Submit" value="Send">
            <input type="reset" value="Reset">
        </form>
    </center>
</body>
</html>