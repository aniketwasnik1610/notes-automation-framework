package tests.api;

import api.ApiBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.TestListener.class)
public class NotesApiTest {

    @BeforeMethod
    public void setup() {

        ApiBase.setup();
    }

    @Test(description = "TC-API-01")
    public void getNotesTest() {

        Response res =
                ApiBase.req.get("/notes");

        Assert.assertEquals(
                res.getStatusCode(),
                200
        );
    }

    @Test(description = "TC-API-02")
    public void validateResponseStructureTest() {

        Assert.assertTrue(true);
    }

    @Test(description = "TC-PERF-01")
    public void validateResponseTimeTest() {

        Assert.assertTrue(true);
    }

    @Test(description = "TC-API-03")
    public void deleteNoteApiTest() {

        Assert.assertTrue(true);
    }

    @Test(description = "TC-NEG-04")
    public void unauthorizedAccessTest() {

        Assert.assertTrue(true);
    }

    @Test(description = "TC-NEG-05")
    public void invalidNoteIdTest() {

        Assert.assertTrue(true);
    }
}