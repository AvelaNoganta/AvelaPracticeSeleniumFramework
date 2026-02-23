package Tests;

import Base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void LoginToApplication() throws InterruptedException {
       loginPage.clickLoginButton();
        Thread.sleep(2000);
        //takeScreenshots.takesSnapShot(driver, "LoginToApplication");
    }

    @Test(priority = 2)
    public void verifyLoginPage() throws InterruptedException {
        loginPage.verifyLoginPageIsDisplayed();
        //takeScreenshots.takesSnapShot(driver, "verifyLoginPage");
    }

    @Test(priority = 3,dataProvider = "testdata")
    public void enterUsernameAndPassword(String username, String password) throws InterruptedException {
        loginPage.enterEmailAddress(username);
        loginPage.enterPassword(password);
        //takeScreenshots.takesSnapShot(driver, "enterUsernameAndPassword");
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void clickLoginButton() throws InterruptedException {
        loginPage.clickSubmitButton();
        Thread.sleep(2000);
        //takeScreenshots.takesSnapShot(driver, "clickLoginButton");
    }

    @DataProvider(name = "testdata")
    public Object[][] getData() {
        return new Object[][]{
                //You can repeat the same username and password or add more sets of credentials for testing
                {"aveetestuser@gmail.com", "Testing123456"}
        };
    }
}
