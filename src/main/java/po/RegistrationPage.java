package po;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {
    By formNameInputField = By.xpath("//label[text()='Имя']/following-sibling::input");
    By formEmailInputField = By.xpath("//label[text()='Email']/following-sibling::input");
    By formPasswordInputField = By.xpath("//form[@class='Auth_form__3qKeq mb-20']//input[@type='password']");
    By formRegistrationButton = By.xpath("//button[contains(text(),'Зарегистрироваться')]");
    By formRegistrationLoginLink = By.xpath("//a[contains(text(), 'Войти')]");

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void openRegistrationPage() {
        webDriver.get(REGISTRATION_PAGE_URL);
    }
    public void fillInClientsRegistrationForm(String name, String email, String password) {
        setFormNameInputField(name);
        setFormEmailInputField(email);
        setFormPasswordInputField(password);
        clickElement(formRegistrationButton);
    }
    private void setFormNameInputField(String name) {
        enterText(formNameInputField, name);
    }
    private void setFormEmailInputField(String email) {
        enterText(formEmailInputField, email);
    }
    private void setFormPasswordInputField(String password) {
        enterText(formPasswordInputField, password);
    }
    public void clickOnFormRegistrationLoginLink() {
        clickElement(formRegistrationLoginLink);
    }
}