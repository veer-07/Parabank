package veer.selenium.selenium;

import java.io.File;
//import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Resource.exRepo;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;

 

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTests {

	
	
	public static WebDriver driver;
//	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	 private static int counter = 0;
	 exRepo reportManager = new exRepo();

//	 public static WebDriver getDriver() {
//	        return driver.get();
//	    }
//
//	    public static void initialization() throws IOException {
//	        Properties prp = new Properties();
//	        FileInputStream fis = new FileInputStream("path_to_your_properties");
//	        prp.load(fis);
//	        String browserName = prp.getProperty("browser");
//
//	        WebDriver localDriver;
//	        if (browserName.equalsIgnoreCase("chrome")) {
//	            localDriver = new ChromeDriver();
//	        } else {
//	            localDriver = new EdgeDriver();
//	        }
//	        localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	        driver.set(localDriver);
//	    }
//
//	    public static void quitDriver() {
//	        getDriver().quit();
//	        driver.remove();
//	    }

	 
	 
		    

		  
	 
	 
	 
	public static WebDriver initialization() throws IOException {
		Properties prp=new Properties();
		FileInputStream fis=new FileInputStream("D:\\Java_Selenuim\\eclipse-workspace\\Final_ParaBank\\src\\main\\resources\\global.properties");
		prp.load(fis);	
		String browserName=prp.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
//			WebDriverManager.chromedriver().setup(); 
			driver=new ChromeDriver();
			
		}
		else {
			prp.getProperty("Edge");
			WebDriverManager.edgedriver().setup(); 
			driver=new EdgeDriver();
			
		}
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		return driver;
	}
	
	
//	@Attachment(value = "Log Message", type = "text/plain")
//    public static String logMessage(String message) {
//        return message;
//    }

//    @Attachment(value = "Screenshot", type = "image/png")
//    public static byte[] attachScreenshot(byte[] screenshotData) {
//        return screenshotData;
//    }

//	public String getScreenshot(  String testCaseName, WebDriver driver) throws IOException {
//		
//	   
//		TakesScreenshot ts = (TakesScreenshot)driver;
//        counter++;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		File file = new File(System.getProperty("user.dir") + "//repor//" +  counter	+testCaseName + ".png");
//		FileUtils.copyFile(source, file);
//		return System.getProperty("user.dir") + "//repor//" + testCaseName + ".png";
//		
//	}

	
	public static void highlightElement( WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
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

	@AfterMethod
	
    public void tearDown(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File("./screenshots/" + methodName + ".png");
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            System.out.println("Screenshot capture failed for: " + methodName);
        }
        reportManager.repo();
//        driver.quit();
    }

	
}
