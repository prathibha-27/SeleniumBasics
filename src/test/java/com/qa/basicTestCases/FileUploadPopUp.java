package com.qa.basicTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadPopUp 
{

	public static void main(String[] args) throws InterruptedException, Exception
	{
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver= new ChromeDriver();
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver= new FirefoxDriver();
		
		driver.get("http://cgi-lib.berkeley.edu/ex/fup.html");
		
		//type=file should be present then only it will work for uploading
		//driver.findElement(By.name("upfile")).sendKeys("C:\\Users\\Home\\gitbasic\\DemoRepo");
		
		//using autoit
		WebElement button=driver.findElement(By.name("upfile"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", button);
		Runtime.getRuntime().exec("C:\\Autoit\\FileUpload1.exe");
	
		
	}

}
