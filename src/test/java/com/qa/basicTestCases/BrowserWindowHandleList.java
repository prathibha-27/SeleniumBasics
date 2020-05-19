package com.qa.basicTestCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandleList 
{
		public static void main(String[] args) {

			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();

			driver.get("http://www.popuptest.com/goodpopups.html");
			System.out.println(driver.getWindowHandle());

			
			driver.findElement(By.linkText("Good PopUp #3")).click();
			
			
			Set<String> handles = driver.getWindowHandles();
			
			List<String> windowsList = new ArrayList<String>(handles);
			
			String parentWindowID = windowsList.get(0);
			String childWindowID = windowsList.get(1);

			System.out.println(parentWindowID);
			System.out.println(childWindowID);

			
		}

}
