package in.co.courage.ex01_RA_Basics;

import io.restassured.RestAssured;

import java.util.Scanner;

public class APItesting001Get {
    public static void main(String[] args) {
        //Gherkin Syntax
        // Given () - Pre-conditions - URL, Headers, Payload, Authorization
        // When () - Actions - GET, POST, PUT, DELETE
        // Then () - Validation - Status Code (200) ok, firstname == nagraj, Response Body, Response Time
        //FUll URL: https://api.zippopotam.us/IN/560016
        //base URL: https://api.zippopotam.us
        //base path: /IN/560016

        Scanner scanner = new Scanner(System.in);
        String pincode;

        // Get pincode input and validate
        System.out.println("Enter the pincode (6 digit number): ");
        pincode = scanner.nextLine();

        // Validate if pincode is 6 digits
        if (pincode.matches("\\d{6}")) {
            // Make API request if pincode is valid
            RestAssured.
                    given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/" + pincode).
                    when()
                    .get()
                    .then()
                    .log().all().statusCode(200);
        } else {
            System.out.println("Invalid input! Please enter a valid 6-digit pincode.");
        }
        scanner.close();
    }
}
