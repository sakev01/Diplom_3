import org.junit.Assert;
import org.junit.Test;
import po.MainPage;

public class ConstructorNavigationTest extends BaseTest{

    @Test
    public void clickSauceToCheckNavigation() throws InterruptedException {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.openMainPage();
        mainPage.clickMainPageSaucesSection();
        boolean isSauceSectionVisible = mainPage.isSauceSectionVisible();
        Assert.assertTrue("The 'Соусы' section should be visible", isSauceSectionVisible);
    }
    @Test
    public void clickBunToCheckNavigation() throws InterruptedException {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.openMainPage();
        mainPage.clickMainPageSaucesSection();
        boolean isBunSectionVisible = mainPage.isSauceSectionVisible();
        Assert.assertTrue("The 'Булки' section should be visible", isBunSectionVisible);
    }
    @Test
    public void clickFillingsToCheckNavigation() throws InterruptedException {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.openMainPage();
        mainPage.clickMainPageFillingsSection();
        boolean isFillingsSectionVisible = mainPage.isSauceSectionVisible();
        Assert.assertTrue("The 'Начинка' section should be visible", isFillingsSectionVisible);
}
}
