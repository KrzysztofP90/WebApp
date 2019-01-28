import helpers.CookieVerifycator;
import helpers.TextDataPreparator;
import org.jtwig.web.servlet.JtwigRenderer;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CmsServlet extends HttpServlet {

    private final JtwigRenderer renderer = JtwigRenderer.defaultRenderer();
    private CookieVerifycator cookieVerificator = new CookieVerifycator();
    private TextDataPreparator preparator = new TextDataPreparator();


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie[] cookieArray = request.getCookies();


        if (cookieVerificator.verifyCookie(cookieArray)) {
            String cssURL = request.getContextPath() + "resources/css/cms.css";


            String backgroundURL = request.getContextPath() + "resources/background.jpeg";

            String[] introductionArray = preparator.getIntroductionArray();

            System.out.println(introductionArray[0]  + "!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println(introductionArray[1] + "!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            renderer.dispatcherFor("/WEB-INF/templates/cms.twig")
                    .with("css",cssURL)
                    .with("backgroundURL", backgroundURL)
                    .with("headerIntro",introductionArray[0])
                    .with("describeIntro", introductionArray[1]).
                    render(request, response);
        }
    }
}
