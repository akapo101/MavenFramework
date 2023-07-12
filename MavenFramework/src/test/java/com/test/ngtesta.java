package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ngtesta {
 @Test
	public void Test1 () throws InterruptedException
	{

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		Thread.sleep(9000);
		WebElement hov= driver.findElement(By.xpath("//div[text()='Login']"));
		Actions act = new Actions(driver);
		act.moveToElement(hov).perform();
	}
	

}
