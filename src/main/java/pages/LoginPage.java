package pages;

import base.BasePage;
import drivers.DriverFactory;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By loginBtnHome =
            By.linkText("Login");

    private final By email =
            By.id("email");

    private final By password =
            By.xpath("//input[@type='password']");

    private final By submitBtn =
            By.xpath("//button[@type='submit']");

    public void openApp() {

        DriverFactory.getDriver().get(
                "https://practice.expandtesting.com/notes/app"
        );
    }

    public void login(
            String mail,
            String pass) {

        click(loginBtnHome);

        type(email,mail);

        type(password,pass);

        click(submitBtn);
    }
}