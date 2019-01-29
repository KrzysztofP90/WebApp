package DAO;

public interface MenuOptionDAO {

    String getTitleOfMenuOptionById(int id);

    void updateMenuOptionTitleById(long id, String value);
}
