package com.qa.basicTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CssSelecor 
{
	@Test
	public void cssSelector()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.get("https://classic.crmpro.com/login.cfm");
		driver.navigate().to("https://classic.crmpro.com/login.cfm");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[class='span2'][name='username']")).sendKeys("batchautomation");
		driver.findElement(By.cssSelector("input[class='span2'][name='password']")).sendKeys("Test@12345");
		driver.findElement(By.cssSelector("input.btn")).click();
		
	}

}
