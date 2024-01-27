import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import po.BasePage;
import po.LoginPage;
import po.RegistrationPage;

public class ClientRegistrationTest extends BaseTest {

    private final Faker faker = new Faker();
    @Test  // Successful registration test
    @DisplayName("Проверка успешной регистрации")
    public void clientCreationSuccessful() {
        String randomName = faker.name().username();
        String randomEmail = faker.internet().emailAddress();
        String randomPassword = faker.internet().password();
        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        registrationPage.openRegistrationPage();
        registrationPage.fillInClientsRegistrationForm(randomName, randomEmail, randomPassword);
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.waitForURL();
        Assert.assertEquals(BasePage.LOGIN_PAGE_URL, webDriver.getCurrentUrl());
    }

    @Test // Test for incorrect password length
    @DisplayName("Проверка входа с некорректным паролем")
    public void clientCreationWithIncorrectPasswordLength() {
        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        registrationPage.openRegistrationPage();
        registrationPage.fillInClientsRegistrationForm("NIUser", "netrewwser@example.com", "12345");
        boolean isErrorMessageDisplayed = registrationPage.isErrorMessageDisplayed();
        Assert.assertTrue("Error message should be displayed for incorrect password length", isErrorMessageDisplayed);
        String expectedErrorMessage = "Некорректный пароль";
        Assert.assertEquals("Error message text does not match", expectedErrorMessage, registrationPage.getErrorMessage());
    }
}
