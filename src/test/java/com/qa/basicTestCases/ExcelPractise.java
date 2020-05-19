package com.qa.basicTestCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelPractise
{
	@DataProvider
	public Object[][] getData() throws InvalidFormatException, IOException
	{
		Object[][] data=ExcelUtil.getTestData("sheet1");
		return data;
	}
	@Test(dataProvider="getData")
	public void excelTest(String firstname, String lastname,String address,String email)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.findElement(By.xpath("//input[@type='text' and @placeholder='First Name']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@type='text' and @placeholder='Last Name']")).sendKeys(lastname);
		driver.findElement(By.cssSelector(".col-md-8.col-xs-8>.form-control")).sendKeys(address);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
		
		driver.findElement(By.xpath("//input[@name='radiooptions' and @value='FeMale']")).click();
		driver.findElement(By.xpath("//input[@id='checkbox1' and @value='Cricket']")).click();
		WebElement ele=driver.findElement(By.id("countries"));
		Select sel= new Select(ele);
		sel.selectByVisibleText("Afghanistan");
		driver.findElement(By.cssSelector(".select2-selection")).click();
		
		
	}
	

}
