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

public class SVGTags{
@Test
public void SvgTagTest() throws InterruptedException
{
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver = new FirefoxDriver();
	driver.get("file:///C:/Users/Home/Downloads/SVG.html");
	List<WebElement> allele=driver.findElements(By.xpath("//*[name()='svg']//*[local-name()='line']"));
	Reporter.log("total no of elements :" + allele.size(),true);
	Actions act= new Actions(driver);
	for(WebElement ele:allele)
	{
		String e = ele.getCssValue("stroke");
		Reporter.log("before colour : "+e,true);
		act.moveToElement(ele).perform();
		Thread.sleep(3000);
		String s = ele.getCssValue("stroke");
		Reporter.log("after colour : "+s,true);
		Reporter.log("================",true);
		
		WebElement toolTip = ele.findElement(By.xpath("./following-sibling::*[1]/*[2]"));
		Reporter.log(toolTip.getText(),true);
	}

}}
