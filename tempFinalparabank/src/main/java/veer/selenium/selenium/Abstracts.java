package veer.selenium.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import veer.selenium.selenium.POM.POM;

public class Abstracts {
// public WebDriver driver;

 public WebDriver driver;
		
 
		
		public void explicitwait(int sec) {
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		}

		@FindBy(xpath="//select[@id='type']")
		WebElement dropdowns;
		
//		FindBy By="//select[@id='type']";
		
		public void doopDownVal(String DesiredType) {
//			String z=AccType.equalsIgnoreCase(AccType);
			Select dropdown = new Select(dropdowns);
			dropdown.selectByValue(DesiredType);
			
//			Actions a=new Actions(driver);
			
			
		}
		@FindBy(css=".title")
		WebElement getsTitle;
		
//		String By="//select[@id='type']";
		public void Title() {
			explicitwait(5);
			getsTitle.getText();

		}
		
		public String getScreenshot(  String testCaseName, WebDriver driver) throws IOException {
			

			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
			FileUtils.copyFile(source, file);
			return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
			
		}
		 public void selectDropdownByVisibleText(WebElement dropdownElement, String optionText) {
		        Select select = new Select(dropdownElement);
		        select.selectByVisibleText(optionText);
		        
		 }
		 
		 
		 public void selectDropdown(WebElement dropdownElement, String optionText) {
		        Select select = new Select(dropdownElement);
		        select.selectByVisibleText(optionText);
		        
		 }
		 public void selectDropdownByIndex(WebElement dropdownElement, int index) {
		        Select select = new Select(dropdownElement);
		        select.selectByIndex(index);
		    }

		    // Method to select an option from dropdown by value
		    public void selectDropdownByValue(WebElement dropdownElement, String value) {
		        Select select = new Select(dropdownElement);
		        select.selectByValue(value);
		    }
	}


