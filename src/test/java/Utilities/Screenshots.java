package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class ScreenshotUtil {

    private ScreenshotUtil() {}

    public static String capture(WebDriver driver, String testName) {
        try {
            Path dir = Paths.get("test-output", "screenshots");
            Files.createDirectories(dir);

            String safeName = testName.replaceAll("[^a-zA-Z0-9._-]", "_");
            Path destination = dir.resolve(safeName + "_" + System.currentTimeMillis() + ".png");

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(src.toPath(), destination);

            return destination.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
