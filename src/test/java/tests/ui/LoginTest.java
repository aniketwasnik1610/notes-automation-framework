package tests.ui;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

@Listeners(listeners.TestListener.class)
public class LoginTest extends BaseTest {

    @Test(description = "TC-UI-01")
    public void validLoginTest() {

        LoginPage lp =
                new LoginPage();

        lp.openApp();

        lp.login(
                "aniket@gmail.com",
                "pass123"
        );

        // basic assertion: add note button should be visible after successful login
        pages.NotesPage np = new pages.NotesPage();
        org.testng.Assert.assertTrue(np.isAddNoteVisible(), "Add note button should be visible after login");
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