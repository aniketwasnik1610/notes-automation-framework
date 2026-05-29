package tests.e2e;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.TestListener.class)
public class HybridE2ETest extends BaseTest {

    @Test(description = "TC-E2E-01")
    public void uiApiValidationTest() {
        // create note in UI and validate via API that it exists
        pages.LoginPage lp = new pages.LoginPage();
        pages.NotesPage np = new pages.NotesPage();

        lp.openApp();
        lp.login("aniket@gmail.com","pass123");

        String title = "hybrid-note-" + System.currentTimeMillis();

        np.createNote(title, "created via ui for hybrid test");

        // setup API client and verify note exists
        api.ApiBase.setup();

        io.restassured.response.Response res = api.NotesApi.getNotes();

        java.util.List<String> titles = res.jsonPath().getList("data.title");

        Assert.assertTrue(titles != null && titles.contains(title), "UI-created note should appear in API response");
    }

    @Test(description = "TC-E2E-02")
    public void deletedNoteDisappearTest() {
        // create note in UI
        pages.LoginPage lp = new pages.LoginPage();
        pages.NotesPage np = new pages.NotesPage();

        lp.openApp();
        lp.login("aniket@gmail.com","pass123");

        String title = "hybrid-delete-note-" + System.currentTimeMillis();

        np.createNote(title, "to be deleted by api");

        // find the created note via API to get its id
        api.ApiBase.setup();

        io.restassured.response.Response all = api.NotesApi.getNotes();

        java.util.List<java.util.Map<String, Object>> data = all.jsonPath().getList("data");

        String id = null;
        if (data != null) {
            for (java.util.Map<String,Object> item : data) {
                Object t = item.get("title");
                if (t != null && t.toString().equals(title)) {
                    Object oid = item.get("_id");
                    if (oid == null) oid = item.get("id");
                    if (oid != null) {
                        id = oid.toString();
                        break;
                    }
                }
            }
        }

        org.testng.Assert.assertNotNull(id, "Created note id should be found via API");

        // delete via API
        api.NotesApi.deleteNote(id);

        // refresh UI and assert note not present
        np.refreshPage();

        org.testng.Assert.assertFalse(np.isNotePresent(title), "Deleted note should not appear in UI after API delete");
    }
}