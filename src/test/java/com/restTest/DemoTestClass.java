package com.restTest;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class DemoTestClass {

    @Test
    public void testAPI() {
        RestAssured.baseURI = "https://reqres.in";
        Response response=RestAssured.given()
                .get("/api/users/2");
        String data=response.getBody().toString();
        System.out.println(data);

    }
}
