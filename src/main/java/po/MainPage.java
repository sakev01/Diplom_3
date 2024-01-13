package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {
    private By mainPageLoginButton = By.xpath("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");

    private By mainPageBunSection = By.xpath("//div[span[text()='Булки']]");
    private By mainPageBunSectionAfterClickLocator = By.xpath("//div[contains(@class, 'tab_tab_type_current__2BEPc') and span[text()='Булки']]");
    private By mainPageSaucesSection = By.xpath("//div[span[text()='Соусы']]");
    private By mainPageSaucesAfterClickLocator = By.xpath("//div[contains(@class, 'tab_tab_type_current__2BEPc') and span[text()='Соусы']]");

    private By mainPageFillingsSection = By.xpath("//div[span[text()='Начинки']]");
    private By mainPageFillingsAfterClickLocator = By.xpath("//div[contains(@class, 'tab_tab_type_current__2BEPc') and span[text()='Начинки']]");

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openMainPage() {
        webDriver.get(MAIN_PAGE_URL);
    }
    public void clickOnMainPageLoginButton() {
        clickElement(mainPageLoginButton);
    }
    public void clickOnMainPageBunSection(){
        clickElement(mainPageBunSection);
    }
    public boolean isBunSectionVisible() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPageBunSectionAfterClickLocator));
        WebElement sauceSection = webDriver.findElement(mainPageBunSectionAfterClickLocator);
        return sauceSection.isDisplayed();
    }
    public void clickMainPageSaucesSection(){
        clickElement(mainPageSaucesSection);
    }
    public boolean isSauceSectionVisible() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPageSaucesAfterClickLocator));
        WebElement sauceSection = webDriver.findElement(mainPageSaucesAfterClickLocator);
        return sauceSection.isDisplayed();
    }
    public void clickMainPageFillingsSection(){
        clickElement(mainPageFillingsSection);
    }
    public boolean isFillingsSectionVisible() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPageFillingsAfterClickLocator));
        WebElement sauceSection = webDriver.findElement(mainPageBunSectionAfterClickLocator);
        return sauceSection.isDisplayed();
    }
}