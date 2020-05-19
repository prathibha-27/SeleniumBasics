package com.qa.basicTestCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksTest 
{
	@Test
	public void brokenLinkTest() throws MalformedURLException  
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://www.deadlinkcity.com/");
//		driver.get("https://www.crmpro.com/");
//		
//		driver.findElement(By.name("username")).sendKeys("batchautomation");
//		driver.findElement(By.name("password")).sendKeys("Test@12345");
//		driver.findElement(By.cssSelector("input.btn ")).submit();
		
	//	driver.switchTo().frame("mainpanel");
		List<WebElement> allList=driver.findElements(By.tagName("a"));
		allList.addAll(driver.findElements(By.tagName("img")));
		System.out.println(" total links " + allList.size());
		
		List<WebElement> activeLinks=new ArrayList<WebElement>();
		
		for(int i=0; i<allList.size();i++)
		{
			System.out.println(allList.get(i).getAttribute("href"));
			if(allList.get(i).getAttribute("href")!=null && (!allList.get(i).getAttribute("href").contains("mailto")))
			{
				activeLinks.add(allList.get(i));
			}
		
		}
		System.out.println("active links : "+activeLinks.size());
		
		for(int j=0;j<activeLinks.size();j++)
		{
			URL url = new URL(activeLinks.get(j).getAttribute("href"));
			
			HttpURLConnection connection;
			try {
				connection = (HttpURLConnection)url.openConnection();
			if(connection.getResponseCode()==200)
			{
				System.out.println("link is not broken");
				System.out.println(activeLinks.get(j).getAttribute("href")+ " ---> "+connection.getResponseMessage());
			}
			else if(connection.getResponseCode()>=400)
			{
				System.out.println("link is broken");
				System.out.println(activeLinks.get(j).getAttribute("href")+"-->"+connection.getResponseMessage());
			}
			System.out.println("======");
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		
	}

}
