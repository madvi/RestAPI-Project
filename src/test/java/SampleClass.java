import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SampleClass {
    @Test
    public void createNewUser(){
        //Using AAA pattern
        //Arrange
        //Act- to write the code
        //Assert- to evaluate the expected output
        given()
                .when()
                .get("https://gorest.co.in/public/v2/users")
                .then()
                .statusCode(200)
                .log().body();
        Assert.assertEquals(1,1);

    }
}
