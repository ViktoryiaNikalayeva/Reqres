package tests;

import lombok.Builder;
import lombok.Data;
import models.User;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Data
@Builder
public class ReqresTest {


    @Test
    public void getListUsers() {

        given()

                .header("Content-type", "application/json")
                .log().all()
                .when()
                .get("https://reqres.in/api/users")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getSingleUser() {

        given()

                .header("Content-type", "application/json")
                .log().all()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void singleUserNotFound() {

        given()

                .header("Content-type", "application/json")
                .log().all()
                .when()
                .get("https://reqres.in/api/users/23")
                .then()
                .log().all()
                .statusCode(404);
    }

    @Test
    public void listResource() {

        given()

                .header("Content-type", "application/json")
                .log().all()
                .when()
                .get("https://reqres.in/api/unknown")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void singleResource() {

        given()

                .header("Content-type", "application/json")
                .log().all()
                .when()
                .get("https://reqres.in/api/unknown/2")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void singleResourceNotFound() {

        given()

                .header("Content-type", "application/json")
                .log().all()
                .when()
                .get("https://reqres.in/api/unknown/23")
                .then()
                .log().all()
                .statusCode(404);
    }

    @Test
    public void postUser() {
        User user = User.builder()
                .job("leader")
                .name("morpheus")
                .build();

        given()
                .body(user)
                .header("Content-type", "application/json")
                .log().all()
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().all()
                .statusCode(201);
    }

    @Test
    public void putUpdate() {
        User user = User.builder()
                .job("leader")
                .name("morpheus")
                .build();

        given()
                .body(user)
                .header("Content-type", "application/json")
                .log().all()
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void patchUpdate() {
        User user = User.builder()
                .job("leader")
                .name("morpheus")
                .build();

        given()
                .body(user)
                .header("Content-type", "application/json")
                .log().all()
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void delete() {

        given()

                .header("Content-type", "application/json")
                .log().all()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(204);
    }

    @Test
    public void postRegisterSuccessful() {
        User user = User.builder()
                .email("eve.holt@reqres.in")
                .password("pistol")
                .build();

        given()
                .body(user)
                .header("Content-type", "application/json")
                .log().all()
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void postRegisterUnsuccessful() {
        User user = User.builder()
                .email("eve.holt@reqres.in")
                .build();

        given()
                .body(user)
                .header("Content-type", "application/json")
                .log().all()
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().all()
                .statusCode(400);
    }

    @Test
    public void postLoginSuccessful() {
        User user = User.builder()
                .email("eve.holt@reqres.in")
                .password("pistol")
                .build();

        given()
                .body(user)
                .header("Content-type", "application/json")
                .log().all()
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void postLoginUnsuccessful() {
        User user = User.builder()
                .email("eve.holt@reqres.in")
                .build();

        given()
                .body(user)
                .header("Content-type", "application/json")
                .log().all()
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().all()
                .statusCode(400);
    }

    @Test
    public void delayedResponse() {

        given()

                .header("Content-type", "application/json")
                .log().all()
                .when()
                .get("https://reqres.in/api/users?delay=3")
                .then()
                .log().all()
                .statusCode(200);
    }

}
