package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTestLocators {
    protected WebDriver driver;
    public static Properties locatorsProperties = new Properties();
    public static FileReader locatorsFileReader;

    @BeforeTest
    public void Setup() throws IOException {
        if (driver == null) {
            locatorsFileReader = new FileReader(System.getProperty("user.dir") +
                    "/src/test/resources/ConfigFiles/locators.properties");
            locatorsProperties.load(locatorsFileReader);
//            try (InputStream inputStream = getClass().getClassLoader()
//                    .getResourceAsStream("ConfigFiles/config.properties")) {
//
//                if (inputStream == null) {
//                    throw new RuntimeException("config.properties not found. Put it in: src/test/resources/ConfigFiles/config.properties");
//                }
//
//                properties.load(inputStream);
//            }
        }
        if (locatorsProperties.getProperty("browser").equalsIgnoreCase("chrome")) {
            // Initialize Chrome driver
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (locatorsProperties.getProperty("browser").equalsIgnoreCase("firefox")) {
            // Initialize Firefox driver
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(locatorsProperties.getProperty("BaseUrl"));
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}


