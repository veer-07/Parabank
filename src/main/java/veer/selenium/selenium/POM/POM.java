package veer.selenium.selenium.POM;


import java.util.ArrayList;
import java.util.List;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

//import veer.selenium.selenium.Abstracts;
import veer.selenium.selenium.BaseTests;

public class POM  extends BaseTests{
	 
		public WebDriver driver;
		@FindBy(css=".input")
		WebElement username;
		@FindBy(css = "input[type='password']")
		WebElement password;
//		WebElement pass;
		@FindBy(css = "input[type='submit']")
		WebElement submit;
		
		
		
		
		
		public POM(WebDriver driver) {
			super( );
			this.driver = driver;
			PageFactory.initElements(driver, this);
     
		}
 
		
				
		//a[contains(@href,'register')]  
//		public void registration(String uname,String pass) {
//			regi.click();
//			username.sendKeys(uname);
//			password.sendKeys(pass);
//		}
//		public void login(String Uname,String passwords) throws InterruptedException {
//			
//			username.sendKeys(Uname);
//			password.sendKeys(passwords);
//
//		}
		public void login() throws IOException   {
			Properties prp=new Properties();
			FileInputStream fis=new FileInputStream("D:\\Java_Selenuim\\eclipse-workspace\\Final_ParaBank\\src\\main\\java\\Resource\\global.properties");
			prp.load(fis);
			driver.get(prp.getProperty("url"));
			String Unames=prp.getProperty("Uname");
			String Pass=prp.getProperty("Pass");
			username.sendKeys(Unames);
			password.sendKeys(Pass);
			highlightElement(username);
			getScreenshot("Logins",driver);
			submit.click();
			
		}
		
		
		
		
		public void loginWithCustomCreds(String Uname, String Password) throws IOException   {
			Properties prp=new Properties();
			FileInputStream fis=new FileInputStream("D:\\Java_Selenuim\\eclipse-workspace\\Final_ParaBank\\src\\main\\java\\Resource\\global.properties");
			prp.load(fis);
			driver.get(prp.getProperty("url"));
			String Unames=prp.getProperty("Uname");
			String Pass=prp.getProperty("Pass");
			username.sendKeys(Uname);
			password.sendKeys(Password);
			highlightElement(username);
			getScreenshot("Logins",driver);
			submit.click();
			
		}
		
		
		@FindBy(xpath="//tr/td")
		List<WebElement> acc;
		
		@FindBy(id="accountTable")
		List<WebElement> aa;
		
		
		public void AccInfo() throws InterruptedException, IOException {
			for(WebElement a:aa) {
				System.out.println("Account Overview");
				System.out.println("==============================");
				Thread.sleep(1000);
				
				System.out.println(a.getText()+"   ");
			}
 
		}
		
		@FindBy(xpath="//tr/td/a")
		List<WebElement> Accounts;

		@FindBy(xpath="//div[@id='rightPanel']")
		WebElement  ActivityDetails;
		
//		int len=Accounts;
//		
//		String[] textArray = new String[len];
		
		public  String[] AccoutNumbersCreated(String Acnumber) {
			 String[] textArray = new String[Accounts.size()];
		        
			for(int i=0;i<Accounts.size();i++) {
				
				 textArray[i] = Accounts.get(i).getText();
	        
			
			if (textArray[i]==Acnumber){
				
			}}
			for (String text : textArray) {
	            System.out.println("Available accounts are: "+text);
	            
	        }
			 
	       
	        return textArray;
			
				}
 
		
		}
		
		
		

		
		
		
		
		
		
			
		

		
		
		
		
		
		

		
		




