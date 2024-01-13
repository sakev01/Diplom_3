import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/*Переход в личный кабинет
        Проверь переход по клику на «Личный кабинет».
        Переход из личного кабинета в конструктор
        Проверь переход по клику на «Конструктор» и на логотип Stellar Burgers.*/
public class PersonalAccountTest {
    private WebDriver webDriver;
    @Before
    public void startBrowser(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }
    @After
    public void closeBrowser(){
        webDriver.quit();
    }

    @Test
    public void clickToGetToPersonalAccount(){
        webDriver.get("https://stellarburgers.nomoreparties.site");
        //login
        WebElement mainPageLoginButton = webDriver.findElement(By.xpath("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']"));
        mainPageLoginButton.click();
    }
}
