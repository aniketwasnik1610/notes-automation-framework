package tests.api;

import api.ApiBase;
import api.NotesApi;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(listeners.TestListener.class)
public class NotesApiTest {

    @BeforeMethod
    public void setup() {

        ApiBase.setup();
    }

    @Test(description = "TC-API-01")
    public void getNotesTest() {

        Response res = ApiBase.req.get("/notes");

        Assert.assertEquals(res.getStatusCode(), 200);
    }

    @Test(description = "TC-API-02")
    public void validateResponseStructureTest() {

        ApiBase.req.get("/notes")
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/notes-schema.json"));
    }

    @Test(description = "TC-PERF-01")
    public void validateResponseTimeTest() {

        Response res = ApiBase.req.get("/notes");

        long time = res.time();

        Assert.assertTrue(time < 2000, "Response time should be less than 2000 ms. Actual: " + time);
    }

    @Test(description = "TC-API-03")
    public void deleteNoteApiTest() {

        String title = "api-note-" + System.currentTimeMillis();

        Response create = NotesApi.createNote(title, "created via api for delete test", "Home");

        Assert.assertTrue(create.getStatusCode() >= 200 && create.getStatusCode() < 300,
                "Create note api should succeed");

        String id = create.jsonPath().getString("data._id");
        if(id == null) {
            id = create.jsonPath().getString("data.id");
        }

        Assert.assertNotNull(id, "Created note id should not be null");

        Response del = NotesApi.deleteNote(id);

        Assert.assertTrue(del.getStatusCode() == 200 || del.getStatusCode() == 204,
                "Delete should return 200 or 204");

        // verify deleted id not present
        Response all = NotesApi.getNotes();

        List<String> ids = all.jsonPath().getList("data._id");

        if (ids != null) {
            Assert.assertFalse(ids.contains(id), "Deleted note id should not be present in notes list");
        }
    }

    @Test(description = "TC-NEG-04")
    public void unauthorizedAccessTest() {

        // call without token/set up
        Response res = RestAssured.given()
                .baseUri("https://practice.expandtesting.com/notes/api")
                .when().get("/notes");

        // expect non-200 (401/403 etc.)
        Assert.assertTrue(res.getStatusCode() >= 400, "Unauthorized call should not return 2xx");
    }

    @Test(description = "TC-NEG-05")
    public void invalidNoteIdTest() {

        Response res = ApiBase.req.delete("/notes/invalid-id-123");

        Assert.assertTrue(res.getStatusCode() >= 400, "Deleting invalid id should return client error");
    }
}