package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class sheetdata2 {
//	public static void main(String[] args) {
	 
	public static  void getData(String u,String pass) throws IOException {
        ArrayList<String> a = new ArrayList<String>();
        FileInputStream fis = null;
        XSSFWorkbook workbook = null;
        int rc;
        
        int cellsCount = 0;
        String path="D://Java_Selenuim//ParaBankDetails.xlsx";

        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            
            int sheets = workbook.getNumberOfSheets();
            for (int i = 0; i < sheets; i++) {
                if (workbook.getSheetName(i).equalsIgnoreCase("Registration")) {
                    XSSFSheet sheet = workbook.getSheetAt(i);
                    Iterator<Row> rows = sheet.iterator();
                       rc=sheet.getLastRowNum();
                    Row firstrow = rows.next();
                    Iterator<Cell> ce = firstrow.cellIterator();
                    int k = 0;
                    int column = 0;

                    while (ce.hasNext()) {
                        Cell value = ce.next();
                        if (value.getStringCellValue().equalsIgnoreCase("USERname ")) {
                            column = k;
                        }
                        k++;
                    }
                    System.out.println("TestCases column index: " + column);

                    while (rows.hasNext()) {
                        Row r = rows.next();
                       cellsCount=  r.getLastCellNum();
                        if (r.getCell(column).getStringCellValue().equalsIgnoreCase("user1")) {
                            Iterator<Cell> cv = r.cellIterator();
                            while (cv.hasNext()) {
//                            	for(int i=0;i<rc;i++)}{
                            		
                                Cell c = cv.next();
                                if (c.getCellType() == CellType.STRING) {
                                    a.add(c.getStringCellValue());
//                                    a.get(c.getStringCellValue());
                                } else if (c.getCellType() == CellType.NUMERIC) {
                                    a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                                } else if (c.getCellType() == CellType.BOOLEAN) {
                                    a.add(String.valueOf(c.getBooleanCellValue()));
                                } else if (c.getCellType() == CellType.BLANK) {
                                    a.add(""); // Add empty string if the cell is blank
                                }
                            }
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error reading the Excel file: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close resources
            if (fis != null) {
                fis.close();
            }
            if (workbook != null) {
                workbook.close();
            }
        }
        
//        
        for(int i=1;i<cellsCount;i++) {
        	System.out.println( a.get(i));
        	
        }
	}
}
