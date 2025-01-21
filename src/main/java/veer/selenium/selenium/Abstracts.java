package veer.selenium.selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import veer.selenium.selenium.POM.POM;

public class Abstracts {
 public WebDriver driver;

//		public WebDriver;
		
		public Abstracts(WebDriver driver) {
			super();
			this.driver=driver;
			
		}
		
		public void initilize() {
			
			
			
		}
		
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


