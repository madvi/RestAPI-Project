import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class createUserTests {
    @Test
    public void createMaleUser(){
        //1.Arrange - Arranging the data to create user
        String body = "{\n" + //creating a variable that needs to be passed to create user method - cmd+option+V
                "    \"name\": \"Tenali Ramkrishna\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"tenali.ramkrishna6@15ce.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        //to create a parameter cmd+option+P
        //2.Act - calling the API to create user
        CreateUser(body)
                .then()
                .statusCode(201)
                .log().body()

        //3.Assert - adding assertions to evaluate
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo("tenali.ramkrishna6@15ce.com"))
                .body("name",Matchers.equalTo("Tenali Ramkrishna"));


    }
    @Test
    public void createFemaleUser(){

        //1.Arrange - Arranging the data to create user
        String body = "{\n" +
                "    \"name\": \"Vinutha Mahadev\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"vinutha.mahadev2@gmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        //2.Act - calling the API to create user
        CreateUser(body)
                .then()
                .statusCode(201)
                .log().body()

        //3.Assert - adding assertions to evaluate
                .body("id",Matchers.notNullValue())
                .body("email",Matchers.equalTo("vinutha.mahadev2@gmail.com"))
                .body("name",Matchers.equalTo("Vinutha Mahadev"));


    }
    //Refactoring the code by extracting createuser out of this. Response is the inbuilt method of intellij
    //Extracted a code that create the user and "CreateUser" method gives us the response
    //To pass the parameter(body) inside Create user method - cmd+option+P
    private static Response CreateUser(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 7f120bbebae7c79e6e536e658a0dc729127b618c79fd4f0e483d83f3e3bc2a40")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v2/users");
    }


}
