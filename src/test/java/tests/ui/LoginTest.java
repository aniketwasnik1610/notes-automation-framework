package tests.ui;

import base.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

@Listeners(listeners.TestListener.class)
public class LoginTest extends BaseTest {

    @Test(
            retryAnalyzer =
                    utils.RetryAnalyzer.class
    )
    public void validLoginTest() {

        LoginPage lp =
                new LoginPage();

        lp.openApp();

        lp.login(
                "aniket@gmail.com",
                "pass123"
        );
    }
}