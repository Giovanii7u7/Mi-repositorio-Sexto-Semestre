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
        <!-- <a href="Demoservlet.java">Ir a Demoservlet</a>
        <form method="get" action="Demoservlet">
            <br> <label for="Nombre">Nombre</label> <br>

            <input type="text" name="nombre">
            <br>
            <label for="Apellido">Apellido</label> <br>
            <input type="text" name="apellido"> <br>
            <input type="submit" value="Enviar"> <br>
        </form> -->


        <h1>Segundo formulario de operaciones</h1>
        <!-- SEGUNDO FORMULARIO -->
        <form method="get" action="CalculatorServlet">
            <br> <label for="Num1">Numero 1</label> <br>
            <input type="text" name="num1">
            <br>
            <label for="Num2">Numero 2</label> <br>

            <input type="text" name="num2"> <br>
          

            <label for="operador">Operador:</label> <br>

            <select name="operador">
                <option value="+">Suma</option>
                <option value="-">Resta</option>
                <option value="*">Multiplicacion</option>
                <option value="/">Division</option>
            </select> <br>
            <input type="submit" value="Calcular">

        </form>
    </body>

    </html>