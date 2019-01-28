package helpers;

import DAO.MenuOptionDAO;
import DAO.MenuOptionDAOhibernate;
import DAO.TextContentDAO;
import DAO.TextContentDAOhibernate;

public class TextDataPreparator {


    private TextContentDAO textContentDAO = new TextContentDAOhibernate();
    private MenuOptionDAO menuOptionDAO = new MenuOptionDAOhibernate();


    public String[] getOptionsArray() {
        String[] arr = {menuOptionDAO.getTitleOfMenuOptionById(1), menuOptionDAO.getTitleOfMenuOptionById(2),
                menuOptionDAO.getTitleOfMenuOptionById(3)};
        return arr;
    }

    public String[] getIntroductionArray() {
        String[] arr =  {textContentDAO.getTextContentHeaderByID(1), textContentDAO.getTextContentDescribeByID(1)};
        return arr;
    }

    public String[] getOptionsHeaderDescribeArray() {
        String[] arr = {
                textContentDAO.getTextContentHeaderByID(2), textContentDAO.getTextContentDescribeByID(2),
                textContentDAO.getTextContentHeaderByID(3), textContentDAO.getTextContentDescribeByID(3),
                textContentDAO.getTextContentHeaderByID(4), textContentDAO.getTextContentDescribeByID(4),
                textContentDAO.getTextContentHeaderByID(5), textContentDAO.getTextContentDescribeByID(5),
                textContentDAO.getTextContentHeaderByID(6), textContentDAO.getTextContentDescribeByID(6),
        };
        return arr;
    }

    public String getFooterDescribe() {
        return menuOptionDAO.getTitleOfMenuOptionById(4);
    }
}
