package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginServiceTest {
    
    private void sleep(long sec) {
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    } 
    
    @Test
    public void testLoginSuccess() {
        System.setProperty(
                "webdriver.chrome.driver", 
                "C:/chromedriver-win/chromedriver-win/chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();        
        System.out.println("Driver info: " + driver);
        
        driver.navigate().to(
                "file:///C:/Users/61450/Desktop/Deakin/T3/Task/SIT707/Task%208/8.1P-resources/pages/login.html");
        sleep(5);
        
        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("dev");
        
        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("dev_pass");
        
        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("24-06-2000");
        
        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();
        
        sleep(5);
        
        String title = driver.getTitle();
        System.out.println("Title: " + title);
        
        Assert.assertEquals(title, "success");
        
        driver.close();
    }
    
    @Test
    public void testLoginFailureInvalidUsername() {
        System.setProperty(
                "webdriver.chrome.driver", 
                "C:/chromedriver-win/chromedriver-win/chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();        
        System.out.println("Driver info: " + driver);
        
        driver.navigate().to(
                "file:///C:/Users/61450/Desktop/Deakin/T3/Task/SIT707/Task%208/8.1P-resources/pages/login.html");
        sleep(5);
        
        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("invalid");
        
        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("dev_pass");
        
        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("24-06-2000");
        
        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();
        
        sleep(5);
        
        String title = driver.getTitle();
        System.out.println("Title: " + title);
        
        Assert.assertEquals(title, "fail");
        
        driver.close();
    }
    
    @Test
    public void testLoginFailureInvalidPassword() {
        System.setProperty(
                "webdriver.chrome.driver", 
                "C:/chromedriver-win/chromedriver-win/chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();        
        System.out.println("Driver info: " + driver);
        
        driver.navigate().to(
                "file:///C:/Users/61450/Desktop/Deakin/T3/Task/SIT707/Task%208/8.1P-resources/pages/login.html");
        sleep(5);
        
        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("dev");
        
        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("invalid_pass");
        
        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("24-06-2000");
        
        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();
        
        sleep(5);
        
        String title = driver.getTitle();
        System.out.println("Title: " + title);
        
        Assert.assertEquals(title, "fail");
        
        driver.close();
    }
    
    @Test
    public void testLoginFailureInvalidDob() {
        System.setProperty(
                "webdriver.chrome.driver", 
                "C:/chromedriver-win/chromedriver-win/chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();        
        System.out.println("Driver info: " + driver);
        
        driver.navigate().to(
                "file:///C:/Users/61450/Desktop/Deakin/T3/Task/SIT707/Task%208/8.1P-resources/pages/login.html");
        sleep(5);
        
        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("dev");
        
        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("dev_pass");
        
        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("07-07-2005"); // Invalid date of birth
        
        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();
        
        sleep(5);
        
        String title = driver.getTitle();
        System.out.println("Title: " + title);
        
        Assert.assertEquals(title, "fail");
        
        driver.close();
    }
}

