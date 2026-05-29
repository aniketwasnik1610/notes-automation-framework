package tests.ui;

import base.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NotesPage;

@Listeners(listeners.TestListener.class)
public class CreateNoteTest extends BaseTest {

    @Test(
            retryAnalyzer =
                    utils.RetryAnalyzer.class
    )
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

        String noteTitle =
                "Note"
                        + System.currentTimeMillis();

        np.createNote(
                noteTitle,
                "Created using Selenium"
        );

        // verify note appears in UI
        org.testng.Assert.assertTrue(np.isNotePresent(noteTitle), "Newly created note should appear in the UI");
    }
}