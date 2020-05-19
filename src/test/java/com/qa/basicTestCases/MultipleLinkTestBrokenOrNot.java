package com.qa.basicTestCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleLinkTestBrokenOrNot 
{
	@Test
	public void   LinkTest() throws IOException, InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.selenium.dev/downloads/");
		List<WebElement> allLink =driver.findElements(By.xpath("//a"));
		for(WebElement link:allLink)
		{
			System.out.println("link text is : "+link.getText());
			String href=link.getAttribute("href");
			System.out.println("links are : "+href);
			try {
				URL url=new URL(href);
				HttpURLConnection con=(HttpURLConnection)url.openConnection();
				int code = con.getResponseCode();
				
				if(code==200) {
					System.out.println("link is not broken");
					System.out.println("response code is : "+con.getResponseCode());
				}
				else
				{
					System.out.println("link is broken ");
					System.out.println("response message is: "+con.getResponseMessage());
				}
				System.out.println("=========================");
				
				
			} catch (MalformedURLException e) {
				System.out.println("invalid url");
				System.out.println("==========");
			}
			
		}
		Thread.sleep(2000);
		driver.close();
		
	}

}
