package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.AmazonPages;
import com.qa.utility.ExcelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Amazon_002 extends TestBase{

	@Test(dataProvider="getData")
	public void searchItem(String Category, String ItemName) throws IOException {
	
		boolean contains = driver.getTitle().contains("Amazon");
		if(contains) {
			Reporter.log("The user is on amazon home page",true);
			sAssert.assertTrue(contains);

			AmazonOR.getCategory().selectByVisibleText(Category); // 1st field
			AmazonOR.getSearchTxtField().clear();
			AmazonOR.getSearchTxtField().sendKeys(ItemName); // 2nd field
			AmazonOR.getMagnifierBtn().click();

			boolean contains2 = driver.getTitle().contains(ItemName);
			if(contains2) {
				Reporter.log("The title have the search item");
				sAssert.assertTrue(contains2);

				List<WebElement> allItems = AmazonOR.getAllItems();
				System.out.println("Total no. of items fetched are : " + allItems.size());
				for(WebElement item:allItems) {
					Reporter.log(item.getText(),true);
				}
			}else {
				captureScreenshot(driver,"searchItem");
				Reporter.log("The title do not have search item",true);
				sAssert.assertTrue(contains2);
			}
		}else {
			captureScreenshot(driver,"searchItem");
			sAssert.assertTrue(contains);
			Reporter.log("The user is not on amazon home page",true);
		}
		sAssert.assertAll();
		
	}
	
	@DataProvider
	public String[][] getData() throws IOException {
		
		String xFile="D:\\Selenium Training\\HyDigit - Batch 2 - Fy'23\\IBM.Batch2.TestAutomation\\src\\test\\java\\com\\qa\\testdata\\TestData.xlsx";
		String xSheet="Sheet1";
		
		int rowCount = ExcelUtility.getRowCount(xFile, xSheet);
		int cellCount = ExcelUtility.getCellCount(xFile, xSheet, rowCount);
		
		String[][] data = new String[rowCount][cellCount];
		
		for(int i=1; i<=rowCount ; i++) {
			for(int j=0; j<cellCount ; j++) {
				data[i-1][j] = ExcelUtility.getCellData(xFile, xSheet, i, j);
			}
		}
		
//		Object[][] data = new Object[3][2];
//		//category
//		data[0][0] = "Books";
//		data[1][0] = "Electronics";
//		data[2][0] = "Furniture";
//		
//		//itemname
//		data[0][1] = "Da Vinci Code";
//		data[1][1] = "Mobile Phones";
//		data[2][1] = "Wooden Tables";
//		
		return data;
	}

}
