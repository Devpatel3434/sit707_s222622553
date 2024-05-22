package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService2 {
	
/////////////// Login Test Cases//////////////////////
    @Test
    public void testValidLogin() {
        Assert.assertTrue(LoginService.login("dev", "dev_pass", "2000-06-24"));
    }

    @Test
    public void testInvalidUsername() {
        Assert.assertFalse(LoginService.login("invalid_user", "dev_pass", "2005-05-07"));
    }

    @Test
    public void testInvalidPassword() {
        Assert.assertFalse(LoginService.login("dev", "invalid_pass", "2000-06-24"));
    }

    @Test
    public void testEmptyFields() {
        Assert.assertFalse(LoginService.login("", "", ""));
    }

    
    
///////////////////// Q1 Test Cases////////////////////////
    
    
    @Test
    public void testTrueAdd() {
        Assert.assertEquals( MathQuestionService.q1Addition("3", "4"), 7, 0);
    }

    @Test
    public void testAddNumber1Empty() {
        Assert.assertNull(MathQuestionService.q1Addition("", "2"));
    }

    @Test
    public void testAddNumber2Empty() {
        Assert.assertNull(MathQuestionService.q1Addition("1", ""));
    }

    @Test
    public void testAddBothEmpty() {
        Assert.assertNull(MathQuestionService.q1Addition("", ""));
    }

    @Test
    public void testAddInvalidNumber1() {
        Assert.assertNull(MathQuestionService.q1Addition("abc", "2"));
    }

    @Test
    public void testAddInvalidNumber2() {
        Assert.assertNull(MathQuestionService.q1Addition("1", "xyz"));
    }
    
    
///////////////////// Q2 Test Cases////////////////////////

    @Test
    public void testTrueSubtraction() {
        Assert.assertEquals( MathQuestionService.q2Subtraction("9", "4"), 5, 0);
    }

    @Test
    public void testSubtractionNumber1Empty() {
        Assert.assertNull(MathQuestionService.q2Subtraction("", "2"));
    }

    @Test
    public void testSubtractionNumber2Empty() {
        Assert.assertNull(MathQuestionService.q2Subtraction("3", ""));
    }

    @Test
    public void testSubtractionBothEmpty() {
        Assert.assertNull(MathQuestionService.q2Subtraction("", ""));
    }

    @Test
    public void testSubtractionInvalidNumber1() {
        Assert.assertNull(MathQuestionService.q2Subtraction("abc", "2"));
    }

    @Test
    public void testSubtractionInvalidNumber2() {
        Assert.assertNull(MathQuestionService.q2Subtraction("3", "xyz"));
    }
    


}
