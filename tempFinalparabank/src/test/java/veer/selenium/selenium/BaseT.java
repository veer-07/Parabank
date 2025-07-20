package veer.selenium.selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import API_Parabank.chats.ExcelDataProvider;
import testComponents.BaseTests;
import veer.selenium.selenium.POM.ApplyLoan;
import veer.selenium.selenium.POM.OpenNewAcc;
import veer.selenium.selenium.POM.POM;
import veer.selenium.selenium.POM.Registartion;

public class BaseT extends BaseTests {


		@Test(dataProvider="excelData", dataProviderClass = ExcelDataProvider.class)
		public void ARegistrUser(String name, String lname,String address,String cities,String state,String zipcode,String phone, String ssns, String uname, String Password,String con) throws InterruptedException, IOException  {
			BaseTests.initialization();
			driver.get("https://parabank.parasoft.com/parabank/index.htm");

			Registartion r=new Registartion(driver);
			r.register(name,lname,address,cities,state,zipcode,phone,ssns,uname,Password,con);
						 
	}
		@Test
		public void BInCorrPass() throws InterruptedException, IOException {
			String Uname="Veern";
			String Pass="12345*";
//			String Uname="Veergd";
//			String Pass="12345*";
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
//			closeBrowser();
	}
	
		@Test
		public void CLoginFieldBlank() throws InterruptedException, IOException {
			BaseTests.initialization();
			
			driver.get("https://parabank.parasoft.com/parabank/index.htm");
			POM c=new POM(driver);
			c.login("","");
			String Actual= driver.findElement(By.cssSelector(".error")).getText();
			Assert.assertEquals(Actual,"Please enter a username and password.");
//			closeBrowser();
			}
		
		@Test
		public void DLoginPassMask() throws InterruptedException, IOException {
						String Pass="12345*";
						BaseTests.initialization();

			driver.get("https://parabank.parasoft.com/parabank/index.htm");
			POM c=new POM(driver);
			c.login("1234","12345*");
			String enteredPassword = driver.findElement(By.xpath("//input[@name='password']")).getAttribute("name");

	        // Password should not be visible as plain text
	        if (enteredPassword.equals(Pass)) {
	            System.out.println("Test Failed: Password is visible as plain text");
	        } else {
	            System.out.println("Test Passed: Password is properly masked");
	        }
//	        closeBrowser();
	
		}
		
		@Test
		public void EACCOverview() throws InterruptedException, IOException {
			String Uname="Veera";
			String Pass="12345*";
 
			BaseTests.initialization();
			driver.get("https://parabank.parasoft.com/parabank/index.htm");
			Thread.sleep(1000);
			POM c=new POM(driver);
			c.login(Uname,Pass);
			
			String a=driver.findElement(By.cssSelector(".title")).getText();
			
			boolean z=a.equalsIgnoreCase("Accounts Overview");
			System.out.println(z);
			c.AccInfo();
		}
		 
		@Test
		public void AppLyLoan() throws IOException, InterruptedException {
			
			BaseTests.initialization();driver.get("https://parabank.parasoft.com/parabank/index.htm");
			String Uname="Veere";
			String Pass="12536";
			String amt1="19080";
			String amt2="789";
			POM c=new POM(driver);
			c.login(Uname,Pass);
			
			ApplyLoan a=new ApplyLoan(driver);
			a.ApplyLoans(amt1,amt2);
			
		}

}

 
