package in.co.courage.ex03_GET_REQUEST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting009_GET_Multiple_TC_NONBDDStyle {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Description("This test case will verify the status code of the API")
    @Test
public void test1_NONBDD_GET_Request_POSITIVE() {
   String pincode = "560048";
    r = RestAssured.given().baseUri("https://api.zippopotam.us").basePath("/IN/+pincode");
    response = r.when().get();
    vr = response.then();
    vr.statusCode(200);
}

    @Description("This test case will verify the status code of the API")
    @Test
    public void test2_NONBDD_GET_Request_NEATIVE() {
        String pincode = "-1";
        r = RestAssured.given().baseUri("https://api.zippopotam.us").basePath("/IN/+pincode");
        response = r.when().get();
        vr = response.then();
        vr.statusCode(404);
    }

    @Description("This test case will verify the status code of the API")
    @Test
    public void test3_NONBDD_GET_Request_NEATIVE() {
        String pincode = " ";
        r = RestAssured.given().baseUri("https://api.zippopotam.us").basePath("/IN/+pincode");
        response = r.when().get();
        vr = response.then();
        vr.statusCode(404);
    }

}
