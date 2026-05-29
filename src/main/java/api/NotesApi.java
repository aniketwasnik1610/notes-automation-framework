package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class NotesApi {

    public static Response createNote(String title, String description, String category) {

        String body = "{\n" +
                "\"title\":\"" + title + "\",\n" +
                "\"description\":\"" + description + "\",\n" +
                "\"category\":\"" + category + "\"\n" +
                "}";

        return ApiBase.req
                .contentType(ContentType.JSON)
                .body(body)
                .post("/notes");
    }

    public static Response getNotes() {
        return ApiBase.req.get("/notes");
    }

    public static Response deleteNote(String id) {

        return ApiBase.req.delete("/notes/" + id);
    }
}

