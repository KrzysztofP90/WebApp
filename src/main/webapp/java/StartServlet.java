import DAO.*;
import org.jtwig.web.servlet.JtwigRenderer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class StartServlet extends HttpServlet {


    private TextContentDAO textContentDAO = new TextContentDAOhibernate();
    private MenuOptionDAO menuOptionDAO = new MenuOptionDAOhibernate();
    private final JtwigRenderer renderer = JtwigRenderer.defaultRenderer();
    private ActiveSessionDAO sessionDAO = new ActiveSessionDAOhibernate();



    protected void doGet( HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {


        String title = "MyPage";
        String name = "Twigi";

        String cssURL = request.getContextPath() + "resources/css/styles.css";

        String jsURL = request.getContextPath() + "resources/main.js";

        String backgroundURL = request.getContextPath() + "resources/background.jpeg";

        String logoURL = request.getContextPath() + "resources/logo.jpg";

        String dwarfURL = request.getContextPath() + "resources/dwarf.png";

        String companyName = "Client's company";

        String[] options = getOptionsArray();

        String[] introduction = getIntroductionArray();

        String[] optionsHeaderDescribe = getOptionsHeaderDescribeArray();

        String footerDescribe = getFooterDescribe();

        renderer.dispatcherFor("/WEB-INF/templates/start.twig").
                with("title", title).
                with("css", cssURL).
                with("scriptURL", jsURL).
                with("person", name).
                with("logoURL", logoURL).
                with("dwarfURL",dwarfURL).
                with("backgroundURL",backgroundURL).
                with("companyName", companyName).
                with("firstOption",options[0]).
                with("secondOption",options[1]).
                with("thirdOption",options[2]).
                with("intro", introduction[0]).
                with("introDescribe", introduction[1]).
                with("firstHeader",optionsHeaderDescribe[0]).
                with("firstDescribe",optionsHeaderDescribe[1]).
                with("secondHeader",optionsHeaderDescribe[2]).
                with("secondDescribe",optionsHeaderDescribe[3]).
                with("thirdHeader",optionsHeaderDescribe[4]).
                with("thirdDescribe",optionsHeaderDescribe[5]).
                with("fourthHeader",optionsHeaderDescribe[6]).
                with("fourthDescribe",optionsHeaderDescribe[7]).
                with("fifthHeader",optionsHeaderDescribe[8]).
                with("fifthDescribe",optionsHeaderDescribe[9]).
                with("footDescribe", footerDescribe).
                render(request,response);

    }

    private String[] getOptionsArray() {
        String[] arr = {menuOptionDAO.getTitleOfMenuOptionById(1), menuOptionDAO.getTitleOfMenuOptionById(2),
                menuOptionDAO.getTitleOfMenuOptionById(3)};
        return arr;
    }

    private String[] getIntroductionArray() {
        String[] arr =  {textContentDAO.getTextContentHeaderByID(1), textContentDAO.getTextContentDescribeByID(1)};
        return arr;
    }

    private String[] getOptionsHeaderDescribeArray() {
        String[] arr = {
                textContentDAO.getTextContentHeaderByID(2), textContentDAO.getTextContentDescribeByID(2),
                textContentDAO.getTextContentHeaderByID(3), textContentDAO.getTextContentDescribeByID(3),
                textContentDAO.getTextContentHeaderByID(4), textContentDAO.getTextContentDescribeByID(4),
                textContentDAO.getTextContentHeaderByID(5), textContentDAO.getTextContentDescribeByID(5),
                textContentDAO.getTextContentHeaderByID(6), textContentDAO.getTextContentDescribeByID(6),
        };
        return arr;
    }

    private String getFooterDescribe() {
        return menuOptionDAO.getTitleOfMenuOptionById(4);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        sessionDAO.clearActiveSessionInDataBase();
        response.sendRedirect("/hello");
    }

}