package API_Parabank.chats;


	import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
//	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

	public class execution {

	     

	     

	    @Test(dataProvider = "testData")
	    public void performTest(String u, String searchQuery) {
	    	WebDriver driver=new ChromeDriver();
//	    	driver.get("https://parabank.parasoft.com/parabank/index.htm");
	        driver.get("https://parabank.parasoft.com/parabank/index.htm");
	        driver.findElement(By.cssSelector(".input")).sendKeys(u);
	        driver.findElement(By.cssSelector("input[type='submit']")).sendKeys(searchQuery);

	        // You can add assertions as needed here
	    }

	    @DataProvider(name = "testData")
	     
	    public static Object[][] excelData() throws IOException {
	        String filePath = "D://Java_Selenuim//ParaBankDetails.xlsx"; // Path to the Excel file
	        return readExcelFile(filePath); // Return the data
	    }

	    // Method to read data from Excel and return as 2D array
	    public static String[][] readExcelFile(String filePath) throws IOException {
	        FileInputStream file = new FileInputStream(filePath);
	        XSSFWorkbook workbook = new XSSFWorkbook(file);
	        XSSFSheet sheet = workbook.getSheetAt(0);
	        int rowCount = sheet.getPhysicalNumberOfRows();
	        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
	        DataFormatter f = new DataFormatter();
	        // Create 2D array to store the data
	        String[][] data = new String[rowCount][colCount];

	        // Loop through rows and columns to fill the array
	        for (int i = 1; i < rowCount; i++) {
	            Row row = sheet.getRow(i);
	            for (int j = 0; j < colCount; j++) {
	                Cell cell = row.getCell(j);
	                if (cell != null) {
	                    data[i][j] = f.formatCellValue(cell);
	                }
	            }
	        }
	        workbook.close();
	        file.close();

	        return data;
	    }

	}
