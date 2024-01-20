package po;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends BasePage {
    private final By formNameInputField = By.xpath("//label[text()='Имя']/following-sibling::input");
    private final By formEmailInputField = By.xpath("//label[text()='Email']/following-sibling::input");
    private final By formPasswordInputField = By.xpath("//form[@class='Auth_form__3qKeq mb-20']//input[@type='password']");
    private final By formRegistrationButton = By.xpath("//button[contains(text(),'Зарегистрироваться')]");
    private final By formRegistrationLoginLink = By.xpath("//a[contains(text(), 'Войти')]");
    private final By errorMessageLocator = By.xpath("//p[contains(text(),'Некорректный пароль')]"); // Example locator, adjust as needed

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Open registration page")
    public void openRegistrationPage() {
        webDriver.get(REGISTRATION_PAGE_URL);
    }

    @Step("Fill out registration with name, email and password")
    public void fillInClientsRegistrationForm(String name, String email, String password) {
        setFormNameInputField(name);
        setFormEmailInputField(email);
        setFormPasswordInputField(password);
        clickElement(formRegistrationButton);
    }

    @Step("Input name")
    private void setFormNameInputField(String name) {
        enterText(formNameInputField, name);
    }

    @Step("Input name")
    private void setFormEmailInputField(String email) {
        enterText(formEmailInputField, email);
    }

    @Step("Input password")
    private void setFormPasswordInputField(String password) {
        enterText(formPasswordInputField, password);
    }

    @Step("Click on login link in the registration page")
    public void clickOnFormRegistrationLoginLink() {
        clickElement(formRegistrationLoginLink);
    }

    @Step("Check is error message is displayed")
    public boolean isErrorMessageDisplayed() {
        try {
            new WebDriverWait(webDriver, Duration.ofSeconds(4))
                    .until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
            return webDriver.findElement(errorMessageLocator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Take the text inside error message section")
    public String getErrorMessage() {
        return webDriver.findElement(errorMessageLocator).getText();
    }
}
