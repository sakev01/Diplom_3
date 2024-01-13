import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import po.LoginPage;
import po.PersonalAccountPage;


import java.time.Duration;


/*      Переход в личный кабинет
        Проверь переход по клику на «Личный кабинет».
        Переход из личного кабинета в конструктор
        Проверь переход по клику на «Конструктор» и на логотип Stellar Burgers.
        Выход из аккаунта. Проверь выход по кнопке «Выйти» в личном кабинете.

        */

public class PersonalAccountNavigationTest extends BaseTest {


    @Test //Проверь переход по клику на «Личный кабинет».
    public void navigationToPersonalAccount() throws InterruptedException {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();
        loginPage.loginOnLoginForm("Fetrst@yandex.ru", "12345678");
        loginPage.clickOnPersonalAccountButton();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/account/profile"));
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/account/profile", currentUrl);

    }
    @Test //Проверь переход по клику на «Конструктор»
    public void navigationFromPersonalAccountToConstructor() throws InterruptedException {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();
        loginPage.loginOnLoginForm("Fetrst@yandex.ru", "12345678");
        loginPage.clickOnPersonalAccountButton();
        loginPage.clickOnConstructorButton();
        WebElement pageTitle = webDriver.findElement(By.xpath("//a[contains(@class, 'AppHeader_header__link__3D_hX') and @href='/']"));
        Assert.assertTrue("Element should be visible", pageTitle.isDisplayed());
    }
    @Test //Проверь переход по клику на логотип Stellar Burgers.
    public void navigationFromPersonalAccountByClickOnStellarBurgerLogo() throws InterruptedException {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();
        loginPage.loginOnLoginForm("Fetrst@yandex.ru", "12345678");
        loginPage.clickOnPersonalAccountButton();
        loginPage.clickOnStellarBurgersLogo();
        WebElement pageTitle = webDriver.findElement(By.xpath("//a[contains(@class, 'AppHeader_header__link__3D_hX') and @href='/']"));
        Assert.assertTrue("Element should be visible", pageTitle.isDisplayed());
    }
    @Test //Выход из аккаунта. Проверь выход по кнопке «Выйти» в личном кабинете.
    public void navigationFromPersonalAccountByClickOnExit(){
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();
        loginPage.loginOnLoginForm("Fetrst@yandex.ru", "12345678");
        loginPage.clickOnPersonalAccountButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(webDriver);
        personalAccountPage.clickPersonalAccountExitButton();
        WebElement pageTitle = webDriver.findElement(By.xpath("//a[contains(@class, 'AppHeader_header__link__3D_hX') and @href='/']"));
        Assert.assertTrue("Element should be visible", pageTitle.isDisplayed());

    }
}