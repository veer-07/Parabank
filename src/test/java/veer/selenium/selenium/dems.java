package veer.selenium.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dems {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
//		System.setProperty("chromedriver","C:\\Users\\veere\\.m2\\repository\\org\\seleniumhq\\selenium\\selenium-chromium-driver.exe" );
//		driver.get("https://in.search.yahoo.com/search?fr=mcafee&type=E211IN885G0&p=seleniumtheory+questions");
//		driver.get("https://www.flipkart.com/products-list/recently-viewed?screen=dynamic&pk=marketplace%3DFLIPKART~widgetType%3DproductCard~contentType%3DfactBasedRecommendation%2FrecentlyViewed&marketplace=FLIPKART&wid=39.productCard.RECENTLY_VIEWED_19&otracker=pp_reco_Recently%2BViewed");
//	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//	List<WebElement> l=driver.findElements(By.xpath("//table/tbody/tr/td/ul/li"));
//		for(WebElement d:l) {
//			System.out.println(d.getText());
//			System.out.println(l);
//		}System.out.println(l.size());
		
//		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(4000);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1700)");
		
//	List<WebElement> l=	driver.findElements(By.cssSelector("iframe[id='courses-iframe']"));
//	JavascriptExecutor js1=(JavascriptExecutor) driver;
//	driver.findElement(null)
		Thread.sleep(4000);
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id='courses-iframe']")));
		driver.findElement(By.cssSelector("ul li:nth-child(6)")).click();
		js.executeScript("document.querySelector('body > div:nth-child(7) > fieldset:nth-child(1)').scrollTop(100)");
		
//		TakeScreenShot shot=((TakeScreenshot) driver);
	}

}
