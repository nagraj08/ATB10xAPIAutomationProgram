package in.co.courage.ex04_POST_REQUEST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class APITesting011_POSTMultiple_TC_BDDStyle {
    @Description("TC#1-Verify the POST Req Positive")
    @Test
    public void test1_BDD_POST_Request_POSITIVE() {
        // URL,Method, Headers, Payload, Authorization
        String payload = "{\n" +
                "  \"username\" : \"admin\",\n" +
                "   \"password\" : \"password123\"\n " +
        "}";
         RestAssured.given()
         .baseUri("https://restful-booker.herokuapp.com")
         .basePath("/auth")
         .header("Content-Type", "application/json")
         .body(payload).when().log().all().post().then().log().all().statusCode(200);
    }
}
