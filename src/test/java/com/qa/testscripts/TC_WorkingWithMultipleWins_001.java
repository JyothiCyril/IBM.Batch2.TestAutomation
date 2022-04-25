package com.qa.testscripts;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_WorkingWithMultipleWins_001 extends TestBase{
	
	@Test
	public void multipleWindows() throws InterruptedException {
		WebElement ele = driver.findElement(By.className("appClose"));
		if(ele.isDisplayed()) {
			ele.click();
		}		
		
		driver.findElement(By.linkText("CITIGROUP.COM")).click(); // 2nd window opened
		Thread.sleep(3000);
		driver.findElement(By.linkText("TERMS AND CONDITIONS")).click(); // 3rd Window opened
		Thread.sleep(3000);
		Set<String> WindID = driver.getWindowHandles(); // get the window id of all the window opened on the browser instance.// set of Strings
		
		Iterator<String> iter = WindID.iterator();
		while(iter.hasNext()) {
			String windID = iter.next();
			WebDriver window = driver.switchTo().window(windID);
			Reporter.log(window.getTitle(),true);
			List<WebElement> allLinks = window.findElements(By.tagName("a"));
			System.out.println("Total no. of links present on the window is : " + allLinks.size());
			for(WebElement links:allLinks) {
				Reporter.log(links.getAttribute("href"),true);
			}
		}
		
	}

}
