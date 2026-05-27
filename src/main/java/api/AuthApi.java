package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AuthApi {

    public static String token;

    public static void login() {

        RestAssured.baseURI =
                "https://practice.expandtesting.com/notes/api";

        String body =
                "{\n" +
                        "\"email\":\"aniket@gmail.com\",\n" +
                        "\"password\":\"pass123\"\n" +
                        "}";

        Response res =
                RestAssured.given()
                        .header("Content-Type", "application/json")
                        .body(body)
                        .post("/users/login");

        System.out.println(res.asPrettyString());

        token =
                res.jsonPath()
                        .getString("data.token");

        System.out.println("TOKEN: " + token);
    }
}