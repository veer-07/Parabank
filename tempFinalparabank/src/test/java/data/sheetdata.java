package data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class sheetdata {
//	public static void main(String[] args) {
	 
	public static ArrayList<Object> getData( ) throws IOException {
		
		ArrayList<Object> a=new ArrayList();
		FileInputStream fis=new FileInputStream("D://Java_Selenuim//ParaBankDetails.xlsx");
		 // Create a workbook instance (for XLSX format)
        Workbook workbook = new XSSFWorkbook(fis);
        int numSheets = workbook.getNumberOfSheets();
        
        // Iterate through all sheets
        for (int i = 0; i < numSheets; i++) {
            // Check if the sheet name is "Sheet2"
            if (workbook.getSheetName(i).equalsIgnoreCase("login")) {
                // Get the sheet
                Sheet sheet = workbook.getSheetAt(i);
                
                // Get the iterator for rows
                Iterator<Row> rows = sheet.iterator();
                
                // Get the first row (header row)
                Row firstRow = rows.next();
                Iterator<Cell> cv = firstRow.cellIterator();
                
                int k = 0;
                int column = -1;
                
                // Find the "Season" column index
                while (cv.hasNext()) {
                    Cell firstCell = cv.next();
                    if (firstCell.getStringCellValue().equalsIgnoreCase("user name")) {
                        column = k;
                    }
                    k++;
                }
                
                // Print column index for "Season"
                System.out.println("Season column index: " + column);
                
                // Iterate over the remaining rows
                while (rows.hasNext()) {
                    Row r = rows.next();
                    
                    // Check if the row contains "Apple" in the "Season" column
                    if (r.getCell(column) != null && r.getCell(column).getCellType()==CellType.NUMERIC ||r.getCell(column) != null && r.getCell(column).getCellType()==CellType.STRING) {
                        
                        // Iterate over all cells in the row to print the data
                        Iterator<Cell> cells = r.cellIterator();
                        while (cells.hasNext()) {
                            Cell cell = cells.next();
                            switch (cell.getCellType()) {
                                case STRING:
                                    a.add(cell.getStringCellValue() + "\t");
                                    break;
                                case NUMERIC:
                                    a.add(cell.getNumericCellValue() + "\t");
                                    break;
                                case BOOLEAN:
                                	 a.add(cell.getBooleanCellValue() + "\t");
                                    break;
                                default:
                                	 a.add("Unknown Cell Type\t");
                                    break;
                            }
                        }
                        System.out.println(); // Move to the next line after printing the row
                    }
                }
            }workbook.close();
            fis.close();
        }return a;

        // Close the workbook and file input stream
        
    }
}
