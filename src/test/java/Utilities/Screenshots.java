package Utilities; // package for utility helpers

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType; // OutputType enum for screenshot formats
import org.openqa.selenium.TakesScreenshot; // interface for drivers that can take screenshots
import org.openqa.selenium.WebDriver; // WebDriver interface

import java.io.File; // File class for file operations
import java.nio.file.Files; // Files utility for file operations
import java.nio.file.Path; // Path type for file paths
import java.nio.file.Paths; // Paths helper to build Path

public final class Screenshots { // utility class for capturing screenshots

    private static final String screenshotDir = System.getProperty("user.dir") + "/target/screenshots";


    public void takesSnapShot(WebDriver driver, String screenshotName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        System.out.printf("FileDir: ", screenshotDir);
        File destination = new File(screenshotDir, screenshotName + ".jpeg");

        try {
            FileUtils.copyFile(src, destination);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
