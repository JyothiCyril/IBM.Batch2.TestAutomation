package com.qa.testng;

import org.testng.annotations.Test;

public class TC_FundTransfer extends TestFixtures{
	
	@Test(priority=1, invocationCount=3)
	public void fundtransferNEFT() {
		System.out.println("Fund transfer NEFT");
	}
	
	@Test(priority=2)
	public void fundtransferIMPS() {
		System.out.println("Fund transfer IMPS");
	}
	
	@Test(priority=3, enabled=false)
	public void fundtransferInternational() {
		System.out.println("Fund transfer International");
	}

}
