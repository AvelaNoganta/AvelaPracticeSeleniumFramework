package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    WebDriver driver;



    @FindBy(xpath = "//button[@class='user-pill']")
    WebElement login_button;

    @FindBy(xpath = "//*[@id='login-heading']/span")
    WebElement loginPage_title;

    @FindBy(id = "login-email")
    WebElement login_email_field;

    @FindBy(id = "login-password")
    WebElement login_password_field;

    @FindBy(id = "login-submit")
    WebElement login_submit_button;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickLoginButton() {
        login_button.click();
    }

    public void enterEmailAddress(String email) {
        login_email_field.sendKeys(email);
    }

    public void enterPassword(String password) {
        login_password_field.sendKeys(password);
    }

    public void verifyLoginPageIsDisplayed() {
        loginPage_title.isDisplayed();
    }

    public void clickSubmitButton() {
        login_submit_button.click();
    }


}
