
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import po.*;

import java.time.Duration;

/*      Вход
        Проверь:
        вход по кнопке «Войти в аккаунт» на главной,
        вход через кнопку «Личный кабинет»,
        вход через кнопку в форме регистрации,
        вход через кнопку в форме восстановления пароля.*/
public class ClientLoginTest extends BaseTest {

    private final String commonXPathToCheck = "//h1[@class='text text_type_main-large mb-5 mt-10']";


    private void performLoginAndCheck(String email, String password) {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginOnLoginForm(email, password);
        new WebDriverWait(webDriver, Duration.ofSeconds(4))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(commonXPathToCheck)));
        Assert.assertTrue(webDriver.findElement(By.xpath(commonXPathToCheck)).isDisplayed());
    }

    @Test
    public void clientAccessViaMainPageLoginButton() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.openMainPage();
        mainPage.clickOnMainPageLoginButton();
        performLoginAndCheck("Fetrst@yandex.ru", "12345678");
    }

    @Test
    public void clientAccessViaPersonalAccountLoginButton() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.openMainPage();
        BasePage basePage = new BasePage(webDriver);
        basePage.clickOnPersonalAccountButton();
        performLoginAndCheck("Fetrst@yandex.ru", "12345678");
    }

    @Test
    public void clientAccessViaRegistrationFormLoginButton() {
        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        registrationPage.openRegistrationPage();
        registrationPage.clickOnFormRegistrationLoginLink();
        performLoginAndCheck("Fetrst@yandex.ru", "12345678");
    }

    @Test
    public void clientAccessViaPasswordResetFormLoginButton() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(webDriver);
        forgotPasswordPage.openForgotPasswordPage();
        forgotPasswordPage.clickOnForgotPasswordPageLoginButton();
        performLoginAndCheck("Fetrst@yandex.ru", "12345678");
    }
}