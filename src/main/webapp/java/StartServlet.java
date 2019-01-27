

import org.jtwig.web.servlet.JtwigRenderer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//@WebServlet(name = "StartServlet",  urlPatterns = {"/hello" })
public class StartServlet extends HttpServlet {

    private final JtwigRenderer renderer = JtwigRenderer.defaultRenderer();

    protected void doGet( HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {



        String title = "MyPage";
        String name = "Twigi";

        String cssURL = request.getContextPath() + "resources/styles.css";

        String jsURL = request.getContextPath() + "resources/main.js";

        String backgroundURL = request.getContextPath() + "resources/background.jpeg";

        String logoURL = request.getContextPath() + "resources/logo.jpg";

        String dwarfURL = request.getContextPath() + "resources/dwarf.png";

        String companyName = "Client's company";

        String[] options = {"1 option","2 option", "3 option", "4 option", "5 option"};

        String[] introduction = {"introHeader", "Introduction to web site!"};

        String[] optionsHeaderDescribe = {"Header1", "This is our first special service for You our Dear Customer! You will" +
                "be satisfied. We are sure about our professionalist !",
                "Header2", "This is our second special service for You our Dear Customer! You will" +
                "be satisfied. We are sure about our professionalist !",
                "Header3", "This is our third special service for You our Dear Customer! You will" +
                "be satisfied. We are sure about our professionalist !",
                "Header4", "This is our fourth special service for You our Dear Customer! You will" +
                "be satisfied. We are sure about our professionalist !",
                "Header5", "This is our fifth special service for You our Dear Customer! You will" +
                "be satisfied. We are sure about our professionalist !"
        };

        String footDescribe = "We invite to cooperate!";

//        request.setAttribute("My Page", "Twigi");
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
                with("fourthOption",options[3]).
                with("fifthOption",options[4]).
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
                with("footDescribe", footDescribe).
                render(request,response);

    }
}