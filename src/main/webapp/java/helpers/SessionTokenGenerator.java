package helpers;

import java.util.Random;

public class SessionTokenGenerator {


    public String generateSessionToken() {

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            sb.append(String.valueOf(random.nextInt(1000)));
        }
        return sb.toString();
    }
}
