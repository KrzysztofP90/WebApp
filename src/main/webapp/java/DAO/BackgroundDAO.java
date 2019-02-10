package DAO;

import java.util.List;

public interface BackgroundDAO {

    List<String> getAlliassesFromDataBase();

    String getNameByAllias(String allias);

    String getNameOfActiveBackground();
}
