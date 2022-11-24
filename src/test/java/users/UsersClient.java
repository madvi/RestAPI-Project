package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.Create.CreateUserRequestBody;
import users.Create.Response.CreateUserErrorResponse;
import users.Create.Response.CreateUserResponse;
import users.getAllUsers.GetAllUsersResponse;
import users.getUserByID.GetAllUserById;

import static io.restassured.RestAssured.given;

public class UsersClient {


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

    public static Response getAll() {
        Response response = given()
                .when()
                .get("https://gorest.co.in/public/v1/users");
        response.
                then()
                .log().body();
        return response;
    }

    public static Response get(int id) {
        Response response = given()
                .pathParam("id", id)
                .header("Authorization","Bearer 7f120bbebae7c79e6e536e658a0dc729127b618c79fd4f0e483d83f3e3bc2a40")
            .when()
                .get("https://gorest.co.in/public/v1/users/{id}");
        response
                .then()
                .log().body();
        return response;
    }
}
