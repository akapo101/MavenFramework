package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultiTest {
	
	WebDriver driver;  //global variable

	@BeforeClass
	public void Initalization() throws InterruptedException {
		 driver = new ChromeDriver(); // run Time polymorhism

		driver.get("https://www.amazon.com");

		driver.manage().window().maximize();// maximize the window

		System.out.println(driver.getTitle());

		Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void SelectDropDown() throws InterruptedException {

		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));

		Select sel = new Select(dropdown);

		sel.selectByIndex(3);// Low priority

		sel.selectByValue("search-alias=digital-music"); // medium priority

		sel.selectByVisibleText("Luggage"); // High priority

		// driver.quit();
	}

	@Test(priority = 2)
	public void AdvanceDropDown() throws InterruptedException {

		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));

		Select sel = new Select(dropdown);

		List<WebElement> li = sel.getOptions();

		System.out.println(li.size());

		for (int i = 0; i < li.size(); i++) {

			li.get(i).click();
			System.out.println(li.get(i).getText());
		}
		// button[contains(text(),'Find address']
		// driver.quit();

	}

	@AfterClass
	public void CleanUp() {
		driver.quit();
	}

}
