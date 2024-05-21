package web.service;

/**
 * Business logic to handle login functions.
 * 
 * @author dev.
 */

public class LoginService {

    public static boolean login(String username, String password, String dob) {
        if (username == null || password == null || dob == null) {
            return false;
        }

        // New logic: Check if username contains only alphanumeric characters
        if (!username.matches("[a-zA-Z0-9]+")) {
            return false;
        }

        // Existing logic
        if ("dev".equals(username) && "dev_pass".equals(password) && "2000-06-24".equals(dob)) {
            return true;
        }

        return false;
    }
}

