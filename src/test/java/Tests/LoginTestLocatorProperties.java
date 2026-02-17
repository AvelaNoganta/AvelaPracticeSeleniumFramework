package Tests;

import Base.BaseTestLocators;
import Pages.LoginPageLocatorProperties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTestLocatorProperties extends BaseTestLocators {

    LoginPageLocatorProperties loginPageLocatorProperties;

    @BeforeMethod
    public void initPage() {
        // Initialize page object after the WebDriver has been created
        loginPageLocatorProperties = new LoginPageLocatorProperties(driver);
    }

    @Test(priority = 1)
    public void clickLoginButton(){
        loginPageLocatorProperties.clickLogin();
    }
    @Test(priority = 2)
    public void verifyLoginPage(){
        loginPageLocatorProperties.verifyLoginPageTitle();
    }
    @Test(priority = 3,dataProvider = "testdata")
    public void enterUsernameAndPassword(String username, String password) throws InterruptedException {
        loginPageLocatorProperties.enterUsername(username);
        loginPageLocatorProperties.enterPassword(password);
        Thread.sleep(2000);
    }
    @Test(priority = 4)
    public void clickSubmitButton() throws InterruptedException {
        loginPageLocatorProperties.clickSubmit();
        Thread.sleep(2000);
    }


    @DataProvider(name = "testdata")
    public Object[][] getData() {
        return new Object[][]{
                //You can repeat the same username and password or add more sets of credentials for testing
                {"aveetestuser@gmail.com", "Testing123456"}
        };
    }
}
