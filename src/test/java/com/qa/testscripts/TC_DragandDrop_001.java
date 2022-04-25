package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC_DragandDrop_001 extends TestBase{
	
	@Test
	public void dragdrop() throws InterruptedException {
		driver.switchTo().frame(0);
		
		Actions act = new Actions(driver);
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		act.dragAndDrop(source, target).build().perform();		
		Thread.sleep(3000);
	}

}
