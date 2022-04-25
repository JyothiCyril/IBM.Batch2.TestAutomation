package com.qa.testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.pages.AmazonPages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	WebDriver driver;
	AmazonPages AmazonOR;
	SoftAssert sAssert;
	FileInputStream fileLoc;
	Properties prop;
	JavascriptExecutor Js;

	@Parameters({"Browser","Url"})
	@BeforeClass
	public void setUp(String Browser,String Url) throws IOException {
		fileLoc = new FileInputStream("D:\\Selenium Training\\HyDigit - Batch 2 - Fy'23\\IBM.Batch2.TestAutomation\\src\\test\\java\\com\\qa\\testdata\\details.properties");
		prop = new Properties();
		prop.load(fileLoc);
		
		if(Browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(Browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else if(Browser.equalsIgnoreCase("Ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}else if(Browser.equalsIgnoreCase("Firefo")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		sAssert = new SoftAssert();
		Js = (JavascriptExecutor)driver;
		AmazonOR = new AmazonPages(driver);
		driver.get(Url);
		driver.manage().window().maximize();
		
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}


	public void captureScreenshot(WebDriver driver, String tName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot)driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File Target = new File(System.getProperty("user.dir")+"/Screenshots/"+tName+".png");
		FileUtils.copyFile(Source, Target);
	}

}
