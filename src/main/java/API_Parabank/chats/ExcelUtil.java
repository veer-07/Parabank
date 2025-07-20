package API_Parabank.chats;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelUtil {

    private String excelFilePath;
    private Workbook workbook;
    private Sheet sheet;

    public ExcelUtil(String excelFilePath) throws IOException {
        this.excelFilePath = excelFilePath;
        FileInputStream file = new FileInputStream(new File(excelFilePath));
        this.workbook = new XSSFWorkbook(file);
        this.sheet = workbook.getSheetAt(0); // Assume the data is in the first sheet
    }

    // Method to get the data from Excel (returns a 2D Object Array)
    public Object[][] getExcelData() {
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rowCount - 1][colCount]; // excluding header row
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next(); // skip header row

        int rowIndex = 0;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            for (int colIndex = 0; colIndex < colCount; colIndex++) {
                data[rowIndex][colIndex] = row.getCell(colIndex).toString();
            }
            rowIndex++;
        }
        return data;
    }

    // Close workbook after usage
    public void close() throws IOException {
        workbook.close();
    }
}
