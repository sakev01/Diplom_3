package po;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {
    protected By mainPageOrderButton = By.xpath("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");
    private final By mainPageLoginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By mainPageBunSection = By.xpath("//div[span[text()='Булки'] and not(contains(@class, 'tab_tab_type_current__2BEPc'))]");
    private final By mainPageBunSectionAfterClickLocator = By.xpath("//div[span[text()='Булки'] and contains(@class, 'tab_tab_type_current__2BEPc')]");
    private final By mainPageSaucesSection = By.xpath("//div[span[text()='Соусы']]");
    private final By mainPageSaucesAfterClickLocator = By.xpath("//div[contains(@class, 'tab_tab_type_current__2BEPc') and span[text()='Соусы']]");

    private final By mainPageFillingsSection = By.xpath("//div[span[text()='Начинки']]");
    private final By mainPageFillingsAfterClickLocator = By.xpath("//div[contains(@class, 'tab_tab_type_current__2BEPc') and span[text()='Начинки']]");

    private final By makeBurgerLabelLocator = By.xpath("//h1[@class='text text_type_main-large mb-5 mt-10']");

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Opens main page")
    public void openMainPage() {
        webDriver.get(MAIN_PAGE_URL);
    }

    @Step("Clicks on login button")
    public void clickOnMainPageLoginButton() {
        clickElement(mainPageLoginButton);
    }

    @Step("Clicks on bun section")
    public void clickOnMainPageBunSection() {
        waitForVisibility(mainPageBunSection);
        clickElement(mainPageBunSection);
    }

    @Step("Checks if bun section is visible")
    public boolean isBunSectionVisible() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPageBunSection));
        WebElement bunSection = webDriver.findElement(mainPageBunSectionAfterClickLocator);
        return bunSection.isDisplayed();
    }

    @Step("Clicks on sauce section")
    public void clickMainPageSaucesSection() {
        clickElement(mainPageSaucesSection);
    }

    @Step("Check sauce section is visible")
    public boolean isSauceSectionVisible() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPageSaucesAfterClickLocator));
        WebElement sauceSection = webDriver.findElement(mainPageSaucesAfterClickLocator);
        return sauceSection.isDisplayed();
    }

    @Step("Clicks on fillings section")
    public void clickMainPageFillingsSection() {
        clickElement(mainPageFillingsSection);
    }

    @Step("Check filling section is visible")
    public boolean isFillingsSectionVisible() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPageFillingsSection));
        WebElement fillingsSection = webDriver.findElement(mainPageFillingsAfterClickLocator);
        return fillingsSection.isDisplayed();
    }

    @Step("Wait for the main page title to be visible")
    public void waitForVisibilityOfMainPageTitle() {
        waitForVisibility(makeBurgerLabelLocator);
    }

    @Step("Check if order page is visible")
    public boolean isMainPageOrderButtonVisible() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPageOrderButton));
        WebElement orderButton = webDriver.findElement(mainPageOrderButton);
        return orderButton.isDisplayed();
    }

}