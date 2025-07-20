package API_Parabank.chats;

 

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;

 

 

public class Main {

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
