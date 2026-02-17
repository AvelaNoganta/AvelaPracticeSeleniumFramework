package Basics;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginBasicsImproved extends BaseTest {

    @Test(priority = 1)
    public  void LoginToApplication() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class='user-pill']")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 2)
    public void verifyLoginPage() throws InterruptedException {
        String loginPageText = driver.findElement(By.xpath("//*[@id='login-heading']/span")).getText();
        assert loginPageText.equals("Access Learning Materials") : "Login page text does not match!";
        Thread.sleep(2000);
    }
    @Test(priority = 3)
    public  void enterUsernameAndPassword() throws InterruptedException {
        driver.findElement(By.id("login-email")).sendKeys("aveetestuser@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("Testing123456!");
        Thread.sleep(2000);
    }
    @Test(priority = 4)
    public void clickLoginButton() throws InterruptedException {
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(2000);
    }
}
