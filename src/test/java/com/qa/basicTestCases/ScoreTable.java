package com.qa.basicTestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScoreTable
{
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.espncricinfo.com/series/8634/scorecard/1173053/bangladesh-women-vs-india-women-6th-match-group-a-icc-womens-t20-world-cup-2019-20");
		
		getScoreList(driver,"Shafali Verma");
		getWicketTakerName(driver, "Shafali Verma");
		getScoreList(driver, "RM Ghosh");
		getWicketTakerName(driver, "RM Ghosh");
		
	}
		
		public static void getScoreList(WebDriver driver,String playerName)
		{
			System.out.println(playerName+"\t");
			List<WebElement> ele=driver.findElements(By.xpath("//a[text()='" +playerName+"']"+"//parent::div//following-sibling::div[@class='cell runs']"));
			//System.out.println(ele.size());
			
			for(int i=0;i<ele.size();i++)
			{
				System.out.print(ele.get(i).getText()+"\t");
			}
			System.out.println();
		}
		public static void getWicketTakerName(WebDriver driver,String playerName)
		{
			List<WebElement> ele1=driver.findElements(By.xpath("//a[text()='"+playerName+"']"+"//parent::div//following-sibling::div[@class='cell commentary']"));
			for(WebElement e:ele1)
			{
				System.out.print("Wicket Taker"+e.getText());
			}
			System.out.println();
		}
		
	

	
	
	

}
