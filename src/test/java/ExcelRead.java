import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.log4testng.Logger;

/**
 * @author Moneshwori Leishangthem on 23/09/2018.
 */
public class ExcelRead {

    private final static Logger LOGGER = Logger.getLogger(Module.class);

    /*
    * getExcel() - will load and return the excel sheet.
    * */
    public Sheet getExcel(String filePath, String fileName, String sheetName) throws IOException {
        LOGGER.debug("Entering getExcel");
        //Create an object of File class to open xlsx file
        File file = new File(filePath + "\\" + fileName);
        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);
        Workbook Workbook = null;
        //Find the file extension by splitting file name in substring  and getting only extension name
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        //Check condition if the file is xlsx file
        if (fileExtensionName.equals(".xlsx")) {
            //If it is xlsx file then create object of XSSFWorkbook class
            Workbook = new XSSFWorkbook(inputStream);
        }
        //Check condition if the file is xls file
        else if (fileExtensionName.equals(".xls")) {
            //If it is xls file then create object of XSSFWorkbook class
            Workbook = new HSSFWorkbook(inputStream);
        }
        //Read sheet inside the workbook by its name
        Sheet excel_Sheet = Workbook.getSheet(sheetName);
        LOGGER.debug("Exiting getExcel");
        return excel_Sheet;
    }

    /*
    * readData_Excel() - will read and return the data from excel file.
    * */
    public String readData_Excel(String filePath, String fileName, String sheetName, int RowNum, int CellNum) throws IOException {
        LOGGER.debug("Entering readData_Excel");
        Sheet excel_Sheet = getExcel(filePath, fileName, sheetName);
        Row excel_row = excel_Sheet.getRow(RowNum);
        String Cell_value = excel_row.getCell(CellNum).getStringCellValue();
        LOGGER.debug("Exiting readData_Excel");
        return Cell_value;
    }
}

