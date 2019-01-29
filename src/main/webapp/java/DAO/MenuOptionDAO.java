package DAO;

public interface MenuOptionDAO {

    String getTitleOfMenuOptionById(int id);

    void updateMenuOptionTitleById(int id, String value);
}
