package com.qa.basicTestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVG 
{
	@Test
	public void svgTes() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Home/Downloads/SVG.html");
		driver.manage().window().maximize();
		List<WebElement> list=driver.findElements(By.xpath("//*[name()='svg']//*[local-name()='line']"));
		System.out.println(" total no of elements : "+list.size());
		Actions act = new Actions(driver);
		for(WebElement allList:list)
		{
			
			String ele=allList.getCssValue("stroke");
			System.out.println("before colour : "+ele);
			act.moveToElement(allList).build().perform();
			String ele1=allList.getCssValue("stroke");
			System.out.println("after colour : "+ele1);
			
			WebElement toolTip=allList.findElement(By.xpath("./following-sibling::*[1]/*[2]"));
			
			System.out.println(toolTip.getText());
			
			
		}
		
	}

}
