package com.qa.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_Amazon_005 extends TestBase{
	
	@Test
	public void NewUserReg() throws InterruptedException, IOException {
		WebElement ele = AmazonOR.getAccountandLists();
		
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();		
		Thread.sleep(2000);		
		AmazonOR.getstarthereLink().click();
		Thread.sleep(2000);
		boolean contains = driver.getTitle().contains("Registration");
		if(contains) {
			sAssert.assertTrue(contains);
			Reporter.log("The user is landed on registration page", true);
			AmazonOR.getYourNameTextField().sendKeys(prop.getProperty("name"));
			Thread.sleep(2000);
			AmazonOR.getPhNumTextField().sendKeys(prop.getProperty("mNum"));
			AmazonOR.getemailTextField().sendKeys(prop.getProperty("eMail"));
			Thread.sleep(2000);
		}else {
			captureScreenshot(driver,"NewUserReg");
			sAssert.assertTrue(contains);
			Reporter.log("The user is not landed on registration page", true);
		}		
	}

}
