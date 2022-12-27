package com.trycloud.utilities;


import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;


public abstract class BookItTestBase {

    @BeforeAll
    static void init(){
        RestAssured.baseURI = "http://api.qa.bookit.cydeo.com";

    }



}
