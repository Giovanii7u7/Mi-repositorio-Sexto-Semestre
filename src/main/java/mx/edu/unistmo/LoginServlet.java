package mx.edu.unistmo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = "/")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Verificar si hay una cookie de sesión
        Cookie[] cookies = request.getCookies();
        boolean autenticado = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("usuario") && cookie.getValue().equals("user")) {
                    autenticado = true;
                    break;
                }
            }
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Verificación de autenticación</title>");
        out.println("</head>");
        out.println("<body>");

        if (autenticado) {
            // Si el usuario está autenticado, mostrar mensaje de éxito
            out.println("<h1>Autenticación Exitosa</h1>");
        } else {
            // Si el usuario no está autenticado, mostrar mensaje de falla
            out.println("<h1>Autenticación Fallida</h1>");
        }

        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");

        // Validación de usuario y contraseña (con hardcode)
        boolean autenticacionExitosa = "user".equals(usuario) && "password".equals(contrasena);

        if (autenticacionExitosa) {
            // Si el inicio de sesión es exitoso y el usuario seleccionó "recordarme"

            if (request.getParameter("recordar") != null && request.getParameter("recordar").equals("on")) {
                // Crear una cookie y establecer su tiempo de vida
                Cookie cookie = new Cookie("usuario", usuario);
                cookie.setMaxAge(60 * 60 * 24 * 365); // Duración de un año en segundos
                response.addCookie(cookie);
                // Imprimir mensaje de éxito con el nombre de usuario

                // Imprimir mensaje de éxito con el nombre de usuario
                PrintWriter out = response.getWriter();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Autenticación Exitosa</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Autenticación Exitosa</h1>");
                out.println("<p>Bienvenido, " + usuario + "</p>");
                out.println("</body>");
                out.println("</html>");

            }

        } else {
            // Enviar respuesta de autenticación fallida
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>No se pudo iniciar sesión</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Fallo</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
