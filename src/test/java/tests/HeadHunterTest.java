package tests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.VacanciesList;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class HeadHunterTest {
    Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    @Test
    public void qaSearch() {
        String body = given()
                .when()
                .get("https://api.hh.ru/vacancies?text=QA&area=1002")
                        .then()
                        .statusCode(200)
                .extract().body().asString();
       VacanciesList list = new Gson().fromJson(body, VacanciesList.class);

    }
}
