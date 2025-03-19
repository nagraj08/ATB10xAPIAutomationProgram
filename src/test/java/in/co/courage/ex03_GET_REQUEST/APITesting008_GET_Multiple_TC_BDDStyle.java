package in.co.courage.ex03_GET_REQUEST;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting008_GET_Multiple_TC_BDDStyle {
@Test
    public void test1_BDD_GET_Request_POSITIVE() {

        String pincode = "-1";
        RestAssured.
                given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode).
                when()
                .get()
                .then()
                .log().all().statusCode(200);
    }
    @Test
    public void test2_BDD_GET_Request_NEGATIVE() {

        String pincode = "560016";
        RestAssured.
                given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode).
                when()
                .get()
                .then()
                .log().all().statusCode(200);
    }
}
