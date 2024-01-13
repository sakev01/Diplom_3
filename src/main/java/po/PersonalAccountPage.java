package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage extends BasePage {
    By loginPagePasswordResetLink = By.xpath("//button[contains(text(), 'Выход')]");

    public PersonalAccountPage(WebDriver webDriver) {
        super(webDriver);
    }
     public void clickPersonalAccountExitButton(){
        clickElement(loginPagePasswordResetLink);
}
}