package api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class ApiBase {

    public static RequestSpecification req;

    public static void setup() {

        AuthApi.login();

        RestAssured.baseURI =
                "https://practice.expandtesting.com/notes/api";

        req = RestAssured.given()
                .header("Content-Type","application/json")
                .header("x-auth-token",
                        AuthApi.token);
    }
}