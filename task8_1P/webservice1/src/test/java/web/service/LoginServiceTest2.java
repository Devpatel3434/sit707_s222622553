package web.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LoginServiceTest2 {

    @Test
    public void testLoginSuccess() {
        assertTrue(LoginService.login("dev", "dev_pass", "2000-06-24"));
    }

    @Test
    public void testLoginFailureInvalidUsername() {
        assertFalse(LoginService.login("invalid", "dev_pass", "2000-06-24"));
    }

    @Test
    public void testLoginFailureInvalidPassword() {
        assertFalse(LoginService.login("dev", "invalid_pass", "2000-06-24"));
    }

    @Test
    public void testLoginFailureInvalidDob() {
        assertFalse(LoginService.login("dev", "dev_pass", "2005-07-07"));
    }

    @Test
    public void testLoginFailureNullUsername() {
        assertFalse(LoginService.login(null, "dev_pass", "2000-06-24"));
    }

    @Test
    public void testLoginFailureNullPassword() {
        assertFalse(LoginService.login("dev", null, "2000-06-24"));
    }

    @Test
    public void testLoginFailureNullDob() {
        assertFalse(LoginService.login("dev", "dev_pass", null));
    }

    @Test
    public void testLoginFailureEmptyUsername() {
        assertFalse(LoginService.login("", "dev_pass", "2000-06-24"));
    }

    @Test
    public void testLoginFailureEmptyPassword() {
        assertFalse(LoginService.login("dev", "", "2000-06-24"));
    }

    @Test
    public void testLoginFailureEmptyDob() {
        assertFalse(LoginService.login("dev", "dev_pass", ""));
    }

    @Test
    public void testLoginFailureIncorrectDateFormat() {
        assertFalse(LoginService.login("dev", "dev_pass", "24-06-2000"));
    }
    
    @Test
    public void testLoginFailureNonAlphanumericUsername() {
        assertFalse(LoginService.login("!@#$%", "dev_pass", "2000-06-24"));
    }
    
}
