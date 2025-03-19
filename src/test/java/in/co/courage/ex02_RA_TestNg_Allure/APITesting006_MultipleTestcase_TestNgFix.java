package in.co.courage.ex02_RA_TestNg_Allure;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting006_MultipleTestcase_TestNgFix {
    @Test
    @Description("TC#1-Verify the valid Pincode give status code 200 ok")
    public void test_GET_POSITIVE_TC1() {
        RestAssured.
                given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/110048").
                when()
                .get()
                .then()
                .log().all().statusCode(200);
    }
    @Test
    @Description("TC#2-Verify the negative Pincode give error status code 404")
    public void test_GET_NEGATIVE_TC2() {
        RestAssured.
                given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + -1).
                when()
                .get()
                .then()
                .log().all().statusCode(200);
    }
    @Test
    @Description("TC#3-Verify the blank Pincode give error status code 404")
    public void test_GET_NEGATIVE_TC3() {
        RestAssured.
                given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + " ").
                when()
                .get()
                .then()
                .log().all().statusCode(200);
    }

}
