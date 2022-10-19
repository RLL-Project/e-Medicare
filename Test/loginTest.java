package com.loginTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

public class loginTest {
	@Test
	public void login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Ahammed Fayas T L\\Desktop\\simplielearn-java\\Simplielearn/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://localhost:4200");

		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.className("actionBtn"));

		username.clear();
		username.click();
		username.sendKeys("fayas");
		Thread.sleep(3000);
		password.clear();
		password.click();
		password.sendKeys("fayas@1234");
		// driver.switchTo().alert().dismiss();
		Thread.sleep(3000);
		login.click();

		String actualUrl = "https://localhost:8081/dash.html";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
	}
}
