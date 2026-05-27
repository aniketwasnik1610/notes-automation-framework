package tests.api;

import api.ApiBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@Listeners(listeners.TestListener.class)
public class NotesApiTest {

    @BeforeMethod
    public void setup() {

        ApiBase.setup();
    }

    @Test(
            retryAnalyzer =
                    utils.RetryAnalyzer.class
    )
    public void getNotesTest() {

        Response res =
                ApiBase.req.get("/notes");

        System.out.println(
                res.asPrettyString()
        );

        Assert.assertEquals(
                res.getStatusCode(),
                200
        );

        Assert.assertTrue(
                res.time() < 2000
        );

        res.then()
                .assertThat()
                .body(
                        matchesJsonSchemaInClasspath(
                                "schema/notes-schema.json"
                        )
                );
    }
}