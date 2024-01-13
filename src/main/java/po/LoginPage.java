package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    By titleLoginOnLoginForm = By.xpath("//h2[text()='Вход']");
    By incorrectPasswordNotification = By.xpath("//p[contains(text(),'Некорректный пароль')]");
    By formEmailInputField = By.xpath("//input[@class='text input__textfield text_type_main-default' and @name='name']");
    By formPasswordInputField = By.xpath("//form[@class='Auth_form__3qKeq mb-20']//input[@type='password']");
    By loginPageButton = By.xpath("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    By loginPagePasswordResetLink = By.xpath("//a[contains(text(), 'Восстановить пароль')]");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage() {
        webDriver.get(LOGIN_PAGE_URL);
    }

/*    public void loginOnLoginForm(String email, String password) {
        setFormEmailInputField(email);
        setFormPasswordInputField(password);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(4));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginPageButton));
        loginButton.click();
    }*/
    public void loginOnLoginForm(String email, String password) {
        setFormEmailInputField(email);
        setFormPasswordInputField(password);
        clickElement(loginPageButton); // Using the improved clickElement method
    }

    private void setFormEmailInputField(String email) {
        enterText(formEmailInputField, email);
    }

    public void setFormPasswordInputField(String password) {
        enterText(formPasswordInputField, password);
    }

    public void clickLoginPagePasswordResetLink() {
        clickElement(loginPagePasswordResetLink);
    }
}