package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.Create.CreateUserRequestBody;
import users.Create.Response.CreateUserErrorResponse;
import users.Create.Response.CreateUserResponse;

import static io.restassured.RestAssured.given;

public class UsersClient {

    //Refactoring the code by extracting createuser out of this. Response is the inbuilt method of intellij
    //Extracted a code that create the user and "CreateUser" method gives us the response
    //To pass the parameter(body) inside Create user method - cmd+option+P
    public  CreateUserResponse CreateUser(CreateUserRequestBody body) {

        Response response = create(body);
        //Asking restAssured to convert response into createUserResponse type
        //we will be getting response body in deserialized(object) form
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.statusCode());
        return createUserResponse;
    }

    public static CreateUserErrorResponse createUserExpectedError(CreateUserRequestBody body){
        Response response = create(body);
        CreateUserErrorResponse errorResponse = response.as(CreateUserErrorResponse.class);
        errorResponse.setStatusCode(response.statusCode());

        return errorResponse;
    }

    //Response is the method from restAssured
    public static Response create(CreateUserRequestBody body) {

          Response response =
                        given()
                            .accept(ContentType.JSON)
                            .contentType(ContentType.JSON)
                            .header("Authorization", "Bearer 7f120bbebae7c79e6e536e658a0dc729127b618c79fd4f0e483d83f3e3bc2a40")
                            .body(body)
                        .when()
                            .post("https://gorest.co.in/public/v1/users");
          //logging body is used in all the tests, so it is used in this class, where this class's code will be used
        // in all the tests
          response
                  .then()
                      .log().body();

        return
                response;

    }

    public static Response getAllUsers() {
        return given()
                .when()
                .get("https://gorest.co.in/public/v1/users");
    }
}
