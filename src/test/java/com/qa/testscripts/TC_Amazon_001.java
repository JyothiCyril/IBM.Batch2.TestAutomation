package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Amazon_001 {
	
//	Test scenario:
//
//		1. Open the browser
//		2. Launch the URL for amazon.in --> web application loaded
//		3. Select Books as category
//		4. Type da vinci code in search text field
//		5. Click on the magnifier button
//		6. Check if all the items related to search term are loaded
//		7. Close the browser


	public static void main(String[] args) throws InterruptedException {
		//1. Open the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// 2. Launch the URL for amazon.in 
		driver.get("https://www.amazon.in/"); // amazon web page running on chrome browser
		
		//3. Select Books as category
		
		Select Category = new Select(driver.findElement(By.name("url")));
		Category.selectByVisibleText("Books");
		Thread.sleep(3000);
		
		// 4. Type da vinci code in search text field
		WebElement searchTextField = driver.findElement(By.id("twotabsearchtextbox"));
		searchTextField.sendKeys("Da vinci code");
		Thread.sleep(3000);
		
		//5. Click on the magnifier button
		WebElement MagnifierBtn = driver.findElement(By.id("nav-search-submit-button"));
		MagnifierBtn.click();
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if(title.contains("Da vinci code")) {
			System.out.println("Item is searched");
		}else {
			System.out.println("Item is not searched");
		}
		
		List<WebElement> AllItems = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println("Total no. of items loaded are :" + AllItems.size());
		
		for(WebElement item:AllItems) {
			System.out.println(item.getText());
		}
		
		// 7. Close the browser
		driver.close();
		
		
	}

}
