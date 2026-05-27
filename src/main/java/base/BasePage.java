package base;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.WaitUtility;

public class BasePage {

    public void click(By locator) {

        WaitUtility.waitForElement(locator);

        WebElement element =
                DriverFactory.getDriver()
                        .findElement(locator);

        JavascriptExecutor js =
                (JavascriptExecutor)
                        DriverFactory.getDriver();

        js.executeScript(
                "arguments[0].click();",
                element
        );
    }

    public void type(By locator,String text) {

        WaitUtility.waitForElement(locator);

        WebElement element =
                DriverFactory.getDriver()
                        .findElement(locator);

        element.clear();

        element.sendKeys(text);
    }

    public String getText(By locator) {

        WaitUtility.waitForElement(locator);

        return DriverFactory.getDriver()
                .findElement(locator)
                .getText();
    }

    public WebElement find(By locator) {

        WaitUtility.waitForElement(locator);

        return DriverFactory.getDriver()
                .findElement(locator);
    }
}