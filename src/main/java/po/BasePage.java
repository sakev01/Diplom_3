package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver webDriver;
    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site";
    public static final String REGISTRATION_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    public static final String FORGOT_PASSWORD_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";


    private By personalAccountButton = By.xpath("//a[.//p[text()='Личный Кабинет']]");
    private By constructorButton = By.xpath("//a[contains(@class, 'AppHeader_header__link__3D_hX') and @href='/']");

    private By stellarBurgersLogo = By.xpath("//a[@href='/' and @class='AppHeader_header__link__3D_hX']");

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
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement personalAccountLink = wait.until(ExpectedConditions.elementToBeClickable(personalAccountButton));
        personalAccountLink.click();
    }
    public void clickOnConstructorButton(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(4));
        WebElement constructorLink = wait.until(ExpectedConditions.elementToBeClickable(constructorButton));
        constructorLink.click();
    }
    public void clickOnStellarBurgersLogo(){
        WebElement logo = webDriver.findElement(stellarBurgersLogo);
        logo.click();
    }
}