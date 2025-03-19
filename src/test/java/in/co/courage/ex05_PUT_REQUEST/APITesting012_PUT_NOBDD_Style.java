package in.co.courage.ex05_PUT_REQUEST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting012_PUT_NOBDD_Style {
    //PUT Request
    //token, booking id,  - A
//public void get_token(){}
//public void get_booking_id(){}

@Description("This test case will verify the status code of the API")
@Test
public void test1_PUT_NON_BDD_Request_POSITIVE() {
    // URL,Method, Headers, Payload, Authorization
    String token = "c0bab95631ce136";
    String booking_id = "1357";
//    RequestSpecification r = RestAssured.given();
//    r
//    Response response;
//    ValidatableResponse vr;


    String payload = "{\n" +
            "  \"firstname\" : \"Alex\",\n" +
            "   \"lastname\" : \"Brown\",\n" +
            "   \"totalprice\" : 111,\n" +
            "   \"depositpaid\" : true,\n" +
            "   \"bookingdates\" : {\n" +
            "       \"checkin\" : \"2018-01-01\",\n" +
            "       \"checkout\" : \"2019-01-01\"\n" +
            "   },\n" +
            "   \"additionalneeds\" : \"Breakfast\"\n" +
            "}";
    io.restassured.RestAssured.given()
            .baseUri("https://restful-booker.herokuapp.com")
            .basePath("/booking/" + booking_id)
            .header("Content-Type", "application/json")
            .cookie("token", token)
            .body(payload).when().log().all().put().then().log().all().statusCode(200);
}
}