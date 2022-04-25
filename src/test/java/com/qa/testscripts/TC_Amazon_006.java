package com.qa.testscripts;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_Amazon_006 extends TestBase{
	
	@Test(priority=1)
	public void scrollByVertical() throws InterruptedException {
		for(int i=0; i<5;i++) {
			Js.executeScript("window.scrollBy(0,500)"); // Top to down
			Thread.sleep(3000);
		}
		
		for(int i=5; i>=1;i--) {
			Js.executeScript("window.scrollBy(0,-500)"); // Top to down
			Thread.sleep(3000);
		}
		
	}

	@Test(priority=2)
	public void scrollByElementPrensent() throws InterruptedException {
		
		WebElement ele = AmazonOR.getCareersLink();
		Js.executeScript("arguments[0].scrollIntoView", ele);
		Thread.sleep(3000);
		ele.click();
		Thread.sleep(3000);
		boolean contains = driver.getCurrentUrl().contains("jobs");
		
		if(contains) {
			Reporter.log("The user is landed on Careers page",true);
		}
	}
}
