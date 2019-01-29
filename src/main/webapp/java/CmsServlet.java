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

            String[] optionsHeaderDescribe = preparator.getOptionsHeaderDescribeArray();

            String[] options = preparator.getOptionsArray();

            String footerDescribe = preparator.getFooterDescribe();

            renderer.dispatcherFor("/WEB-INF/templates/cms.twig")
                    .with("css",cssURL)
                    .with("backgroundURL", backgroundURL)
                    .with("headerIntro",introductionArray[0])
                    .with("describeIntro", introductionArray[1])
                    .with("headerWelcome",optionsHeaderDescribe[0]).with("describeWelcome",optionsHeaderDescribe[1])
                    .with("headerAdditional",optionsHeaderDescribe[2]).with("describeAdditional", optionsHeaderDescribe[3])
                    .with("titleOption1", options[0])
                    .with("headerOption1",optionsHeaderDescribe[4]).with("describeOption1",optionsHeaderDescribe[5])
                    .with("titleOption2", options[1])
                    .with("headerOption2",optionsHeaderDescribe[6]).with("describeOption2",optionsHeaderDescribe[7])
                    .with("titleOption3", options[2])
                    .with("headerOption3",optionsHeaderDescribe[8]).with("describeOption3",optionsHeaderDescribe[9])
                    .with("titleFooter", footerDescribe)
                    .render(request, response);
        }
    }
}
