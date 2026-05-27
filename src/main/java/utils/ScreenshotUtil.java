package utils;

import drivers.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class ScreenshotUtil {

    public static void capture(String name) {

        try {

            File src =
                    ((TakesScreenshot)
                            DriverFactory.getDriver())
                            .getScreenshotAs(
                                    OutputType.FILE);

            File dest =
                    new File(
                            "screenshots/"
                                    + name + ".png");

            FileUtils.copyFile(src,dest);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}