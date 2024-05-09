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
        <h1>Formulario Usuario y contraseña</h1>
        <form method="post" action="LoginServlet">
            <h1>Iniciar sesión</h1>
            <label for="usuario">Usuario:</label> <br>
            <input type="text" name="usuario"> <br>

            <label for="contrasena">Contraseña:</label> <br>
            <input type="password" name="contrasena"> <br>

            <label><input type="checkbox" name="recordar"> Recordarme</label> <br>

            <input type="submit" value="Iniciar sesión">
        </form>

        <!-- Redireccionar al servlet al cargar para que verifique la cookie-->
        <script>
            window.onload = function () {
                window.location.href = "http://localhost:8080/tw-igsw/LoginServlet";
            };
        </script>
    </body>

    </html>