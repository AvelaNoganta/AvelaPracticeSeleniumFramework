package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageWithWaits {


    WebDriver driver;
    private final WebDriverWait wait;

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

    public LoginPageWithWaits(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver passed to LoginPageWithWaits is null. Initialize driver before creating the page object.");
        }
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(login_button));
        login_button.click();
    }

    public void enterEmailAddress(String email) {
        wait.until(ExpectedConditions.visibilityOf(login_email_field));
        login_email_field.clear();
        login_email_field.sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(login_password_field));
        login_password_field.clear();
        login_password_field.sendKeys(password);
    }

    public void verifyLoginPageIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(loginPage_title));
        loginPage_title.isDisplayed();
    }

    public void clickSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(login_submit_button));
        login_submit_button.click();
    }


}
