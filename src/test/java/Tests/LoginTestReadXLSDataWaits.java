package Tests;

import Base.BaseTest;
import Utilities.ReadXLSdata;
import org.testng.annotations.Test;

public class LoginTestReadXLSDataWaits extends BaseTest {
    @Test(priority = 1)
    public void LoginToApplication() throws InterruptedException {
        loginPageWithWaits.clickLoginButton();
        screenshots.takesSnapShot(driver, "LoginToApplication");
    }


    @Test(priority = 2,dataProviderClass = ReadXLSdata.class,dataProvider = "testData")
    public void enterUsernameAndPassword(String username, String password) throws InterruptedException {
        loginPageWithWaits.enterEmailAddress(username);
        loginPageWithWaits.enterPassword(password);
        screenshots.takesSnapShot(driver, "enterUsernameAndPassword");
    }

    @Test(priority = 3)
    public void clickLoginButton() throws InterruptedException {
        loginPageWithWaits.clickSubmitButton();
        screenshots.takesSnapShot(driver, "clickLoginButton");
    }
    @Test(priority = 4)
    public void verifyLoginPage() throws InterruptedException {
        loginPageWithWaits.verifyLoginSuccess("Here's an overview of your learning journey");
        screenshots.takesSnapShot(driver, "verifyLoginPage");
    }
}
