import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import java.io.IOException;

/**
 * @author Moneshwori Leishangthem on 23/09/2018.
 */
public class Module {
    private final static Logger LOGGER = Logger.getLogger(Module.class);
    public static WebDriver driver;

    /*
    * retrieveDataFromExcel() - will retrieve and return data from excel.
    * */
    protected String retrieveDataFromExcel(String sheetName, int RowNum, int CellNum) {
        LOGGER.debug("Entering retrieveDataFromExcel");
        String filePath = System.getProperty("user.dir");
        String fileName = BonifyConstants.FILE_NAME;
        String data_value = null;
        ExcelRead excelRead = new ExcelRead();
        try {
            data_value = excelRead.readData_Excel(filePath, fileName, sheetName, RowNum, CellNum);
            LOGGER.debug("Exiting retrieveDataFromExcel");
            return data_value;
        } catch (IOException e) {
            LOGGER.error(BonifyConstants.FILE_NOT_FOUND_ERR);
            e.printStackTrace();
            LOGGER.debug("Exiting retrieveDataFromExcel");
            return "NULL";
        }
    }

    /*
    * set_driver() - sets the web driver to chrome driver.
    * */
    public WebDriver set_driver() {
        LOGGER.debug("Entering set_driver");
        System.setProperty(BonifyConstants.WEB_DRIVER_CHROME, BonifyConstants.CHROME_DRIVER_EXE_PATH);
        driver = new ChromeDriver();
        LOGGER.debug("Exiting set_driver");
        return driver;
    }

    /*
    * openBrowser() - opens the bonify web page.
    * */
    public void openBrowser(WebDriver driver) {
        LOGGER.debug("Entering openBrowser");
        driver.get(BonifyConstants.BONIFY_URL);
        LOGGER.debug("Exiting openBrowser");
    }

    /*
    * verify_webPage_text() - verifies the webpage texts using asserts.
    * */
    public void verify_webPage_text(int row, int cell, WebElement webelement, String actualValue) throws InterruptedException {
        LOGGER.debug("Entering verify_webPage_text");
        String Copyexcel_value = retrieveDataFromExcel("login", row, cell);
        if (actualValue == null) {
            WebElement we_message = webelement;
            String WebElement_value = we_message.getText();
            Assert.assertEquals(WebElement_value, Copyexcel_value);
        } else
            Assert.assertEquals(actualValue, Copyexcel_value);
        Thread.sleep(100);
        LOGGER.debug("Exiting verify_webPage_text");
    }

    /*
    * enter_data() - enters the text in webpage elements.
    * */
    public void enter_data(int row, int cell, WebElement webelement) throws InterruptedException {
        LOGGER.debug("Entering enter_data");
        String Copyexcel_value = retrieveDataFromExcel("login", row, cell);
        WebElement we_message = webelement;
        we_message.sendKeys(Copyexcel_value);
        Thread.sleep(100);
        LOGGER.debug("Exiting enter_data");
    }
}


