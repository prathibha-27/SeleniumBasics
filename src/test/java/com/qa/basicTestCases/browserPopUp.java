package com.qa.basicTestCases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browserPopUp 
{
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.popuptest.com/goodpopups.html");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Good PopUp #3")).click();
		
		Set<String> handler=driver.getWindowHandles();
		Iterator<String> it=handler.iterator();
		
		String parentWindowId =it.next();
		System.out.println("parent window id is : " +parentWindowId);
	
		String childWindowId=it.next();
		System.out.println("childwindow id is : "+childWindowId);
		driver.switchTo().window(childWindowId);
		Thread.sleep(2000);
		System.out.println("childwindow title is " +driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindowId);
		Thread.sleep(2000);
		System.out.println("parent window title "+driver.getTitle());
		driver.close();
		

	}

}
