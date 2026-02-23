package Base;

import Pages.LoginPage;
import Pages.LoginPageWithWaits;
import Utilities.BrowserFactory;
import Utilities.Screenshots;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected LoginPageWithWaits loginPageWithWaits;
    protected Screenshots screenshots;  // ✅ declare here

    public final String url = "https://ndosisimplifiedautomation.vercel.app/";
    public final String browserChoice = "chrome";

    @BeforeClass
    public void setUp() {
        driver = BrowserFactory.startBrowser(browserChoice, url);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        loginPage = new LoginPage(driver);
        loginPageWithWaits = new LoginPageWithWaits(driver);
        screenshots = new Screenshots();  // ✅ initialize here
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
