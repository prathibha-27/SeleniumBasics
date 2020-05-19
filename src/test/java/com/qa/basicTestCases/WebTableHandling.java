package com.qa.basicTestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandling 
{
	
	@Test
	public void WebTableTest()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		//*[@id="customers"]/tbody/tr[4]/td[1]
		
		//*[@id="customers"]/tbody/tr[2]/td[2]
		//*[@id="customers"]/tbody/tr[3]/td[2]
		//*[@id="customers"]/tbody/tr[4]/td[2]
		
		String beforeXpath_Company="//*[@id='customers']/tbody/tr[";
		String afterXpath_Company="]/td[1]";
		
		String beforeXpath_Contact="//*[@id='customers']/tbody/tr[";
		String afterXpath_Contact="]/td[2]";
		
		List<WebElement> list=driver.findElements(By.xpath("//*[@id='customers']//tr"));
		int count=list.size()-1;
		System.out.println(list.size());
		
		
		List<WebElement> all=driver.findElements(By.xpath("//*[@id='customers']//td"));
		System.out.println(all.size());
		
		List<WebElement> all1=driver.findElements(By.xpath("//*[@id='customers']//tr[3]/td"));
		System.out.println(all1.size());
		
//		
//		for(int i=2;i<=count;i++)
//		{
//			
//				String actualXpath=beforeXpath_Company+i+afterXpath_Company;
//				String companyName=driver.findElement(By.xpath(actualXpath)).getText();
//				System.out.println(companyName);
//				
//				String actualXpath_contact=beforeXpath_Contact+i+afterXpath_Contact;
//				String contact=driver.findElement(By.xpath(actualXpath_contact)).getText();
//				System.out.println(contact);
//		}
		
		for(int i=0; i<all.size();i++)
		{
			String text=all.get(i).getText();
			System.out.println(text);
		}
	}

}
