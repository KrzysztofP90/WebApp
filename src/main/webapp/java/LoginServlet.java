import DAO.ActiveSessionDAO;
import DAO.ActiveSessionDAOhibernate;
import DAO.ClientDAO;
import DAO.ClientDAOhibernate;
import helpers.CookieVerifycator;
import helpers.SessionTokenGenerator;
import org.jtwig.web.servlet.JtwigRenderer;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {


    private final JtwigRenderer renderer = JtwigRenderer.defaultRenderer();
    private ClientDAO clientDAO = new ClientDAOhibernate();
    private CookieVerifycator cookieVerificator = new CookieVerifycator();
    private SessionTokenGenerator generator = new SessionTokenGenerator();
    private ActiveSessionDAO activeSessionDAO = new ActiveSessionDAOhibernate();



    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        Cookie[] cookieArray = request.getCookies();

        if (cookieVerificator.verifyCookie(cookieArray)) {
            response.sendRedirect("/cms");
        }
        else {
            String cssURL = request.getContextPath() + "resources/css/login.css";

            String jsURL = request.getContextPath() + "resources/main.js";

            String backgroundURL = request.getContextPath() + "resources/background.jpeg";


            renderer.dispatcherFor("/WEB-INF/templates/login.twig")
                    .with("scriptURL", jsURL)
                    .with("backgroundURL",backgroundURL)
                    .with("css",cssURL)
                    .render(request, response);
        }
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {


        String loginFromUser = request.getParameter("login");
        String passwordFromUser = request.getParameter("password");

        String correctLogin = clientDAO.getCorrectLoginFromDataBase();
        String correctPassword = clientDAO.getCorrectPasswordFromDataBase();

        if (loginFromUser.equals(correctLogin) && passwordFromUser.equals(correctPassword)) {

            String token = generator.generateSessionToken();
            activeSessionDAO.addSessionTokenToDataBase(token);
            Cookie accessToken = new Cookie("SessionId", token);
            response.addCookie(accessToken);
            response.sendRedirect("/cms");
        }
        else {
            response.sendRedirect("/login");
        }

    }
}
