package com.qa.basicTestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickConcept {

	@Test
	public void rightClickTest() throws InterruptedException, AWTException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		Thread.sleep(3000);
		WebElement rightClick=driver.findElement(By.cssSelector(".context-menu-one.btn "));
		Actions act= new Actions(driver);
		act.contextClick(rightClick).build().perform();
		
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_T);
		Thread.sleep(2000);
		r.keyRelease(KeyEvent.VK_T);
		Thread.sleep(2000);
		
//		System.out.println(rightClick.getText());
//		List<WebElement> list=driver.findElements(By.cssSelector(".context-menu-list>li"));
//		System.out.println(list.size());
//		WebElement ele=driver.findElement(By.cssSelector(".context-menu-list>li:nth-of-type(4)"));
//		ele.click();
//		System.out.println(ele.getText());
	}
}
