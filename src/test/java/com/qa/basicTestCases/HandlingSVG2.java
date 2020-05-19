package com.qa.basicTestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingSVG2 
{
	@Test
	public void SVGTest() throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/Users/Home/Downloads/svgdemo.html");
		List<WebElement> allEle=driver.findElements(By.xpath("//*"));
		Reporter.log("total no of elements :" + allEle.size(),true);
		int count = 0;
		Actions act= new Actions(driver);
		for(WebElement ele:allEle)
		{
			String tagName=ele.getTagName();
			if(tagName.equalsIgnoreCase("circle"))
			{
				count++;
				
			}
			
		}
		Reporter.log("no of circles"+count,true);
		List<WebElement> red=driver.findElements(By.xpath(("//*[@fill-opacity='1']")));
		int count1=0;
		for(WebElement Red:red)
		{
			count1++;
		}
		Reporter.log("no of red is : "+count1,true);
		
		List<WebElement> green=driver.findElements(By.xpath(("//*[@fill-opacity='0.5']")));
		int count2=0;
		for(WebElement Green:green)
		{
			count2++;
		}
		Reporter.log("no of green is : "+count2,true);
		
	}

}
