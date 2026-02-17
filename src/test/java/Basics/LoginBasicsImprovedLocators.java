package Basics;

import Base.BaseTest;
import Base.BaseTestLocators;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginBasicsImprovedLocators extends BaseTestLocators {

    @Test(priority = 1)
    public  void LoginToApplication() throws InterruptedException {
        driver.findElement(By.xpath(locatorsProperties.getProperty("login_button"))).click();
        Thread.sleep(2000);
    }
    @Test(priority = 2)
    public void verifyLoginPage() throws InterruptedException {
        String loginPageText = driver.findElement(By.xpath(locatorsProperties.getProperty("loginPage_title"))).getText();
        assert loginPageText.equals("Access Learning Materials") : "Login page text does not match!";
        Thread.sleep(2000);
    }
    @Test(priority = 3)
    public  void enterUsernameAndPassword() throws InterruptedException {
        driver.findElement(By.id(locatorsProperties.getProperty("login_username_field"))).sendKeys("aveetestuser@gmail.com");
        driver.findElement(By.id(locatorsProperties.getProperty("login_password_field"))).sendKeys("Testing123456!");
        Thread.sleep(2000);
    }
    @Test(priority = 4)
    public void clickLoginButton() throws InterruptedException {
        driver.findElement(By.id(locatorsProperties.getProperty("login_submit_button"))).click();
        Thread.sleep(2000);
    }
}
