

import org.jtwig.web.servlet.JtwigRenderer;

import javax.servlet.RequestDispatcher;
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

//        response.getWriter().write("<html><body><h1>It's working!!!</h1></body></html>");

        String title = "MyPage";
        String name = "Twigi";

        String cssURL = request.getContextPath() + "resources/styles.css";

        String jsURL = request.getContextPath() + "resources/main.js";

        String logoURL = request.getContextPath() + "resources/logo.png";

        String companyName = "Client's company";

//        request.setAttribute("My Page", "Twigi");
        renderer.dispatcherFor("/WEB-INF/templates/start.twig").
                with("title", title).
                with("css", cssURL).
                with("scriptURL", jsURL).
                with("person", name).
                with("logoURL", logoURL).
                with("companyName", companyName).
                render(request,response);




        /// send css by servlet ???


//        RequestDispatcher dispatcher = request.getRequestDispatcher(
//                "/WEB-INF/stylesheet/styles.css");
//
//        dispatcher.include(request, response);


    }
}