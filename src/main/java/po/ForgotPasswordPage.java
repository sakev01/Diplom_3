package po;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage {
    By forgotPasswordPageLoginButton = By.xpath("//a[contains(text(), 'Войти') and contains(@class, 'Auth_link__1fOlj')]");

    public ForgotPasswordPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Opens forgot password page")
    public void openForgotPasswordPage() {
        webDriver.get(FORGOT_PASSWORD_PAGE_URL);
    }

    @Step("Clicks on the forgot password button")
    public void clickOnForgotPasswordPageLoginButton() {
        clickElement(forgotPasswordPageLoginButton);
    }

}