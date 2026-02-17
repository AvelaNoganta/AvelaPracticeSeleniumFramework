package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginBasics {
    WebDriver driver;

    @BeforeTest
    public void launchBrowser() {
        driver = new ChromeDriver();
    }
    @Test(priority = 0)
    public void  navigateToUrl() throws InterruptedException {
        driver.get("https://ndosisimplifiedautomation.vercel.app/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }
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
    @AfterTest
    public void  quitBrowser() {
        driver.quit();
    }
}
