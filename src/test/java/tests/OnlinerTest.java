package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;


public class OnlinerTest {

    @Test
    public void getCurrencyRateUSD() {
        given().
                when()
                        .get(" https://www.onliner.by/sdapi/kurs/api/bestrate?currency=USD&type=nbrb")
        .then()
                .statusCode(200)
                .log().all()
                .body("amount", equalTo("2,5680"));

    }

    @Test
    public void getCurrencyRateEUR() {
        given().
                when()
                            .get(" https://www.onliner.by/sdapi/kurs/api/bestrate?currency=EUR&type=nbrb")
                .then()
                .statusCode(200)
                .log().all()
                .body("amount", equalTo("3,0247"));;

    }

    @Test
    public void getCurrencyRateRUS() {
        given().
                when()
                             .get(" https://www.onliner.by/sdapi/kurs/api/bestrate?currency=RUS&type=nbrb")
                .then()
                .statusCode(200)
                .log().all()
                .body("amount", equalTo("3,3319"));;

    }
}
