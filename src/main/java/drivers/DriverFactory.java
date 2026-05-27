package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> tl = new ThreadLocal<>();

    public static void initDriver() {

        WebDriverManager.chromedriver().setup();

        tl.set(new ChromeDriver());

        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return tl.get();
    }

    public static void quitDriver() {

        if(getDriver()!=null) {
            getDriver().quit();
            tl.remove();
        }
    }
}