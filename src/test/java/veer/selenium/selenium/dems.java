package veer.selenium.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
//		System.setProperty("chromedriver","C:\\Users\\veere\\.m2\\repository\\org\\seleniumhq\\selenium\\selenium-chromium-driver.exe" );
//		driver.get("https://in.search.yahoo.com/search?fr=mcafee&type=E211IN885G0&p=seleniumtheory+questions");
//		driver.get("https://www.flipkart.com/products-list/recently-viewed?screen=dynamic&pk=marketplace%3DFLIPKART~widgetType%3DproductCard~contentType%3DfactBasedRecommendation%2FrecentlyViewed&marketplace=FLIPKART&wid=39.productCard.RECENTLY_VIEWED_19&otracker=pp_reco_Recently%2BViewed");
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	List<WebElement> l=driver.findElements(By.xpath("//table/tbody/tr/td/ul/li"));
		for(WebElement d:l) {
			System.out.println(d.getText());
			System.out.println(l);
		}System.out.println(l.size());
	}

}
