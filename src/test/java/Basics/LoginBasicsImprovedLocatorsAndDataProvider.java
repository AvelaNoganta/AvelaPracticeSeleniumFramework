package Basics;

import Base.BaseTestLocators;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginBasicsImprovedLocatorsAndDataProvider extends BaseTestLocators {

    @Test(priority = 1)
    public void LoginToApplication() throws InterruptedException {
        driver.findElement(By.xpath(locatorsProperties.getProperty("login_button"))).click();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void verifyLoginPage() throws InterruptedException {
        String loginPageText = driver.findElement(By.xpath(locatorsProperties.getProperty("loginPage_title"))).getText();
        assert loginPageText.equals("Access Learning Materials") : "Login page text does not match!";
        Thread.sleep(2000);
    }

    @Test(priority = 3,dataProvider = "testdata")
    public void enterUsernameAndPassword(String username, String password) throws InterruptedException {
        driver.findElement(By.id(locatorsProperties.getProperty("login_username_field"))).sendKeys(username);
        driver.findElement(By.id(locatorsProperties.getProperty("login_password_field"))).sendKeys(password);
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void clickLoginButton() throws InterruptedException {
        driver.findElement(By.id(locatorsProperties.getProperty("login_submit_button"))).click();
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