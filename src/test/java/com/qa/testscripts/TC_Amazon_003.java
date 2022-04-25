package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_Amazon_003 extends TestBase {
	
	// write a code to check all the categories present in the all categories drop down list.
	@Test
	public void categoryItems() {
				
		List<WebElement> options = AmazonOR.getCategory().getOptions();
		
		System.out.println("Total no. of items present in the category list are : " +  options.size());
		
		for(WebElement option:options) {
			Reporter.log(option.getText(),true);
		}
		
	}

}
