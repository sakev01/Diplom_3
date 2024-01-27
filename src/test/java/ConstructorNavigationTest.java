import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import po.MainPage;

public class ConstructorNavigationTest extends BaseTest {

    @Test
    @DisplayName("Проверка перехода в раздел 'Соусы'")
    public void clickSauceToCheckNavigation() throws InterruptedException {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.openMainPage();
        mainPage.clickMainPageSaucesSection();
        boolean isSauceSectionVisible = mainPage.isSauceSectionVisible();
        Assert.assertTrue("The 'Соусы' section should be visible", isSauceSectionVisible);
    }

    @Test
    @DisplayName("Проверка перехода в раздел 'Булки'")
    public void clickBunToCheckNavigation() throws InterruptedException {
        Thread.sleep(200);
        MainPage mainPage = new MainPage(webDriver);
        mainPage.openMainPage();
        mainPage.clickOnMainPageBunSection();
        boolean isBunSectionVisible = mainPage.isBunSectionVisible();
        Assert.assertTrue("The 'Булки' section should be visible", isBunSectionVisible);
    }

    @Test
    @DisplayName("Проверка перехода в раздел 'Начинки'")
    public void clickFillingsToCheckNavigation() throws InterruptedException {
        Thread.sleep(200);
        MainPage mainPage = new MainPage(webDriver);
        mainPage.openMainPage();
        mainPage.clickMainPageFillingsSection();
        boolean isFillingsSectionVisible = mainPage.isFillingsSectionVisible();
        Assert.assertTrue("The 'Начинка' section should be visible", isFillingsSectionVisible);
    }
}
