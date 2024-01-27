package po;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage extends BasePage {
    By loginPagePasswordResetLink = By.xpath("//button[contains(text(), 'Выход')]");

    public PersonalAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Clicks on on the exit button in personal account")
    public void clickPersonalAccountExitButton() {
        clickElement(loginPagePasswordResetLink);
    }
}