package DAO;

public interface ActiveSessionDAO {

    String getSessionTokenFromDataBase();

    void clearActiveSessionInDataBase();

    void addSessionTokenToDataBase(String token);
}
