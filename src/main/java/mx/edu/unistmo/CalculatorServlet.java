package mx.edu.unistmo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "CalculatorServlet", urlPatterns = "/")
public class CalculatorServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String numero1HTML = request.getParameter("num1");
        String numero2HTML = request.getParameter("num2");
        String operador = request.getParameter("operador");

        Double resultado = 0.0;
        Double num1 = Double.parseDouble(numero1HTML);
        Double num2 = Double.parseDouble(numero2HTML);

        switch (operador) {
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1- num2;
                break;
            case "*":
                resultado = num1 * num2;
                break;
            case "/":
                resultado  = num1 /num2;
                break;

            default:
                break;
        }

        response.setCharacterEncoding("UTF-8");
       
         PrintWriter out = response.getWriter();
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Resultado</title>");
         out.println("</head>");
         out.println("<body>");
         out.println("<h1>Resultado: " + resultado + "</h1>");
         out.println("</body>");
         out.println("</html>");
    }

}
