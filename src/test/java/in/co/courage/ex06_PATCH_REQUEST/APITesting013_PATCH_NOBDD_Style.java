package in.co.courage.ex06_PATCH_REQUEST;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class APITesting013_PATCH_NOBDD_Style {

    @Description("Verify the PATCH Request Positive")
    @Test
    public void test1_NONBDD_PATCH_Request_POSITIVE() {
        // URL,Method, Headers, Payload, Authorization
        String token = "85664ef43ad828b";
        String booking_id = "1357";

        String payload = "{\n" +
                "  \"firstname\" : \"Alex\",\n" +
                "   \"lastname\" : \"Dutta\",\n" +
                "}";
        io.restassured.RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/" + booking_id)
                .header("Content-Type", "application/json")
                .cookie("token", token)
                .body(payload).when().log().all().patch().then().log().all().statusCode(200);
    }
}
