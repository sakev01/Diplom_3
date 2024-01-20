import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import static driver.WebDriverCreator.createWebDriver;

public class BaseTest {

    public static final String PROFILE_PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";


    protected WebDriver webDriver;

    @Before
    public void startBrowser() {

        webDriver = createWebDriver();
        WebDriverManager.chromedriver().setup();
        webDriver.manage().window().maximize();

    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
