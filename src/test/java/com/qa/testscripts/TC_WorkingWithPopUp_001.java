package com.qa.testscripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_WorkingWithPopUp_001 extends TestBase {
	
	
	@Test
	public void popupsEx() throws InterruptedException, IOException {
		
		if(driver.getCurrentUrl().contains("register")) {
			Reporter.log("User is on registration page");
			Thread.sleep(3000);
			WebElement logo = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/img[1]"));
			System.out.println(logo.isDisplayed());
			if(logo.isDisplayed()) {
				File Source = logo.getScreenshotAs(OutputType.FILE);
				File Target = new File(System.getProperty("user.dir")+"/Screenshots/"+"RediffLogo"+".png");		
				FileUtils.copyFile(Source, Target);
							
			}
		}
		
		WebElement fullNameTxtField = driver.findElement(By.xpath("//tbody/tr[3]/td[3]/input[1]"));
		fullNameTxtField.sendKeys("23456"); 
		fullNameTxtField.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		// pop up window triggers.
		Alert alert = driver.switchTo().alert();
		Reporter.log(alert.getText(),true);
		alert.accept();
		Thread.sleep(3000);		
		fullNameTxtField.clear();
		Thread.sleep(3000);
		fullNameTxtField.sendKeys("kim smith");
		Thread.sleep(3000);
		WebElement emailIDTxtField = driver.findElement(By.xpath("//tbody/tr[7]/td[3]/input[1]"));
		emailIDTxtField.sendKeys("test@test.com");
		Thread.sleep(3000);
	}

}
