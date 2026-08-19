package com.nanas.handcrafts;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;

@QuarkusTest
class HandCraftsApplicationTest {

    @Test
    void brandEndpointReturnsBrandDetails() {
        given()
            .when().get("/api/brand")
            .then()
            .statusCode(200)
            .body("name", is("Nana's Hand Crafts"))
            .body("tagline", is("Crocheted with love"));
    }

    @Test
    void productsEndpointReturnsStarterCatalog() {
        given()
            .when().get("/api/products")
            .then()
            .statusCode(200)
            .body("size()", greaterThan(0));
    }

    @Test
    void inquiryEndpointAcceptsValidRequests() {
        given()
            .contentType("application/json")
            .body("""
                {
                  "name": "Mona",
                  "email": "mona@example.com",
                  "interestedProduct": "Custom blanket",
                  "message": "I would like a custom blanket in soft neutral colors."
                }
                """)
            .when().post("/api/inquiries")
            .then()
            .statusCode(201)
            .body("status", is("received"))
            .body("message", containsString("Mona"));
    }
}