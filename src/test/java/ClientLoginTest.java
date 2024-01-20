import api.UserData;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import po.*;

import static driver.WebDriverCreator.createWebDriver;
import static org.junit.Assert.assertTrue;

public class ClientLoginTest {
    WebDriver webDriver;
    private String testEmail;
    private final String testPassword = "12345678"; // Example password
    private final String testName = "Test User";
    private String accessToken;

    @Before
    public void setUp() {
        webDriver = createWebDriver();
        WebDriverManager.chromedriver().setup();
//        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        // Generate unique email for the test user
        testEmail = "testuser" + System.currentTimeMillis() + "@example.com";

        // Create test user via API
        Response createUserResponse = UserData.createUser(testEmail, testPassword, testName);
        if (createUserResponse.getStatusCode() == 200) {
            // Login and get access token
            Response loginResponse = UserData.loginUser(testEmail, testPassword);
            accessToken = loginResponse.path("accessToken");
        }
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            UserData.deleteUser("Bearer " + accessToken);
        }


        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной странице")
    public void clientAccessViaMainPageLoginButton() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.openMainPage();
        mainPage.clickOnMainPageLoginButton();
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginOnLoginForm(testEmail, testPassword);
        mainPage.waitForVisibilityOfMainPageTitle();
        Boolean isDisplayedNotMainPageOrderButton = mainPage.isMainPageOrderButtonVisible();
        assertTrue(isDisplayedNotMainPageOrderButton);
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void clientAccessViaPersonalAccountLoginButton() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.openMainPage();
        BasePage basePage = new BasePage(webDriver);
        basePage.clickOnPersonalAccountButton();
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginOnLoginForm(testEmail, testPassword);
        mainPage.waitForVisibilityOfMainPageTitle();
        Boolean isDisplayedNotMainPageOrderButton = mainPage.isMainPageOrderButtonVisible();
        assertTrue(isDisplayedNotMainPageOrderButton);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void clientAccessViaRegistrationFormLoginButton() {
        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        registrationPage.openRegistrationPage();
        registrationPage.clickOnFormRegistrationLoginLink();
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginOnLoginForm(testEmail, testPassword);
        MainPage mainPage = new MainPage(webDriver);
        mainPage.waitForVisibilityOfMainPageTitle();
        Boolean isDisplayedNotMainPageOrderButton = mainPage.isMainPageOrderButtonVisible();
        assertTrue(isDisplayedNotMainPageOrderButton);
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void clientAccessViaPasswordResetFormLoginButton() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(webDriver);
        forgotPasswordPage.openForgotPasswordPage();
        forgotPasswordPage.clickOnForgotPasswordPageLoginButton();
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginOnLoginForm(testEmail, testPassword);
        MainPage mainPage = new MainPage(webDriver);
        mainPage.waitForVisibilityOfMainPageTitle();
        Boolean isDisplayedNotMainPageOrderButton = mainPage.isMainPageOrderButtonVisible();
        assertTrue(isDisplayedNotMainPageOrderButton);
    }

}
