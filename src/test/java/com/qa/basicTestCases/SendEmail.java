package com.qa.basicTestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.annotations.Test;

public class SendEmail 
{

	@Test
	public void emailTest() throws Exception
	{
		//load the properties
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File("./src/test/java/com/qa/basicTestCases/sendEmail.properties")));
		
		//create a session
		Session session =Session.getInstance(prop,   new javax.mail.Authenticator(){
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(
	                "prathibhap.96@gmail.com", "sASSYgIRL27");// Specify the Username and the PassWord
	        }
	});
		
		
		//create mail
		MimeMessage mail=new MimeMessage(session);
		
		//add recipient 
		InternetAddress to = new InternetAddress("mahe15r@gmail.com");
		mail.addRecipient(RecipientType.TO, to);
		
		mail.setSubject("sending from selenium");
		
		mail.setText("my monkeeee");
		
		//add attachment 
		MimeMultipart multipart = new MimeMultipart();
		MimeBodyPart bp=new MimeBodyPart();
		DataSource ds=new FileDataSource("C:\\Users\\Home\\Downloads\\new resume4.docx");
		bp.setDataHandler(new DataHandler(ds));
		bp.setFileName("my resume");
		multipart.addBodyPart(bp);
		mail.setContent(multipart);
		
		Transport.send(mail);
		
		System.out.println("done");
		
		
	}
	
}
