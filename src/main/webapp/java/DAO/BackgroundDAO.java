package DAO;

import java.util.List;

public interface BackgroundDAO {

    String[] getAlliassesFromDataBase();

    String getNameByAllias(String allias);

    String getNameOfActiveBackground();

    void setUnactiveBackgroundByAllias(String allias);

    void setActiveBackgroundByAllias(String allias);

    String getAlliasOfActiveBackground();
}
