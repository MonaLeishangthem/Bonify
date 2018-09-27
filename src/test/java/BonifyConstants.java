import org.testng.log4testng.Logger;

/**
 * @author Moneshwori Leishangthem on 23/09/2018.
 */

public class BonifyConstants {
    private final static Logger LOGGER = Logger.getLogger(Module.class);
    //Bonify URL
    public static final String BONIFY_URL = "https://my.bonify.de/login?next=/";

    //Excel file name
    public static final String FILE_NAME = "CopyWrite_excel.xlsx";
    public static final String FILE_NOT_FOUND_ERR = "File NOT found";

    //Web driver
    public static final String WEB_DRIVER_CHROME = "webdriver.chrome.driver";
    public static final String CHROME_DRIVER_EXE_PATH = "C:\\chromedriver.exe"; // should specify the path to chromedriver.exe file

    //Webpage DOM elements
    public static final String WILKOMMEN = "div.login-panel>h1";
    public static final String FORGOT_PWD = "div.form-group.remember-pass>a>span";
    public static final String LOGIN_BTN = "div.actions:nth-child(1)>button>span";
    public static final String NEU_RGTN_TEXT = "div.actions:nth-child(2)>a>button>span";
    public static final String NEU_RGTN_BTN = "div.actions:nth-child(2)>a>button";
    public static final String IMPRESSUM_TEXT = "ul.nav>li:nth-child(1)>a>span";
    public static final String IMPRESSUM_LINK = "ul.nav>li:nth-child(1)>a";
    public static final String AGB_TEXT = "ul.nav>li:nth-child(2)>a>span";
    public static final String AGB_LINK = "ul.nav>li:nth-child(2)>a";
    public static final String DATENSCHUTZ_TEXT = "ul.nav>li:nth-child(3)>a>span";
    public static final String DATENSCHUTZ_LINK = "ul.nav>li:nth-child(3)>a>span";
    public static final String FOOTER_TEXT = "div.container>footer>div";

    //Login
    public static final String EMAIL_TEXT_FIELD = "div.text-field:nth-child(1)>input";
    public static final String PWD_TEXT_FIELD = "div.text-field:nth-child(2)>input";
    public static final String LOGIN_BTN_CLICK = "div.actions:nth-child(1)>button";
    public static final String USR_EMAIL = "div.dropdown-label";
    public static final String LOGOUT_BTN = "div#main-body>ul>li:nth-child(4)>button";

    //Frame testing
    public static final String DEALS_BTN = "div.wrapper>nav>ul>li:nth-child(4)>a";
    public static final String KREDITBETRAG_BTN = "div.jx_ui_Widget>div>div>div:nth-child(3)";
    public static final String CHAT_NAME_TEXT = "div.editing>input:nth-child(2)";
    public static final String CHAT_EMAIL_TEXT = "div.editing>input:nth-child(4)";
    public static final String CHAT_MSG_TEXT = "div.scrollable_inner>div:nth-child(8)>div>div:nth-child(2)>textarea";
    public static final String MSG_SEND_BTN = "div.bottom>input";
}

