package com.qa.basicTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CharSequenceInString 
{
	@Test
	public void CharSequenceTest()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		WebElement userName=driver.findElement(By.name("username"));
		
//		StringBuilder user=new StringBuilder()
//				.append("prathibha")
//				.append(" ")
//				.append("soon to be automation tester");
//		userName.sendKeys(user);
		
		StringBuilder username = new StringBuilder()
				.append("prathibha")
				.append(" ")
				.append("no one can stop me")
				.append(" to reach heights");
		String space= " ";
		
		StringBuffer buf=new StringBuffer()
				.append("come on");
		userName.sendKeys(username,space,buf,Keys.TAB);
		
				
	}

}
