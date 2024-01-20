package po;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    By formEmailInputField = By.xpath("//input[@class='text input__textfield text_type_main-default' and @name='name']");
    By formPasswordInputField = By.xpath("//form[@class='Auth_form__3qKeq mb-20']//input[@type='password']");
    By loginPageButton = By.xpath("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Opens login page")
    public void openLoginPage() {
        webDriver.get(LOGIN_PAGE_URL);
    }

    @Step("Login with email and password")
    public void loginOnLoginForm(String email, String password) {
        setFormEmailInputField(email);
        setFormPasswordInputField(password);
        clickElement(loginPageButton);
    }

    @Step("Inputs email")
    private void setFormEmailInputField(String email) {
        enterText(formEmailInputField, email);
    }

    @Step("Inputs password")
    public void setFormPasswordInputField(String password) {
        enterText(formPasswordInputField, password);
    }

    @Step("Waits for login page to be loaded")
    public void waitForURL() {
        new WebDriverWait(webDriver, Duration.ofSeconds(4))
                .until(ExpectedConditions.urlToBe(BasePage.LOGIN_PAGE_URL));
    }
}