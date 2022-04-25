package com.qa.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_001 {

	public static void main(String[] args) throws InterruptedException {
		// define the environment variable to locate the driver binary in the local system
		//System.setProperty("webdriver.chrome.driver", "D:\\Tools\\SeleniumDrivers\\chromedriver.exe");
		// ChromeDriver constructor is instantiated into the local variable.
		//System.setProperty("webdriver.edge.driver", "D:\\Tools\\SeleniumDrivers\\msedgedriver.exe");

		//WebDriverManager.edgedriver().setup();
		//WebDriver eDriver = new EdgeDriver();
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/"); // load the url on the browser instance .
		// loc to test the functionality should be written after the get() and before the close()
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle()); // fetch the title of the page and returns the string format.
		
		System.out.println(driver.getCurrentUrl()); // fetch the url at the run session. return string
		
		System.out.println(driver.getWindowHandle()); // Window ID of the current browser instance. return String
		
		//driver.getWindowHandles(); // returns the window id of all the window / tab opened on the current browser.
		
		//driver.switchTo().window(window id); // one tab to other tab
		//driver.switchTo().alert(); // switch to alert window
		//driver.switchTo().frame(); // switch to frame with in a page with by index/name/WebElemnt etc
		driver.navigate().to("https://www.google.com/");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);	
		
	//	driver.findElement(locator); // reach the element matching a locator on the webpage. return first match element based on locator
	//	driver.findElements(locatos); // fetch all the matching element present on the web page.
		
		
		driver.close(); // close the browser



	}

}
