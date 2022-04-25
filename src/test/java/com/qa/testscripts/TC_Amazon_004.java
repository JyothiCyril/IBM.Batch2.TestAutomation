package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_Amazon_004 extends TestBase{
	
	@Test
	public void footerLinks() throws IOException {
		
		List<WebElement> allFooterLinks = AmazonOR.getAllFooterLinks();
		int itemsCount = allFooterLinks.size();	
		System.out.println("Total no. of links present on the footer section of the page are : " + itemsCount);
		
		sAssert.assertEquals(itemsCount, 52);
		captureScreenshot(driver,"footerLinks");
		// lines below will not be executed if the assert in the previous line fails.
		for(WebElement link:allFooterLinks) {
			Reporter.log(link.getText(),true);
		}
		sAssert.assertAll();
	}

}
