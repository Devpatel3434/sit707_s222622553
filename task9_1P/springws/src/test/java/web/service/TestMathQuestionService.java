package web.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class TestMathQuestionService {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Path to your chromedriver
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver-win/chromedriver-win/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/");
    }

    @Test
    public void testLoginPage() {
        WebElement loginLink = driver.findElement(By.linkText("Login"));
        loginLink.click();

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("passwd"));
        WebElement dob = driver.findElement(By.id("dob"));

        username.sendKeys("dev");
        password.sendKeys("dev_pass");
        dob.sendKeys("2000-06-24");

        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();

        assertTrue(driver.getCurrentUrl().contains("/q1"));
    }
    
    @Test
    public void testInValidLogin() throws InterruptedException {
        driver.get("http://localhost:8080/login");

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("passwd"));
        WebElement dobField = driver.findElement(By.id("dob"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));

        usernameField.sendKeys("wrong");
        passwordField.sendKeys("dev_pass");
        dobField.sendKeys("2000-06-24");
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Incorrect credentials.')]"));
        // Assert that the error message is displayed
        assert(errorMessage.isDisplayed());
    }

    @Test
    public void testValidQ1Submission() throws InterruptedException {
        driver.get("http://localhost:8080/q1");

        WebElement number1Field = driver.findElement(By.id("number1"));
        WebElement number2Field = driver.findElement(By.id("number2"));
        WebElement resultField = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));

        number1Field.sendKeys("10");
        number2Field.sendKeys("5");
        resultField.sendKeys("15"); // Correct answer: 10 + 5 = 15
        submitButton.click();

        // Adding a 5-second sleep to observe the form submission action
        //Thread.sleep(5000);

        // Add assertions to verify successful submission and redirection
        String currentUrl = driver.getCurrentUrl();
        assert(currentUrl.equals("http://localhost:8080/q2"));
    }

    @Test
    public void testInvalidQ1Submission() throws InterruptedException {
        driver.get("http://localhost:8080/q1");

        WebElement number1Field = driver.findElement(By.id("number1"));
        WebElement number2Field = driver.findElement(By.id("number2"));
        WebElement resultField = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));

        number1Field.sendKeys("10");
        number2Field.sendKeys("5");
        resultField.sendKeys("20"); // Incorrect answer
        submitButton.click();

        // Adding a 5-second sleep to observe the form submission action
        //Thread.sleep(5000);

        // Add assertions to verify error message for incorrect submission
        //WebElement errorMessage = driver.findElement(By.className("message"));
        //assert(errorMessage.getText().equals("Wrong answer, try again."));
        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Wrong answer, try again.')]"));

     // Assert that the error message is displayed
     assert(errorMessage.isDisplayed());
    }
    
    @Test
    public void testEmptyQ1Submission() throws InterruptedException {
        driver.get("http://localhost:8080/q1");

        WebElement number1Field = driver.findElement(By.id("number1"));
        WebElement number2Field = driver.findElement(By.id("number2"));
        WebElement resultField = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));

        number1Field.sendKeys("");
        number2Field.sendKeys("5");
        resultField.sendKeys("20"); 
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Please fill in all fields.')]"));

     // Assert that the error message is displayed
     assert(errorMessage.isDisplayed());
    }

    @Test
    public void testValidQ2Submission() throws InterruptedException {
        driver.get("http://localhost:8080/q2");

        WebElement number1Field = driver.findElement(By.id("number1"));
        WebElement number2Field = driver.findElement(By.id("number2"));
        WebElement resultField = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        
        number1Field.sendKeys("14");
        number2Field.sendKeys("5");
        resultField.sendKeys("9"); 
        submitButton.click();

        String currentUrl = driver.getCurrentUrl();
        assert(currentUrl.equals("http://localhost:8080/q3"));
    }

    @Test
    public void testInvalidQ2Submission() throws InterruptedException {
        driver.get("http://localhost:8080/q2");

        WebElement number1Field = driver.findElement(By.id("number1"));
        WebElement number2Field = driver.findElement(By.id("number2"));
        WebElement resultField = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));

        number1Field.sendKeys("10");
        number2Field.sendKeys("5");
        resultField.sendKeys("10"); // Incorrect answer
        submitButton.click();
        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Wrong answer, try again.')]"));
        // Assert that the error message is displayed
        assert(errorMessage.isDisplayed());
    }
    
    @Test
    public void testEmptyQ2Submission() throws InterruptedException {
        driver.get("http://localhost:8080/q2");

        WebElement number1Field = driver.findElement(By.id("number1"));
        WebElement number2Field = driver.findElement(By.id("number2"));
        WebElement resultField = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));

        number1Field.sendKeys("7");
        number2Field.sendKeys("3");
        resultField.sendKeys(""); 
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Please fill in all fields.')]"));
     // Assert that the error message is displayed
     assert(errorMessage.isDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
