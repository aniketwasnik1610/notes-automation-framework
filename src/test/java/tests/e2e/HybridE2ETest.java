package tests.e2e;

import api.ApiBase;
import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NotesPage;

@Listeners(listeners.TestListener.class)
public class HybridE2ETest extends BaseTest {

    @Test(
            retryAnalyzer =
                    utils.RetryAnalyzer.class
    )
    public void uiApiValidationTest() {

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
                "HybridNote"
                        + System.currentTimeMillis();

        np.createNote(
                noteTitle,
                "Validated via API"
        );

        ApiBase.setup();

        Response res =
                ApiBase.req.get("/notes");

        String body =
                res.asString();

        System.out.println(body);

        Assert.assertTrue(
                body.contains(noteTitle)
        );
    }
}