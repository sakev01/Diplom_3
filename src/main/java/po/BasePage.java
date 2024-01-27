package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {
    protected WebDriver webDriver;
    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site";
    public static final String REGISTRATION_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    public static final String FORGOT_PASSWORD_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    public static final String PERSONAL_MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";


    private final By personalAccountButton = By.xpath("//a[.//p[text()='Личный Кабинет']]");
    private final By constructorButton = By.xpath("//a[contains(@class, 'AppHeader_header__link__3D_hX') and @href='/']");

    private final By stellarBurgersLogo = By.xpath("//a[@href='/' and @class='AppHeader_header__link__3D_hX']");

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    protected void clickElement(By locator) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.findElement(locator).click();
    }

    protected void enterText(By locator, String text) {
        WebElement element = webDriver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void clickOnPersonalAccountButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(4));
        WebElement personalAccountLink = wait.until(ExpectedConditions.elementToBeClickable(personalAccountButton));
        personalAccountLink.click();
    }

    public void clickOnConstructorButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(4));
        WebElement constructorLink = wait.until(ExpectedConditions.elementToBeClickable(constructorButton));
        constructorLink.click();
    }

    public void clickOnStellarBurgersLogo() {
        WebElement logo = webDriver.findElement(stellarBurgersLogo);
        logo.click();
    }

    public void waitForVisibility(By element) {
        new WebDriverWait(webDriver, Duration.ofSeconds(4));
        webDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        new WebDriverWait(webDriver, Duration.ofSeconds(4))
                .until(ExpectedConditions.visibilityOf(webDriver.findElement(element)));
    }
}