package com.qa.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestFixtures {
	
	@BeforeClass
	public void Login() {
		System.out.println("Login Action");
	}

	@AfterClass
	public void Logout() {
		System.out.println("Logout Action");
	}
	
	@BeforeTest
	public void invokeBrowser() {
		System.out.println("Invoke the browser");
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("Close the browser");
	}
	
	@BeforeMethod
	public void checkBalance() {
		System.out.println("Check the balance in the account");
	}
	
	@AfterMethod
	public void acknowledgemen() {
		System.out.println("Print acknowledgement");
	}
}
