package sit707_week4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
/**
 * Tests functions in LoginForm.
 * @author DEV PATEL
 */
public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "s222622553";
		System.out.println("Student ID: " + studentId);
		Assert.assertNotNull("Student ID =", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Dev Patel";
		System.out.println("Student Name: " + studentName);
		Assert.assertNotNull("Student name =", studentName);
	}
	
	@Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, null, null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	/*
	 * Write more test functions below.
	 */
	@Test
	public void testEmptyUsernameEmptyPasswordDontCareValidationCode() {
	    System.out.println("[Empty username, Empty password, Correct validation code]");
	    LoginStatus status = LoginForm.login(null, null, null);
	    System.out.println("Status: " + status);
	    Assert.assertFalse("Login should fail", status.isLoginSuccess());
	    Assert.assertEquals("Error message should indicate empty username", "Empty Username", status.getErrorMsg());
	}

	@Test
	public void testEmptyUsernameWrongPasswordDontCareValidationCode() {
	    System.out.println("[Empty username, Wrong password, Correct validation code]");
	    LoginStatus status = LoginForm.login(null, "DEV_Patel", null);
	    System.out.println("Status: " + status);
	    Assert.assertFalse("Login should fail", status.isLoginSuccess());
	    Assert.assertEquals("Error message should indicate empty username", "Empty Username", status.getErrorMsg());
	}

	@Test
	public void testEmptyUsernameCorrectPasswordDontCareValidationCode() {
	    System.out.println("[Empty username, Correct password, Correct validation code]");
	    LoginStatus status = LoginForm.login(null, "ahsan_pass", null);
	    System.out.println("Status: " + status);
	    Assert.assertFalse("Login should fail", status.isLoginSuccess());
	    Assert.assertEquals("Error message should indicate empty username", "Empty Username", status.getErrorMsg());
	}

	@Test
	public void testWrongUsernameEmptyPasswordDontCareValidationCode() {
	    System.out.println("[Wrong username, Empty password, Correct validation code]");
	    LoginStatus status = LoginForm.login("Dev", null, null);
	    System.out.println("Status: " + status);
	    Assert.assertFalse("Login should fail", status.isLoginSuccess());
	    Assert.assertEquals("Error message should indicate empty password", "Empty Password", status.getErrorMsg());
	}

	@Test
	public void testWrongUsernameWrongPasswordDontCareValidationCode() {
	    System.out.println("[Wrong username, Wrong password, Correct validation code]");
	    LoginStatus status = LoginForm.login("Dev", "DEV_Patel", null);
	    System.out.println("Status: " + status);
	    Assert.assertFalse("Login should fail", status.isLoginSuccess());
	    Assert.assertEquals("Error message should indicate credential mismatch", "Credential mismatch", status.getErrorMsg());
	}

	@Test
	public void testWrongUsernameCorrectPasswordDontCareValidationCode() {
	    System.out.println("[Wrong username, Correct password, Correct validation code]");
	    LoginStatus status = LoginForm.login("Dev", "ahsan_pass", null);
	    System.out.println("Status: " + status);
	    Assert.assertFalse("Login should fail", status.isLoginSuccess());
	    Assert.assertEquals("Error message should indicate credential mismatch", "Credential mismatch", status.getErrorMsg());
	}

	@Test
	public void testCorrectUsernameEmptyPasswordDontCareValidationCode() {
	    System.out.println("[Correct username, Empty password, Correct validation code]");
	    LoginStatus status = LoginForm.login("ahsan", null, null);
	    System.out.println("Status: " + status);
	    Assert.assertFalse("Login should fail", status.isLoginSuccess());
	    Assert.assertEquals("Error message should indicate empty password", "Empty Password", status.getErrorMsg());
	}

	@Test
	public void testCorrectUsernameWrongPasswordDontCareValidationCode() {
	    System.out.println("[Correct username, Wrong password, Correct validation code]");
	    LoginStatus status = LoginForm.login("ahsan", "DEV_Patel", null);
	    System.out.println("Status: " + status);
	    Assert.assertFalse("Login should fail", status.isLoginSuccess());
	    Assert.assertEquals("Error message should indicate credential mismatch", "Credential mismatch", status.getErrorMsg());
	}

	@Test
	public void testCorrectUsernameCorrectPasswordNoValidationCode() {
	    System.out.println("[Correct username, Correct password, No validation code]");
	    LoginStatus status = LoginForm.login("ahsan", "ahsan_pass", null );
	    System.out.println("Status: " + status);
	    Assert.assertFalse("Login should fail", status.isLoginSuccess());
	    Assert.assertEquals("Error message should indicate empty validation code", "Empty validation code", status.getErrorMsg());
	}
	
	
	@Test
	public void testCorrectUsernameCorrectPasswordWrongValidationCode() {
	    System.out.println("[Correct username, Correct password, Wrong validation code]");
	    LoginStatus status = LoginForm.login("ahsan", "ahsan_pass", "123");
	    System.out.println("Status: " + status);
	    Assert.assertFalse("Login should fail", status.isLoginSuccess());
	    Assert.assertEquals("Error message should indicate credential mismatch", "Wrong validation code", status.getErrorMsg());
	}

	
	@Test
	public void testCorrectUsernameCorrectPasswordCorrectValidationCode() {
	    System.out.println("[Correct username, Correct password, Correct validation code]");
	    LoginStatus status = LoginForm.login("ahsan", "ahsan_pass","123456");
	    System.out.println("Status: " + status);
	    Assert.assertTrue("Login should succeed", status.isLoginSuccess());
	    Assert.assertEquals("Validation code should be returned", "123456", status.getErrorMsg());
	}
	
	


	



}