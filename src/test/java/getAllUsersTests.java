import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getAllUsersTests {
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

}
