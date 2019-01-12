

import org.jtwig.web.servlet.JtwigRenderer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//@WebServlet(name = "MyServlet",  urlPatterns = {"/hello" })
public class MyServlet extends HttpServlet {

    private final JtwigRenderer renderer = JtwigRenderer.defaultRenderer();

    protected void doGet( HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

//        response.getWriter().write("<html><body>It's working!!!</body></html>");

        String title = "MyPage";
        String name = "Twigi";

//        request.setAttribute("My Page", "Twigi");
        renderer.dispatcherFor("/WEB-INF/templates/start.twig").with("title", title).
                with("person", name).
                render(request,response);



    }
}