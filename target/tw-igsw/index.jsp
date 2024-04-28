<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
    <!DOCTYPE html>
    <html lang="es-mx">

    <head>
        <meta charset="UTF-8">
        <title>Titulo de tu página</title>
    </head>

    <body>
        <h2>Hello World!!!</h2>
        <h3>Licenciatura en Informática</h3>
        <h4>Tecnologías Web 1</h4>
        <a href="Demoservlet.java">Ir a Demoservlet</a>
        <form method="get" action="Demoservlet">
            <br> <label for="Nombre">Nombre</label> <br>

            <input type="text" name="nombre">
            <br>
            <label for="Apellido">Nombre</label> <br>
            <input type="text" name="apellido"> <br>
            <input type="submit" value="Enviar"> <br>

        </form>
    </body>

    </html>