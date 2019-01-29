import DAO.MenuOptionDAO;
import DAO.MenuOptionDAOhibernate;
import DAO.TextContentDAO;
import DAO.TextContentDAOhibernate;
import org.jtwig.web.servlet.JtwigRenderer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class EditDataBaseServlet extends HttpServlet {


    private final JtwigRenderer renderer = JtwigRenderer.defaultRenderer();
    private MenuOptionDAO menuOptionDAO = new MenuOptionDAOhibernate();
    private TextContentDAO textContentDAO = new TextContentDAOhibernate();


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        updateIntroductionTextContentInDataBase(request);

        updateOptionsTextContentInDataBase(request);

        updateMenuOptionsInDataBase(request);

        renderer.dispatcherFor("/WEB-INF/templates/edited.twig")
                .render(request, response);
    }


    private void updateIntroductionTextContentInDataBase(HttpServletRequest request) {

        String headerIntro = request.getParameter("headerIntro");
        textContentDAO.updateTextContentHeaderById(1,headerIntro);
        String describeIntro = request.getParameter("describeIntro");
        textContentDAO.updateTextContentDescribeById(1,describeIntro);

        String headerWelcome = request.getParameter("headerWelcome");
        textContentDAO.updateTextContentHeaderById(2,headerWelcome);
        String describeWelcome = request.getParameter("describeWelcome");
        textContentDAO.updateTextContentDescribeById(2,describeWelcome);

        String headerAdditional = request.getParameter("headerAdditional");
        textContentDAO.updateTextContentHeaderById(3,headerAdditional);
        String describeAdditional = request.getParameter("describeAdditional");
        textContentDAO.updateTextContentDescribeById(3, describeAdditional);
    }


    private void updateOptionsTextContentInDataBase(HttpServletRequest request) {

        String headerOption1 = request.getParameter("headerOption1");
        textContentDAO.updateTextContentHeaderById(4,headerOption1);
        String describeOption1 = request.getParameter("describeOption1");
        textContentDAO.updateTextContentDescribeById(4,describeOption1);

        String headerOption2 = request.getParameter("headerOption2");
        textContentDAO.updateTextContentHeaderById(5,headerOption2);
        String describeOption2 = request.getParameter("describeOption2");
        textContentDAO.updateTextContentDescribeById(5,describeOption2);

        String headerOption3 = request.getParameter("headerOption3");
        textContentDAO.updateTextContentHeaderById(6,headerOption3);
        String describeOption3 = request.getParameter("describeOption3");
        textContentDAO.updateTextContentDescribeById(6,describeOption3);
    }


    private void updateMenuOptionsInDataBase(HttpServletRequest request) {

        String titleOption1 = request.getParameter("titleOption1");
        menuOptionDAO.updateMenuOptionTitleById(1,titleOption1);
        String titleOption2 = request.getParameter("titleOption2");
        menuOptionDAO.updateMenuOptionTitleById(2,titleOption2);
        String titleOption3 = request.getParameter("titleOption3");
        menuOptionDAO.updateMenuOptionTitleById(3,titleOption3);
        String titleFooter = request.getParameter("titleFooter");
        menuOptionDAO.updateMenuOptionTitleById(4,titleFooter);
    }

}
