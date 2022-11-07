import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClient;

import static io.restassured.RestAssured.given;

public class createUserTests {
    @Test
    public void createMaleUser(){
        //1.Arrange - Arranging the data to create user
        String body = "{\n" + //creating a variable that needs to be passed to create user method - cmd+option+V
                "    \"name\": \"Tenali Ramkrishna\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"tenali.ramkrishna7@15ce.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        //to create a parameter cmd+option+P
        //2.Act - calling the API to create user

        //CreateUser method can be used by many other methods, hence saved the CreateUser method in seperate class
        //hence it will be used as reference to access CreateUser(body)
        new UsersClient().CreateUser(body)
                .then()
                .statusCode(201)
                .log().body()

        //3.Assert - adding assertions to evaluate
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo("tenali.ramkrishna7@15ce.com"))
                .body("name",Matchers.equalTo("Tenali Ramkrishna"));


    }
    @Test
    public void createFemaleUser(){

        //1.Arrange - Arranging the data to create user
        String body = "{\n" +
                "    \"name\": \"Vinutha Mahadev\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"vinutha.mahadev3@gmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        //2.Act - calling the API to create user
        new UsersClient().CreateUser(body)
                .then()
                .statusCode(201)
                .log().body()

        //3.Assert - adding assertions to evaluate
                .body("id",Matchers.notNullValue())
                .body("email",Matchers.equalTo("vinutha.mahadev3@gmail.com"))
                .body("name",Matchers.equalTo("Vinutha Mahadev"));


    }

}
