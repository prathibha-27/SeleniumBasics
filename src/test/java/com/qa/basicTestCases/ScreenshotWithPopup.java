package com.qa.basicTestCases;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotWithPopup 
{
	
	public static void main(String[] args) throws InterruptedException, AWTException, IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.naukri.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		String mainwin=driver.getWindowHandle();
		Set<String> set=driver.getWindowHandles();
		Thread.sleep(2000);
		System.out.println(set.size());
		Iterator<String> itr =set.iterator();
		while(itr.hasNext())
		{
			String child=itr.next();
			if(!mainwin.equals(child))
			{
				driver.switchTo().window(child);
				System.out.println(driver.switchTo().window(child).getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(mainwin);
		Thread.sleep(3000);
		driver.findElement(By.id("block")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("wdgt-file-upload")).click();
		Thread.sleep(3000);
		Robot r=new Robot();
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect = new Rectangle(d);
		BufferedImage im=r.createScreenCapture(rect);
		ImageIO.write(im, "png", new File("./Demo1.png"));
		Thread.sleep(4000);
		driver.close();

		
	}

}
