package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage {
    By forgotPasswordPageLoginButton = By.xpath("//a[contains(text(), 'Войти') and contains(@class, 'Auth_link__1fOlj')]");

    public ForgotPasswordPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openForgotPasswordPage() {
        webDriver.get(FORGOT_PASSWORD_PAGE_URL);
    }

    public void clickOnForgotPasswordPageLoginButton() {
        clickElement(forgotPasswordPageLoginButton);
    }

}