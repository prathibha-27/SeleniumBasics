package com.qa.basicTestCases;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CropImage 
{
	@Test
	public void cropImage() throws IOException, InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.selenium.dev/downloads/");
		WebElement logo=driver.findElement(By.xpath("//*[@class='logo logo-large']"));
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("./demoC.png"));
		
		//find the Location(x,y axis) and size(height and width)
		int x=logo.getLocation().x;
		int y=logo.getLocation().y;
		int w=logo.getSize().getWidth();
		int h=logo.getSize().getHeight();
		
		System.out.println("x : "+x);
		System.out.println("y : "+y);
		System.out.println("h : "+h);
		System.out.println("w : "+w);
		
		BufferedImage originalimg=ImageIO.read(new File("./demoC.png"));
		BufferedImage subimage=originalimg.getSubimage(x, y, w, h);
		
		ImageIO.write(subimage, "png", new File("./demoD.png"));
		
		BufferedImage actualImage=ImageIO.read(new File("./demoC.png"));
		BufferedImage expectedImage =ImageIO.read(new File("./demoD.png"));
		
		DataBuffer aimgpix=actualImage.getData().getDataBuffer();
		DataBuffer eximgpix=expectedImage.getData().getDataBuffer();
		
		int countA=aimgpix.getSize();
		int countB=eximgpix.getSize();
		
		int matchcount=0;
		int count=0;
		if(countA>countB)
		{
			count=countB;
		}
		else
		{
			count=countA;
		}
		for(int i=0;i<count;i++)
		{
		if(aimgpix.getElem(i)==eximgpix.getElem(i))
		{
			matchcount++;
		}
		}
		
		int percent=(matchcount*100)/countB;
		System.out.println("percent"+percent);
		Thread.sleep(2000);
	}

}
