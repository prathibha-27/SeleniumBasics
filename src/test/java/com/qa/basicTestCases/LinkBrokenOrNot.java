package com.qa.basicTestCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

public class LinkBrokenOrNot 
{
	@Test
	public void LinkTest() throws IOException
	{
		URL url= new URL("https://funds.qsp.ca");//link is broken = 403
	
		//URL url=new URL("https://www.google.com");//link is not broken = 200
		//URL url=new URL("https://www.gmail.com");
		
		HttpURLConnection con= (HttpURLConnection) url.openConnection();
		System.out.println(con.getResponseCode());
		System.out.println(con.getResponseMessage());
		
	}
	

}
