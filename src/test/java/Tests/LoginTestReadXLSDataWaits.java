package Tests;

import Base.BaseTest;
import Utilities.ReadXLSdata;
import org.testng.annotations.Test;

public class LoginTestReadXLSData extends BaseTest {
    @Test(priority = 1)
    public void LoginToApplication() throws InterruptedException {
       loginPage.clickLoginButton();
        Thread.sleep(2000);
        takeScreenshots.takesSnapShot(driver, "LoginToApplication");
    }

    @Test(priority = 2)
    public void verifyLoginPage() throws InterruptedException {
        loginPage.verifyLoginPageIsDisplayed();
    }

    @Test(priority = 3,dataProviderClass = ReadXLSdata.class,dataProvider = "testData")
    public void enterUsernameAndPassword(String username, String password) throws InterruptedException {
        loginPage.enterEmailAddress(username);
        loginPage.enterPassword(password);
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void clickLoginButton() throws InterruptedException {
        loginPage.clickSubmitButton();
        Thread.sleep(2000);
    }
}
