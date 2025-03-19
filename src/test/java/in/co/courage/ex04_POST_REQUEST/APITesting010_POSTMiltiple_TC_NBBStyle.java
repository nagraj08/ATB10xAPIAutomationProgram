package in.co.courage.ex04_POST_REQUEST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting010_POSTMiltiple_TC_NBBStyle {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    @Test
    @Description("Verify the POST Request Positive")
    public void test1_NONBDD_POST_Request_POSITIVE() {
        // URL,Method, Headers, Payload, Authorization
        String pincode = "560048";
        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.header("Content-Type", "application/json");
        r.body("{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}").log().all();

        response = r.when().log().all().post();
        vr = response.then().log().all();
        vr.statusCode(200);
    }
}
