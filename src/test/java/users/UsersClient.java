package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersClient {

    //Refactoring the code by extracting createuser out of this. Response is the inbuilt method of intellij
    //Extracted a code that create the user and "CreateUser" method gives us the response
    //To pass the parameter(body) inside Create user method - cmd+option+P
    public static Response CreateUser(String body) {
        return given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer 7f120bbebae7c79e6e536e658a0dc729127b618c79fd4f0e483d83f3e3bc2a40")
                    .body(body)
                .when()
                    .post("https://gorest.co.in/public/v2/users");
    }
    public static Response getAllUsers() {
        return given()
                .when()
                .get("https://gorest.co.in/public/v2/users");
    }
}
