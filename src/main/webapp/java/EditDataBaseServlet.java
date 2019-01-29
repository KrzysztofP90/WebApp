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



        renderer.dispatcherFor("/WEB-INF/templates/edited.twig")
                .render(request, response);


    }

}
