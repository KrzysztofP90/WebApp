package helpers;

import javax.servlet.http.Cookie;

public class CookieVerificator {


    public boolean verifyCookie(Cookie[] cookieArray) {

        boolean verifyOk = false;

        if (cookieArray != null) {

            for (Cookie cookie : cookieArray) {
                if (cookie.getValue().equals("59348593859345353")) {
                    verifyOk = true;
                }
            }
        }
            return verifyOk;
    }
}
