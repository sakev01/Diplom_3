import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import po.LoginPage;
import po.PersonalAccountPage;

import java.time.Duration;

import static po.BasePage.LOGIN_PAGE_URL;
import static po.BasePage.PERSONAL_MAIN_PAGE_URL;


public class PersonalAccountNavigationTest extends BaseTest {

    private final String testEmail = "Fetrst@yandex.ru";
    private final String testPassword = "12345678";

    @Test //Проверь переход по клику на «Личный кабинет».
    @DisplayName("Переход по клику на 'Личный кабинет'")
    public void navigationToPersonalAccount() throws InterruptedException {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();
        loginPage.loginOnLoginForm(testEmail, testPassword);
        loginPage.clickOnPersonalAccountButton();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.urlToBe(PROFILE_PAGE_URL));
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(PROFILE_PAGE_URL, currentUrl);

    }

    @Test //Проверь переход по клику на «Конструктор»
    @DisplayName("Переход из личного кабинета в конструктор по клику на 'Конструктор'")
    public void navigationFromPersonalAccountToConstructor() throws InterruptedException {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();
        loginPage.loginOnLoginForm(testEmail, testPassword);
        loginPage.clickOnPersonalAccountButton();
        loginPage.clickOnConstructorButton();
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(PERSONAL_MAIN_PAGE_URL, currentUrl);

    }

    @Test //Проверь переход по клику на логотип Stellar Burgers.
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип 'Stellar Burgers'")
    public void navigationFromPersonalAccountByClickOnStellarBurgerLogo() throws InterruptedException {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();
        loginPage.loginOnLoginForm(testEmail, testPassword);
        loginPage.clickOnPersonalAccountButton();
        loginPage.clickOnStellarBurgersLogo();
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(PERSONAL_MAIN_PAGE_URL, currentUrl);
    }

    @Test //Выход из аккаунта. Проверь выход по кнопке «Выйти» в личном кабинете.
    @DisplayName("Проверка выхода по кнопке 'Выйти'")
    public void navigationFromPersonalAccountByClickOnExit() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();
        loginPage.loginOnLoginForm(testEmail, testPassword);
        loginPage.clickOnPersonalAccountButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(webDriver);
        personalAccountPage.clickPersonalAccountExitButton();
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(LOGIN_PAGE_URL, currentUrl);
    }
}