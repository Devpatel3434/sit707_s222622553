package sit707_week2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;


/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author DEV PATEL
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) throws IOException {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver-win/chromedriver-win/chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get("https://www.officeworks.com.au/app/identity/create-account");
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("test1");
		
		/*
		 * Find following input fields and populate with values
		
		WebElement element1 = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element1);
		// Send first name
		element.sendKeys("test");
		 */
		
		WebElement element2 = driver.findElement(By.id("lastname"));
		System.out.println("Found element: " + element2);
		// Send first name
		element2.sendKeys("test2");
		
		WebElement element3 = driver.findElement(By.id("phoneNumber"));
		System.out.println("Found element: " + element3);
		// Send first name
		element3.sendKeys("test3");
		
		WebElement element4 = driver.findElement(By.id("email"));
		System.out.println("Found element: " + element4);
		// Send first name
		element4.sendKeys("lediriv946@otemdi.com");
		
		WebElement element5 = driver.findElement(By.id("password"));
		System.out.println("Found element: " + element5);
		// Send first name
		element5.sendKeys("Test@_51");
		
		WebElement element6 = driver.findElement(By.id("confirmPassword"));
		System.out.println("Found element: " + element6);
		// Send first name
		element6.sendKeys("Test@_61");
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		 WebElement personal = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/form/div[10]/div/button[1]/span[1]/div"));
	     personal.click();
		
	     WebElement create = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/form/div[12]/button"));
	     create.click();
		/*
		 * Take screenshot using selenium API.
		 */
	     File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        Files.copy(screenshotFile, new File("C:\\Users\\61450\\Desktop\\Deakin\\T3\\Task\\SIT707\\screenshoot\\screenshot.png"));
		
		// Sleep a while
		//sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
	public static void Parabank_registration_page(String url) throws IOException {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver-win/chromedriver-win/chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get("https://parabank.parasoft.com/parabank/register.htm");
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("customer.firstName"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("test1");
		
		/*
		 * Find following input fields and populate with values
		
		WebElement element1 = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element1);
		// Send first name
		element.sendKeys("test");
		 */
		
		WebElement element2 = driver.findElement(By.id("customer.lastName"));
		System.out.println("Found element: " + element2);
		// Send first name
		element2.sendKeys("test2");
		
		WebElement element3 = driver.findElement(By.id("customer.address.street"));
		System.out.println("Found element: " + element3);
		// Send first name
		element3.sendKeys("test3");
		
		WebElement element4 = driver.findElement(By.id("customer.address.city"));
		System.out.println("Found element: " + element4);
		// Send first name
		element4.sendKeys("test4");
		
		WebElement element5 = driver.findElement(By.id("customer.address.state"));
		System.out.println("Found element: " + element5);
		// Send first name
		element5.sendKeys("test5");
		
		WebElement element6 = driver.findElement(By.id("customer.address.zipCode"));
		System.out.println("Found element: " + element6);
		// Send first name
		element6.sendKeys("23456");
		
		WebElement element7 = driver.findElement(By.id("customer.phoneNumber"));
		System.out.println("Found element: " + element7);
		// Send first name
		element7.sendKeys("12345678");
		
		WebElement element8 = driver.findElement(By.id("customer.ssn"));
		System.out.println("Found element: " + element8);
		// Send first name
		element8.sendKeys("74948");
		
		WebElement element9 = driver.findElement(By.id("customer.username"));
		System.out.println("Found element: " + element9);
		// Send first name
		element9.sendKeys("lediriv946@otemdi.com");
		
		WebElement element10 = driver.findElement(By.id("customer.password"));
		System.out.println("Found element: " + element10);
		// Send first name
		element10.sendKeys("Test@_51");
		
		WebElement element11 = driver.findElement(By.id("repeatedPassword"));
		System.out.println("Found element: " + element11);
		// Send first name
		element11.sendKeys("Test@_51");
		
		 //WebElement create = driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input"));
	     //create.click();
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		/* WebElement personal = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/form/div[10]/div/button[1]/span[1]/div"));
	     personal.click();
		
	     WebElement create = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/form/div[12]/button"));
	     create.click();
	     /*
		/*
		 * Take screenshot using selenium API.
		 */
	     File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        Files.copy(screenshotFile, new File("C:\\Users\\61450\\Desktop\\Deakin\\T3\\Task\\SIT707\\screenshoot\\screenshot2.png"));
		
		// Sleep a while
		//sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
	
}
