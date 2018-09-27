import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;

import java.util.ArrayList;

/**
 * @author Moneshwori Leishangthem on 23/09/2018.
 */
public class BonifyWebpageTest {
    private final static Logger LOGGER = Logger.getLogger(BonifyWebpageTest.class);
    Module open_browser;
    WebDriver driver;

    /*
    * Will be executed before complete test suite.
    * init_driver() - will initialize the WEB chrome driver.
    * */
    @BeforeTest
    public void init_driver() {
        LOGGER.debug("Entering init_driver");
        open_browser = new Module();
        driver = open_browser.set_driver();
        LOGGER.debug("Exiting init_driver");
    }

    /*
    * Will be executed before every test.
    * webpage_wait() - will introduce a wait of 250 ms.
    * */
    @BeforeMethod
    public void webpage_wait() throws InterruptedException {
        Thread.sleep(250);
    }

    /*
    * Test priotity 0
    * launch_webPage() - will launch the bonify webpage on the browser.
    * */
    @Test(priority = 0)
    public void launch_webPage() {
        LOGGER.debug("Entering TEST:launch_webPage");
        open_browser.openBrowser(driver);
        driver.manage().window().maximize();
        LOGGER.debug("Exiting TEST:launch_webPage");
    }
    /*
* Test priotity 1
* verify_bonify_login() - will verify the login and logout for bonify.
* */
    @Test(priority = 1)
    public void verify_bonify_login() throws InterruptedException {
        LOGGER.debug("Entering TEST:verify_bonify_login");
        WebElement we_message = driver.findElement(By.cssSelector(BonifyConstants.EMAIL_TEXT_FIELD));
        open_browser.enter_data(13, 0, we_message);//submit data from excel
        we_message = driver.findElement(By.cssSelector(BonifyConstants.PWD_TEXT_FIELD));
        open_browser.enter_data(14, 0, we_message);//submit data from excel

        //login to bonify
        we_message = driver.findElement(By.cssSelector(BonifyConstants.LOGIN_BTN_CLICK));
        we_message.click();
        Thread.sleep(1000);
        LOGGER.debug("Exiting TEST:verify_bonify_login");
    }
    /*
    * Test priotity 2
    * use_frame() - will switch between frames in bonify.
    * */
    @Test(priority=2)
    public void use_frame()throws InterruptedException {
        LOGGER.debug("Entering TEST:use_frame");
        Thread.sleep(1000);
        WebElement we_message = driver.findElement(By.cssSelector(BonifyConstants.DEALS_BTN));
        we_message.click(); //click to Angebote

        Thread.sleep(5000);
        //Frames
        //int size = driver.findElements(By.tagName("iframe")).size();
      //  System.out.println("3 iFrame ** - " + size);
        // driver.switchTo().frame(driver.findElement(By.cssSelector("div.zopim:nth-child(1)")));

        //Switch to Frame with index 0
        driver.switchTo().frame(0);
        Thread.sleep(3000);
        we_message = driver.findElement(By.cssSelector(BonifyConstants.NACHRICHT_BTN));
        we_message.click();

        //logout
        Thread.sleep(300);
        driver.switchTo().defaultContent();
        we_message = driver.findElement(By.cssSelector(BonifyConstants.USR_EMAIL));
        we_message.click();
        Thread.sleep(300);
        we_message = driver.findElement(By.cssSelector(BonifyConstants.LOGOUT_BTN));
        we_message.click();
        LOGGER.debug("Existing TEST:use_frame");
    }
    @AfterTest
    public void close_driver() {
        LOGGER.debug("Entering TEST:close_driver");
        for (int i = driver.getWindowHandles().size() - 1; i >= 0; i--) {
            String winHandle = driver.getWindowHandles().toArray()[i].toString();
            driver.switchTo().window(winHandle);
            driver.close();
        }
        LOGGER.debug("Existing TEST:close_driver");
    }

}

