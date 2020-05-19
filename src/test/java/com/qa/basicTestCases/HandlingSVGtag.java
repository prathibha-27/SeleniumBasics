package com.qa.basicTestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingSVGtag 
{
	@Test
	public void SvgTagTest() throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/Users/Home/Downloads/SVG.html");
		List<WebElement> allElements=driver.findElements(By.xpath("//*"));
		Reporter.log("no of elements = "+allElements.size(),true);
	
		int count=0;
		Actions act= new Actions(driver);
		for(WebElement ele:allElements)
		{
			String tagName=ele.getTagName();
			if(tagName.equals("line"))
			{
				count++;
				String bfcolor=ele.getCssValue("stroke");
				Reporter.log("before color "+bfcolor,true);
				act.moveToElement(ele).perform();
				String afcolor=ele.getCssValue("stroke");
				Reporter.log("after color"+afcolor,true);
				Reporter.log("==================",true);
				WebElement toolTip=ele.findElement(By.xpath("./following-sibling::*[1]/*[2]"));
				Reporter.log(toolTip.getText(),true);
				Reporter.log("==================",true);
			
			
			}
			
		}
		Reporter.log("no of lines present "+count,true);
		
	}

}
