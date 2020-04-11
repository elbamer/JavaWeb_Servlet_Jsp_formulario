package sesionDinamic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author elbam
 */
public class Parametros extends HttpServlet {

    public void init(ServletConfig conf)
            throws ServletException {
        super.init(conf);
    }

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Parámetros del servlet desde un formularioggg HTML</h1>");

        Enumeration paramNames = request.getParameterNames();

        //si existe elemento
        while (paramNames.hasMoreElements()) {
            //si en el siguiente puntero hay un elemento
            String paramName = (String) paramNames.nextElement();

            //Mostramos el nombre del parámetro 	
            out.print(paramName + " = ");

            //Cogemos los valores del parámetro
            String[] paramValues = request.getParameterValues(paramName);

            //Miramos si tiene más de un valor 
            if (paramValues.length == 1) {
                //Si tiene un sólo valor, miramos si está vacío o no
                String paramValue = paramValues[0];
                if (paramValue.length() == 0) {
                    out.println("<h4>No has introducido ningun valor </h4><br>");
                } else {
                    out.println(paramValue + "<br>");
                }
            } else {
                //Si tiene más de un sólo valor, los mostramos
                for (int i = 0; i < paramValues.length; i++) {
                    out.println(paramValues[i] + ", ");
                }
                out.println("<br>");
            }
        }

        out.println("</body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
