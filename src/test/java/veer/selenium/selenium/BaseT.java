package veer.selenium.selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
//
//import API_Parabank.chats.ExcelDataProvider;
//import testComponents.BaseTests;
//import veer.selenium.selenium.POM.ApplyLoan;
//import veer.selenium.selenium.POM.OpenNewAcc;
//import veer.selenium.selenium.POM.POM;
//import veer.selenium.selenium.POM.Registartion;
//import veer.selenium.selenium.POM.UpdateContact;

import com.sun.net.httpserver.Authenticator.Retry;

import testComponents.BaseTests;
import testComponents.allure;
import veer.selenium.selenium.POM.ApplyLoan;
import veer.selenium.selenium.POM.Billpay;
import veer.selenium.selenium.POM.POM;
import veer.selenium.selenium.POM.Registartion;
import veer.selenium.selenium.POM.TransferFund;
import veer.selenium.selenium.POM.UpdateContact;

public class BaseT extends BaseTests  {



	  
	
		@Test(dataProvider="excelDatas", dataProviderClass = Resource.ExcelDataProvider.class)
		public void ARegistrUser(String name, String lname,String address,String cities,String state,String zipcode,String phone, String ssns, String uname, String Password,String con) throws InterruptedException, IOException  {
			BaseTests.initialization();
//			driver.get("https://parabank.parasoft.com/parabank/index.htm");

			Registartion r=new Registartion(driver);
			r.register(name,lname,address,cities,state,zipcode,phone,ssns,uname,Password,con);
			
						 
	}
	
		@Test(dataProvider="excelDatas", dataProviderClass = Resource.ExcelDataProvider.class, retryAnalyzer=testComponents.Retry.class)
		public void DupAcc(String name, String lname,String address,String cities,String state,String zipcode,String phone, String ssns, String uname, String Password,String con) throws InterruptedException, IOException  {
			BaseTests.initialization();
//			driver.get("https://parabank.parasoft.com/parabank/index.htm");

			Registartion r=new Registartion(driver);
			r.DuplicateAcc(name, lname, address, cities, state, zipcode, phone, ssns, uname, Password, con);
			
						 
	}
	
		
		
		@Test(retryAnalyzer=testComponents.Retry.class)
		public void BInCorrPass() throws InterruptedException, IOException {
			
			BaseTests.initialization();
//			driver.get("https://parabank.parasoft.com/parabank/index.htm");
			POM c=new POM(driver);
			c.login();
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
			
//			driver.get("https://parabank.parasoft.com/parabank/index.htm");
			POM c=new POM(driver);
			c.login();
			String Actual= driver.findElement(By.cssSelector(".error")).getText();
			Assert.assertEquals(Actual,"Please enter a username and password.");
//			closeBrowser();
			}
		
		@Test
		public void DLoginPassMask() throws InterruptedException, IOException {
						String Pass="12345*";
						BaseTests.initialization();

//			driver.get("https://parabank.parasoft.com/parabank/index.htm");
			POM c=new POM(driver);
			c.login();
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
			String Uname="john";
			String Pass="demo";
 
			BaseTests.initialization();
//			driver.get("https://parabank.parasoft.com/parabank/index.htm");
			Thread.sleep(1000);
			POM c=new POM(driver);
			c.login( );
			
			String a=driver.findElement(By.cssSelector(".title")).getText();
			
			boolean z=a.equalsIgnoreCase("Accounts Overview");
			System.out.println(z);
			c.AccInfo();
		}
		 
		@Test
		public void AppLyLoan() throws IOException, InterruptedException {
			
			BaseTests.initialization();
//			driver.get("https://parabank.parasoft.com/parabank/index.htm");
//			String Uname="john";
//			String Pass="demo";
			String amt1="10";
			String amt2="78";
			POM c=new POM(driver);
			c.login( );
			
			ApplyLoan a=new ApplyLoan(driver);
			a.ApplyLoans(amt1,amt2);
//			System.out.println(Overview);
			
		}
		
		@Test
		public void UpdateContactsSuccess() throws IOException, InterruptedException {
				BaseTests.initialization();
//			driver.get("https://parabank.parasoft.com/parabank/index.htm");
			Thread.sleep(1000);
			POM c=new POM(driver);
			c.login();
			
			UpdateContact u=new UpdateContact(driver);
			u.UpdateAllinfo("455","fdfsa", "12123", "nul412l", "14324", "543w", "null");
			
		}
		 

		@Test
		public void transferFund() throws IOException, InterruptedException {
			BaseTests.initialization();
//			driver.get("https://parabank.parasoft.com/parabank/index.htm");
			POM c=new POM(driver);
			c.login();
			TransferFund f=new TransferFund(driver);
			f.TransferFunds("12678","12900","4");
		}
		
		@Test
		public void Billpayee() throws IOException ,InterruptedException{
			BaseTests.initialization();
//			driver.get("https://parabank.parasoft.com/parabank/index.htm");
			POM c=new POM(driver);
			c.login();
			Billpay b=new Billpay(driver);
			b.BillPayment();
		}
}

 
