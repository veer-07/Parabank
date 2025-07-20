package API_Parabank.chats;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import java.io.File;
 

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelUtil2 {

	 public static String[][] readExcelFile(String filePath) throws IOException   {
	        FileInputStream file = new FileInputStream(new File(filePath));
	        Workbook workbook = new XSSFWorkbook(file);
	        Sheet sheet = workbook.getSheetAt(0);
	        int rowCount = sheet.getPhysicalNumberOfRows();
	        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
	        DataFormatter f=new DataFormatter();
	        // Create 2D array to store the data
	        String[][] data = new String[rowCount][colCount];
	        
	        // Loop through rows and columns to fill the array
	        for (int i = 0; i < rowCount; i++) {
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
	 public static void main(String[] args) throws InvalidFormatException {
	        String filePath = "D://Java_Selenuim//ParaBankDetails.xlsx";// Path to the Excel file
	     
	        try {
	            // Read data from Excel and store it in a multidimensional array
	            String[][] excelData = ExcelUtil2.readExcelFile(filePath);
	            
	            // Print the data from the multidimensional array
	            for (int i = 1; i < excelData.length; i++) {
	                for (int j = 0; j < excelData[i].length; j++) {
	                    System.out.print(excelData[i][j] + "\t");
	                }
	                System.out.println();
	            }
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
	}