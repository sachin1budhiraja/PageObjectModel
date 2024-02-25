package Utility;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
public class GenrateToken {


    @Test
    public static String  getAuthToken(){
        String jsonString = "{\n" +
                "  \"userName\": \"sachinb\",\n" +
                "  \"password\": \"Change!1\"\n" +
                "}";

        String token =given().baseUri("https://demoqa.com/Account/v1/GenerateToken")
                .contentType(ContentType.JSON).
                body(jsonString).when().
                post().then().log().all().
              extract().path("token");

        return token;

    }
}
