import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CMsServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cssURL = request.getContextPath() + "resources/styles.css";

        String jsURL = request.getContextPath() + "resources/main.js";

        String backgroundURL = request.getContextPath() + "resources/background.jpeg";


    }
}
