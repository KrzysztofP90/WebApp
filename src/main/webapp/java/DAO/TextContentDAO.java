package DAO;

public interface TextContentDAO {

    String getTextContentHeaderByID(int id);

    String getTextContentDescribeByID(int id);

    void updateTextContentHeaderById(long id, String value);

    void updateTextContentDescribeById(long id, String value);
}
