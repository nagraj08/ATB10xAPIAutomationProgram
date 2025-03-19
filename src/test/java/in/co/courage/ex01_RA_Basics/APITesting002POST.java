package in.co.courage.ex01_RA_Basics;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.JSONObject;

import java.util.Scanner;

public class APITesting002POST {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            System.out.println("Starting API test program...");

            //Gherkin Syntax
            // Given () - Pre-conditions - URL, Headers, Payload, Authorization
            // When () - Actions - GET, POST, PUT, DELETE
            // Then () - Validation - Status Code (200) ok, firstname == nagraj, Response Body, Response Time

            // Validate pincode input
            boolean isValidInput = false;
            String pincode = "";
            scanner = new Scanner(System.in);

            while (!isValidInput) {
                System.out.println("Enter the pincode (6 digit number): ");
                pincode = scanner.nextLine();
                System.out.println("Received input: " + pincode);
                if (pincode.matches("\\d{6}")) {
                    isValidInput = true;
                    System.out.println("Valid pincode received: " + pincode);
                } else {
                    System.out.println("Invalid input! Please enter a valid 6-digit pincode.");
                }
            }

            System.out.println("Creating JSON payload...");
            // Create simple JSON payload with just pincode
            JSONObject requestBody = new JSONObject();
            requestBody.put("pincode", pincode);

            // Print the request body for debugging
            System.out.println("Request Body:");
            System.out.println(requestBody.toString(2)); // Pretty print with 2 spaces indentation

            System.out.println("Preparing to make POST request...");
            // Using a test API that supports POST requests
            String url = "https://jsonplaceholder.typicode.com/posts";
            System.out.println("URL: " + url);

            // Make POST request
            RestAssured.
                    given()
                    .baseUri(url)
                    .contentType(ContentType.JSON)
                    .body(requestBody.toString())
                    .when()
                    .post()
                    .then()
                    .log()
                    .all()
                    .statusCode(200); // 200 is expected for successful POST request

            System.out.println("Request completed successfully!");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            System.out.println("Stack trace:");
            e.printStackTrace();
        } finally {
            // Close the scanner
            if (scanner != null) {
                scanner.close();
                System.out.println("Scanner closed successfully.");
            }
        }
    }
}