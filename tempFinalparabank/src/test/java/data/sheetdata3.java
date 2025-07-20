package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class sheetdata3 {

    public static void getData(String u, String pass) throws IOException {
        ArrayList<ArrayList<String>> data = new ArrayList<>(); // 2D ArrayList to hold the data
        FileInputStream fis = null;
        XSSFWorkbook workbook = null;
        int rc;

        String path = "D://Java_Selenuim//ParaBankDetails.xlsx"; // Path to your file

        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);

            int sheets = workbook.getNumberOfSheets();
            for (int i = 0; i < sheets; i++) {
                if (workbook.getSheetName(i).equalsIgnoreCase("login")) {
                    XSSFSheet sheet = workbook.getSheetAt(i);
                    Iterator<Row> rows = sheet.iterator();
                    rc = sheet.getLastRowNum();
                    Row firstRow = rows.next();
                    Iterator<Cell> ce = firstRow.cellIterator();
                    int k = 0;
                    int column = 0;

                    // Find the column index for "USERname"
                    while (ce.hasNext()) {
                        Cell value = ce.next();
                        if (value.getStringCellValue().equalsIgnoreCase("USER ")) {
                            column = k;
                        }
                        k++;
                    }

                    // Now loop through rows to get the data of user1
                    while (rows.hasNext()) {
                        Row r = rows.next();
                        if (r.getCell(column).getStringCellValue().equalsIgnoreCase("veere")) {
                            ArrayList<String> rowData = new ArrayList<>(); // ArrayList for each row
                            Iterator<Cell> cv = r.cellIterator();
                            while (cv.hasNext()) {
                                Cell c = cv.next();
                                if (c.getCellType() == CellType.STRING) {
                                    rowData.add(c.getStringCellValue());
                                } else if (c.getCellType() == CellType.NUMERIC) {
                                    rowData.add(String.valueOf(c.getNumericCellValue()));
                                } else if (c.getCellType() == CellType.BOOLEAN) {
                                    rowData.add(String.valueOf(c.getBooleanCellValue()));
                                } else if (c.getCellType() == CellType.BLANK) {
                                    rowData.add(""); // Add empty string if the cell is blank
                                }
                            }
                            data.add(rowData); // Add the row data to the 2D list
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

        // Printing the 2D ArrayList (data)
        for (ArrayList<String> row : data) {
            for (String cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        getData("user1", "password"); // You can pass values for username and password if needed
    }
}
