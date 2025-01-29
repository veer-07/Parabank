package veer.selenium.selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestComponents.BaseTests;
import veer.selenium.selenium.POM.OpenNewAcc;
import veer.selenium.selenium.POM.POM;
import veer.selenium.selenium.POM.Registartion;

public class BaseT extends BaseTests {


		@Test
		public void RegistrUser() throws InterruptedException, IOException {
			BaseTests.initialization();
			driver.get("https://parabank.parasoft.com/parabank/index.htm");

			Registartion r=new Registartion(driver);
			r.register("Veera","12345*");
	}
		@Test
		public void InCorrPass() throws InterruptedException, IOException {
			String Uname="Veera";
			String Pass="12345*";
			BaseTests.initialization();
			driver.get("https://parabank.parasoft.com/parabank/index.htm");
			POM c=new POM(driver);
			c.login(Uname,Pass);
			String Actual= driver.findElement(By.cssSelector(".error")).getText();
//			String expected=Actual.equalsIgnoreCase(Actual);
			System.out.println(Actual);
//			Assert.assertEquals("The username and password could not be verified.", Actual);
			Assert.assertEquals(Actual,"The username and password could not be verified.");
//			Assert.assertEquals( "The username and password could not be verified.",Text.equalsIgnoreCase(Text));
			 
	}
	
		@Test
		public void LoginFieldBlank() throws InterruptedException, IOException {
			BaseTests.initialization();
			
			driver.get("https://parabank.parasoft.com/parabank/index.htm");
			POM c=new POM(driver);
			c.login("","");
			String Actual= driver.findElement(By.cssSelector(".error")).getText();
			Assert.assertEquals(Actual,"Please enter a username and password.");
	}
		
		@Test
		public void LoginPassMask() throws InterruptedException, IOException {
						String Pass="12345*";
						BaseTests.initialization();

			driver.get("https://parabank.parasoft.com/parabank/index.htm");
			POM c=new POM(driver);
			c.login("sggsh","12345*");
			String enteredPassword = driver.findElement(By.xpath("//input[@name='password']")).getAttribute("name");

	        // Password should not be visible as plain text
	        if (enteredPassword.equals(Pass)) {
	            System.out.println("Test Failed: Password is visible as plain text");
	        } else {
	            System.out.println("Test Passed: Password is properly masked");
	        }
	}
		
		
		@Test
		public void ACCOverview() throws InterruptedException, IOException {
			String Uname="Veera";
			String Pass="12345*";
 
			BaseTests.initialization();
			Thread.sleep(1000);
			POM c=new POM(driver);
			c.login(Uname,Pass);
			
			String a=driver.findElement(By.cssSelector(".title")).getText();
			
			boolean z=a.equalsIgnoreCase("Accounts Overview");
			System.out.println(z);
			c.AccInfo();
		}
		 
}


 
