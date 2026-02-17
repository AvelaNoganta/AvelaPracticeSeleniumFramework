package Base;

import Pages.LoginPage;
import Pages.LoginPageWithWaits;
import Utilities.BrowserFactory;
import Utilities.Screenshots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

public class BaseTest {
    BrowserFactory browserFactory = new BrowserFactory();

    public final WebDriver driver = browserFactory.startBrowser("chrome", "https://www.ndosiautomation.co.za/");
    public LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);
    public LoginPageWithWaits loginPageWithWaits= PageFactory.initElements(driver, LoginPageWithWaits.class);
    public Screenshots takeScreenshots = new Screenshots();

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
