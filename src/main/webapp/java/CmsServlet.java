import helpers.CookieVerificator;
import org.jtwig.web.servlet.JtwigRenderer;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CmsServlet extends HttpServlet {

    private final JtwigRenderer renderer = JtwigRenderer.defaultRenderer();
    private CookieVerificator cookieVerificator = new CookieVerificator();


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie[] cookieArray = request.getCookies();


        if (cookieVerificator.verifyCookie(cookieArray)) {
            String cssURL = request.getContextPath() + "resources/css/login.css";

            String jsURL = request.getContextPath() + "resources/main.js";

            String backgroundURL = request.getContextPath() + "resources/background.jpeg";

            renderer.dispatcherFor("/WEB-INF/templates/cms.twig").
                    render(request, response);
        }
        else {
            renderer.dispatcherFor("/WEB-INF/templates/denyAccess.twig").render(request,response);
        }
    }
}
