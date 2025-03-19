package in.co.courage.ex07_DELETE_REQUEST;

import io.qameta.allure.Description;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting014_DELETE_NOBDDStyle {
    @Description("Verify the DELETE Request Positive")
    @Test
    public void test1_NONBDD_DELETE_Request_POSITIVE() {
        // URL,Method, Headers, Payload, Authorization
        String token = "5c21345ca658d6b";
        String booking_id = "1357";
        RequestSpecification r = io.restassured.RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + booking_id);
        r.header("Content-Type", "application/json");
        r.cookie("token", token);
        r.log().all();
        r.when().log().all().delete().then().log().all().statusCode(201);

    }
}