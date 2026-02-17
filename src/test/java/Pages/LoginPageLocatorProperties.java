package Pages;

import Base.BaseTestLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPageLocatorProperties extends BaseTestLocators  {

    WebDriver driver;
    private By loginBtn = By.xpath(locatorsProperties.getProperty("login_button"));
    private By loginPageTitle = By.xpath(locatorsProperties.getProperty("loginPage_title"));
    private By loginUsernameField = By.id(locatorsProperties.getProperty("login_username_field"));
    private By loginPasswordField = By.id(locatorsProperties.getProperty("login_password_field"));
    private By loginSubmitButton = By.id(locatorsProperties.getProperty("login_submit_button"));

    public LoginPageLocatorProperties(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }
    public void  verifyLoginPageTitle() {
        driver.findElement(loginPageTitle).isDisplayed();
    }
    public void enterUsername(String username) {
        driver.findElement(loginUsernameField).sendKeys(username);
    }
    public void enterPassword(String password) {
        driver.findElement(loginPasswordField).sendKeys(password);
    }
    public void clickSubmit() {
        driver.findElement(loginSubmitButton).click();
    }
}
