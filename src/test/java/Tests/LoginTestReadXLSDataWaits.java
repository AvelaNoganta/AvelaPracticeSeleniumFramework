package Tests;

import Base.BaseTest;
import Utilities.ReadXLSdata;
import org.testng.annotations.Test;

public class LoginTestReadXLSDataWaits extends BaseTest {
    @Test(priority = 1)
    public void LoginToApplication() throws InterruptedException {
        loginPageWithWaits.clickLoginButton();
        takeScreenshots.takesSnapShot(driver, "LoginToApplication");
    }

    @Test(priority = 2)
    public void verifyLoginPage() throws InterruptedException {
        loginPageWithWaits.verifyLoginPageIsDisplayed();
    }

    @Test(priority = 3,dataProviderClass = ReadXLSdata.class,dataProvider = "testData")
    public void enterUsernameAndPassword(String username, String password) throws InterruptedException {
        loginPageWithWaits.enterEmailAddress(username);
        loginPageWithWaits.enterPassword(password);
    }

    @Test(priority = 4)
    public void clickLoginButton() throws InterruptedException {
        loginPageWithWaits.clickSubmitButton();
    }
}
