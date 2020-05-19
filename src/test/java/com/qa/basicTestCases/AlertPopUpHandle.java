package com.qa.basicTestCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopUpHandle 
{
	//JavaScript Alert PopUp
	
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		//to click on sign in
		driver.findElement(By.name("proceed")).click();
		
		Alert alert = driver.switchTo().alert();
		//System.out.println(alert.getText());
		
		//for validation point of view of alert message
		String text=alert.getText();
		
		System.out.println(text);
		
		if(text.equals("Please enter a valid user name"))
		{
			System.out.println("correct alert message");
		}
		else
		{
			System.out.println("incorrect alert message");
		}
		//to click on ok button
		alert.accept();
				//to click on cancel button
		//alert.dismiss();
		driver.quit();
	}
	
	

}
