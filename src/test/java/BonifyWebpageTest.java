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
        LOGGER.debug("Exiting TEST:launch_webPage");
    }

    /*
    * Test priotity 1
    * verify_webpage() - will verify if the launched webpage is correct.
    * */
    @Test(priority = 1)
    public void verify_webpage() throws InterruptedException {
        LOGGER.debug("Entering TEST:verify_webpage");
        Thread.sleep(100);
        WebElement we_message = driver.findElement(By.cssSelector(BonifyConstants.WILKOMMEN));
        open_browser.verify_webPage_text(0, 0, we_message, null); // Asserts
        LOGGER.debug("Exiting TEST:verify_webpage");
    }

    /*
    * Test priotity 2
    * verify_forgetPawrd() - will verify the displayed text and button for forget password.
    * */
    @Test(priority = 2)
    public void verify_forgetPawrd() throws InterruptedException {
        LOGGER.debug("Entering TEST:verify_forgetPawrd");
        WebElement we_message = driver.findElement(By.cssSelector(BonifyConstants.FORGOT_PWD));
        open_browser.verify_webPage_text(1, 0, we_message, null);//Asserts

        //get the url
        we_message.click();
        Thread.sleep(150);
        String currentURL = driver.getCurrentUrl();
        LOGGER.debug("Current URL :" + currentURL);
        open_browser.verify_webPage_text(8, 0, null, currentURL);//Asserts
        Thread.sleep(100);

        for (int i = 0; i < 3; i++)
            driver.navigate().back();
        driver.navigate().refresh();
        LOGGER.debug("Exiting TEST:verify_forgetPawrd");
    }

    /*
    * Test priotity 3
    * verify_login_text() - will verify the displayed text for login button.
    * */
    @Test(priority = 3)
    public void verify_login_text() throws InterruptedException {
        LOGGER.debug("Entering TEST:verify_login");
        WebElement we_message = driver.findElement(By.cssSelector(BonifyConstants.LOGIN_BTN));
        open_browser.verify_webPage_text(2, 0, we_message, null);//Asserts
        LOGGER.debug("Exiting TEST:verify_login");
    }

    /*
    * Test priotity 4
    * verify_newRegistration_button() - will verify the displayed text and button for new registration.
    * */
    @Test(priority = 4)
    public void verify_newRegistration_button() throws InterruptedException {
        LOGGER.debug("Entering TEST:verify_newRegistration_button");
        WebElement we_message = driver.findElement(By.cssSelector(BonifyConstants.NEU_RGTN_TEXT));
        open_browser.verify_webPage_text(3, 0, we_message, null);//Asserts

        //get the url
        we_message = driver.findElement(By.cssSelector(BonifyConstants.NEU_RGTN_BTN));
        we_message.click();
        Thread.sleep(150);
        String currentURL = driver.getCurrentUrl();
        LOGGER.debug("Current URL :" + currentURL);
        open_browser.verify_webPage_text(9, 0, null, currentURL);//Asserts

        //return to my.bonify.de
        driver.get(BonifyConstants.BONIFY_URL);
        LOGGER.debug("Exiting TEST:verify_newRegistration_button");
    }

    /*
    * Test priotity 5
    * verify_Impressum_link() - will verify the displayed text and link for Impressum.
    * */
    @Test(priority = 5)
    public void verify_Impressum_link() throws InterruptedException {
        LOGGER.debug("Entering TEST:verify_Impressum_link");
        WebElement we_message = driver.findElement(By.cssSelector(BonifyConstants.IMPRESSUM_TEXT));
        open_browser.verify_webPage_text(4, 0, we_message, null);//Asserts

        //get the url
        we_message = driver.findElement(By.cssSelector(BonifyConstants.IMPRESSUM_LINK));
        we_message.click();
        Thread.sleep(100);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); //switch to TAB #1
        String currentURL = driver.getCurrentUrl();
        LOGGER.debug("Current URL :" + currentURL);
        open_browser.verify_webPage_text(10, 0, null, currentURL);//Asserts
        driver.switchTo().window(tabs.get(0)); //switch to TAB #0
        LOGGER.debug("Exiting TEST:verify_Impressum_link");
    }

    /*
    * Test priotity 6
    * verify_AGB_link() - will verify the displayed text and link for AGB.
    * */
    @Test(priority = 6)
    public void verify_AGB_link() throws InterruptedException {
        LOGGER.debug("Entering TEST:verify_AGB_link");
        WebElement we_message = driver.findElement(By.cssSelector(BonifyConstants.AGB_TEXT));
        open_browser.verify_webPage_text(5, 0, we_message, null);//Asserts

        we_message = driver.findElement(By.cssSelector(BonifyConstants.AGB_LINK));
        we_message.click();
        Thread.sleep(900);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));//switch to TAB #2
        String currentURL = driver.getCurrentUrl();
        LOGGER.debug("Current URL :" + currentURL);
        open_browser.verify_webPage_text(11, 0, null, currentURL);//Asserts
        driver.switchTo().window(tabs.get(0));//switch to TAB #0
        LOGGER.debug("Exiting TEST:verify_AGB_link");
    }

    /*
    * Test priotity 7
    * verify_Datenschutz_link() - will verify the displayed text and link for Datenschutz.
    * */
    @Test(priority = 7)
    public void verify_Datenschutz_link() throws InterruptedException {
        LOGGER.debug("Entering TEST:verify_Datenschutz_link");
        WebElement we_message = driver.findElement(By.cssSelector(BonifyConstants.DATENSCHUTZ_TEXT));
        open_browser.verify_webPage_text(6, 0, we_message, null);//Asserts
        we_message = driver.findElement(By.cssSelector(BonifyConstants.DATENSCHUTZ_LINK));
        we_message.click();
        Thread.sleep(900);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(3));//switch to TAB #3
        String currentURL = driver.getCurrentUrl();
        LOGGER.debug("Current URL :" + currentURL);
        open_browser.verify_webPage_text(12, 0, null, currentURL);//Asserts
        driver.switchTo().window(tabs.get(0));//switch to TAB #0
        LOGGER.debug("Exiting TEST:verify_Datenschutz_link");
    }

    /*
    * Test priotity 8
    * verify_Footer_text() - will verify the displayed text for footer.
    * */
    @Test(priority = 8)
    public void verify_Footer_text() throws InterruptedException {
        LOGGER.debug("Entering TEST:verify_Footer_text");
        WebElement we_message = driver.findElement(By.cssSelector(BonifyConstants.FOOTER_TEXT));
        open_browser.verify_webPage_text(7, 0, we_message, null);//Asserts
        LOGGER.debug("Exiting TEST:verify_Footer_text");
    }

    /*
    * Test priotity 9
    * verify_bonify_login() - will verify the login and logout for bonify.
    * */
    @Test(priority = 9)
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

        //verify that the login was successful
        we_message = driver.findElement(By.cssSelector(BonifyConstants.USR_EMAIL));
        open_browser.verify_webPage_text(15, 0, we_message, null);//Asserts
        LOGGER.info("Successfully logged into Bonify!");

        //logout from bonify
        we_message.click();
        Thread.sleep(300);
        we_message = driver.findElement(By.cssSelector(BonifyConstants.LOGOUT_BTN));
        we_message.click();
        LOGGER.info("Successfully logged out of Bonify!");
        Thread.sleep(300);
        LOGGER.debug("Exiting TEST:verify_bonify_login");
    }

    /*
    * Will be executed after the complete test suite.
    * close_driver() - will close all tabs and the chrome driver.
    * */
    @AfterTest
    public void close_driver() {
        LOGGER.debug("Entering close_driver");
        for (int i = driver.getWindowHandles().size() - 1; i >= 0; i--) {
            String winHandle = driver.getWindowHandles().toArray()[i].toString();
            driver.switchTo().window(winHandle);
            driver.close();
        }
        LOGGER.debug("Exiting close_driver");
    }
}

