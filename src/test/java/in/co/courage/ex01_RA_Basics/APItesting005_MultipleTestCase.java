package in.co.courage.ex01_RA_Basics;

import io.restassured.RestAssured;

public class APItesting005_MultipleTestCase {
    public static void main(String[] args) {
     String pincode ="110048";
        RestAssured.
                given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode).
                when()
                .get()
                .then()
                .log().all().statusCode(200);

        pincode ="@";
        RestAssured.
                given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode).
                when()
                .get()
                .then()
                .log().all().statusCode(200);

        pincode ="";
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
