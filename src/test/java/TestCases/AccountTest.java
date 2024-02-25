package TestCases;

import Utility.GenrateToken;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.geom.GeneralPath;

import static io.restassured.RestAssured.*;
public class AccountTest {

    static {
        baseURI="https://demoqa.com/Account/v1/User";
    }

    @Test
    public void createUser(){
        String body= "{\n" +
                "  \"userName\": \"sachinBudhiraja\",\n" +
                "  \"password\": \"Change!1\"\n" +
                "}";
      Response response= given()
        .contentType(ContentType.JSON)
                .body(body).when().post().
                then().extract().response();

        String userId=  response.jsonPath().get("userID");
         Assert.assertEquals(response.getStatusCode(),406);
    }


    @Test
    public void getUserDetails(){
        String uid= "981aa721-2180-417e-8835-cdc908b715fc";
       Response response= given().auth().oauth2(GenrateToken.getAuthToken())
                 .when().get(uid)
        .then().extract().response();
       System.out.println(response.getBody().prettyPrint());

    }

}
