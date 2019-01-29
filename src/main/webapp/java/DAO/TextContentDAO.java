package DAO;

public interface TextContentDAO {

    String getTextContentHeaderByID(int id);

    String getTextContentDescribeByID(int id);

    void updateTextContentHeaderById(int id, String value);

    void updateTextContentDescribeById(int id, String value);
}
