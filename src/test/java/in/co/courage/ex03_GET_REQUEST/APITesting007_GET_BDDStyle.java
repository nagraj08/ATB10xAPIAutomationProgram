package in.co.courage.ex03_GET_REQUEST;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting007_GET_BDDStyle {
    @Test
    public void test_BDD_GET_Request() {
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
