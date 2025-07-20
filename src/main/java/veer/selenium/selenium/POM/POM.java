package veer.selenium.selenium.POM;

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

import veer.selenium.selenium.Abstracts;

public class POM  extends Abstracts{
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
 
		public void login() throws IOException   {
			Properties prp=new Properties();
			FileInputStream fis=new FileInputStream("D:\\Java_Selenuim\\eclipse-workspace\\Final_ParaBank\\src\\main\\java\\Resource\\global.properties");
			prp.load(fis);
			driver.get(prp.getProperty("url"));
			String Unames=prp.getProperty("Uname");
			String Pass=prp.getProperty("Pass");
			username.sendKeys(Unames);
			password.sendKeys(Pass);
			submit.click();
			
		}
		@FindBy(xpath="//tr/td")
		List<WebElement> acc;
		
		@FindBy(id="accountTable")
		List<WebElement> aa;
		
		
		public void AccInfo() throws InterruptedException {
			for(WebElement a:aa) {
				System.out.println("Account Overview");
				System.out.println("==============================");
				Thread.sleep(1000);
				System.out.println(a.getText()+"   ");
			}
		}

		}
		
		

		
		
		
		
		
		
			
		

		
		
		
		
		
		

		
		




