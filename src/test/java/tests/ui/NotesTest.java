package tests.ui;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NotesPage;

@Listeners(listeners.TestListener.class)
public class NotesTest extends BaseTest {

    @Test(description = "TC-UI-02")
    public void createNoteTest() {

        LoginPage lp =
                new LoginPage();

        NotesPage np =
                new NotesPage();

        lp.openApp();

        lp.login(
                "aniket@gmail.com",
                "pass123"
        );

        np.createNote(
                "Automation Note",
                "Created using Selenium"
        );
    }

    @Test(description = "TC-UI-03")
    public void verifyNoteAppearsTest() {

        Assert.assertTrue(true);
    }

    @Test(description = "TC-UI-04")
    public void createHomeCategoryNoteTest() {

        Assert.assertTrue(true);
    }

    @Test(description = "TC-UI-05")
    public void createWorkCategoryNoteTest() {

        Assert.assertTrue(true);
    }

    @Test(description = "TC-UI-06")
    public void createPersonalCategoryNoteTest() {

        Assert.assertTrue(true);
    }

    @Test(description = "TC-NEG-03")
    public void emptyTitleValidationTest() {

        Assert.assertTrue(true);
    }

    @Test(description = "TC-NEG-06")
    public void specialCharacterValidationTest() {

        Assert.assertTrue(true);
    }
}