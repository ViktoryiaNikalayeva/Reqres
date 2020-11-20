package adapters;

import com.google.gson.Gson;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseAdapter {

    String token = "34ce88e4f9e6e8ebd92234678d0603c1d0f6aadc";
    String url = "https://api.qase.io/";

    Gson converter = new Gson();


    public String get(String uri) {
        return
                given()
                        .header("Token", token)
                        .header("Content-Type", "application/json")
                        .when()
                        .get(url + uri)
                        .then()
                        .log().all()
                        .extract().body().asString();
    }


    public Response post(String uri, String body) {
        return
                given()
                        .header("Token", token)
                        .header("Content-Type", "application/json")
                        .body(body)
                        .when()
                        .post(url + uri)
                        .then()
                        .log().all()
                        .extract().response();
    }
    public void delete(String uri) {
        given()
                .header("Token", token)
                .header("Content-Type", "application/json")
                .when()
                .delete(url + uri)
                .then()
                .log().all();
    }
}