package com.restTest;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class DemoTestClass {

    @Test
    public void testAPI1() {
        RestAssured.baseURI = "https://reqres.in";
        Response response=RestAssured.given()
                .get("/api/users/2");
        String data=response.getBody().asString();
        System.out.println(data);
        Assert.assertEquals(201,response.getStatusCode(),"Status code is not as expected");
    }
    @Test
    public void testAPI2() {
        RestAssured.baseURI = "https://reqres.in";
        Response response=RestAssured.given()
                .get("/api/users/2");
        String data=response.getBody().asString();
        System.out.println(data);
        Assert.assertEquals(200,response.getStatusCode(),"Status code is not as expected");
    }
}
