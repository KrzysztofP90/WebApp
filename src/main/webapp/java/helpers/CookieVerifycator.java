package helpers;

import DAO.ActiveSessionDAO;
import DAO.ActiveSessionDAOhibernate;

import javax.servlet.http.Cookie;

public class CookieVerifycator {

    private ActiveSessionDAO activeSessionDAO = new ActiveSessionDAOhibernate();

    public boolean verifyCookie(Cookie[] cookieArray) {

        boolean verifyOk = false;

        String activeSessionToken = activeSessionDAO.getSessionTokenFromDataBase();

        if (cookieArray != null) {

            for (Cookie cookie : cookieArray) {
                if (cookie.getValue().equals(activeSessionToken)) {
                    verifyOk = true;
                }
            }
        }
            return verifyOk;
    }
}
