package mx.edu.unistmo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = "/")
public class LoginServlet extends HttpServlet {


    //para cuando la página carga automáticamente
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

    //para cuando el usuario intenta iniciar sesión

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");

        // Validación 
        boolean autenticacionExitosa = "user".equals(usuario) && "password".equals(contrasena);

        if (autenticacionExitosa) {
            // Si el inicio de sesión es exitoso y el usuario seleccionó "recordarme"

            if (request.getParameter("recordar") != null && request.getParameter("recordar").equals("on")) {
             
                Cookie cookie = new Cookie("usuario", usuario);
                cookie.setMaxAge(60 * 60 * 24 * 365); 
                response.addCookie(cookie);
             
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
            //AQUI


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
