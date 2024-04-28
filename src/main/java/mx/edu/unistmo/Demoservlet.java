package mx.edu.unistmo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

//El urlPátters significa desde donde se puede acceder a este servlet, en este casoo puedes poonerlo desde /* que es la forma correcta 
//para que se pueda mostrar dedde todos lados*/
@WebServlet(name= "Demoservlet", urlPatterns = "/")
public class Demoservlet extends HttpServlet {

   
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Demo</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello! "+ nombre +" "+ apellido+"</h1>");
        
        out.println("<h2>Informática</h2>");
        out.println("<p>This is a demo servlet.</p>");
        out.println("</body>");
        out.println("</html>");
    }
}