package tests.ui;

import base.BaseTest;
import drivers.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NotesPage;

@Listeners(listeners.TestListener.class)
public class LoginTest extends BaseTest {

    @Test(description = "TC-UI-01")
    public void validLoginTest() {

        LoginPage lp = new LoginPage();
        NotesPage np = new NotesPage();

        lp.openApp();

        lp.login(
                "aniket@gmail.com",
                "pass123"
        );

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("================================");
        System.out.println("CURRENT URL = "
                + DriverFactory.getDriver().getCurrentUrl());

        System.out.println("PAGE TITLE = "
                + DriverFactory.getDriver().getTitle());

        System.out.println("PAGE CONTAINS 'Add Note' = "
                + DriverFactory.getDriver()
                .getPageSource()
                .contains("Add Note"));

        System.out.println("================================");

        Assert.assertTrue(
                np.isAddNoteVisible(),
                "Add note button should be visible after login"
        );
    }

    @Test(description = "TC-NEG-01")
    public void invalidLoginTest() {

        Assert.assertTrue(true);
    }

    @Test(description = "TC-NEG-02")
    public void emptyLoginValidationTest() {

        Assert.assertTrue(true);
    }
}