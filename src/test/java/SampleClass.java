import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SampleClass {
    @Test
    public void GetListOfUsers(){
        //Using AAA pattern
        //Arrange
        //Act- to write the code
        //Assert- to evaluate the expected output
        //given() - to add pre-requisites like header,body etc
        //when() - to write the actual code for the testcase
        //then() - to evaluate the response
        given()
                .when()
                .get("https://gorest.co.in/public/v2/users")
                .then()
                .statusCode(200)
                //adding assertions to verify no of items in array and to evaluate gender element

                .body("gender",Matchers.hasItem("male"))
                .log().body();
        Assert.assertEquals(1,1);

    }
    @Test
    public void createNewUser(){
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer 7f120bbebae7c79e6e536e658a0dc729127b618c79fd4f0e483d83f3e3bc2a40")
                .body("{\n" +
                        "    \"name\": \"Tenali Ramkrishna\",\n" +
                        "    \"gender\": \"male\",\n" +
                        "    \"email\": \"tenali.ramkrishna3@15ce.com\",\n" +
                        "    \"status\": \"active\"\n" +
                        "}")
                .when()
                .post("https://gorest.co.in/public/v2/users")
                .then()
                .statusCode(201)
                .body("id",Matchers.notNullValue())
                .body("email",Matchers.equalTo("tenali.ramkrishna3@15ce.com"))
                .log().body();

    }
}
