import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import po.*;

import java.time.Duration;

public class ClientRegistrationTest extends BaseTest {


    @Test  // Successful registration test
    public void clientCreationSuccessful() {
        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        registrationPage.openRegistrationPage();
        registrationPage.fillInClientsRegistrationForm("NewЦUser", "newuЦser@example.com", "password123");
        new WebDriverWait(webDriver, Duration.ofSeconds(4))
                .until(ExpectedConditions.urlToBe(BasePage.LOGIN_PAGE_URL));
        Assert.assertEquals(BasePage.LOGIN_PAGE_URL, webDriver.getCurrentUrl());
    }


    @Test // Test for incorrect password length
    public void clientCreationWithIncorrectPasswordLength() {
        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        registrationPage.openRegistrationPage();
        registrationPage.fillInClientsRegistrationForm("NewUser", "newuser@example.com", "12345");
        WebElement passwordError = webDriver.findElement(By.xpath("//p[contains(text(),'Некорректный пароль')]"));
        Assert.assertTrue(passwordError.isDisplayed());
    }
}