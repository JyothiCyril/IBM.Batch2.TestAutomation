package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_WorkingWithFrames_001 extends TestBase{
	
	@Test(priority=1)
	public void frameByIndex() {
		List<WebElement> allFrames = driver.findElements(By.tagName("frame"));
		int count = allFrames.size();
		
		for(int i=0;i<count;i++) {
			WebDriver frame = driver.switchTo().frame(i);
			Reporter.log(frame.getTitle(),true);
			List<WebElement> allLinks = frame.findElements(By.tagName("a"));
			System.out.println("Total no. of links present on the frame " + i + " are : " +allLinks.size());
			driver.switchTo().defaultContent();
		}		
	}
	
	@Test(priority=2)
	public void frameByName() throws InterruptedException {
		
		WebDriver frame = driver.switchTo().frame("packageFrame");
		Reporter.log(frame.getTitle(),true);
		List<WebElement> allLinks = frame.findElements(By.tagName("a"));
		System.out.println("Total no. of links present on the frame are : " +allLinks.size());
		
		WebElement ele = frame.findElement(By.linkText("Any"));
		if(ele.isDisplayed()) {
			Reporter.log("Element is present",true);
			Reporter.log("Text present on the element is : " + ele.getText(),true);
			Reporter.log("The href value for the element is : " +  ele.getAttribute("href"),true);
			ele.click();
			Thread.sleep(3000);
		}else {
			Reporter.log("Element is not present",true);
		}
		
		driver.switchTo().defaultContent();
		
	}
	
	@Test(priority=3)
	public void frameByElement() {
		
		WebElement ele = driver.findElement(By.xpath("//frame[@title='All Packages']"));
		WebDriver frame = driver.switchTo().frame(ele);
		Reporter.log(frame.getTitle(),true);
		List<WebElement> allLinks = frame.findElements(By.tagName("a"));
		System.out.println("Total no. of links present on the frame are : " +allLinks.size());
		for(WebElement link:allLinks) {
			Reporter.log(link.getText(),true);
		}		
		driver.switchTo().defaultContent();	
		}

}
