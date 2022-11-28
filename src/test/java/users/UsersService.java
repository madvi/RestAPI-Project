package users;

import io.restassured.response.Response;
import users.Create.CreateUserRequestBody;
import users.Create.Response.CreateUserErrorResponse;
import users.Create.Response.CreateUserResponse;
import users.Create.Response.UpdatedUserResponse;
import users.getAllUsers.GetAllUsersResponse;
import users.getUserByID.GetAllUserErrorResponse;
import users.getUserByID.GetAllUserResponseById;

public class UsersService {

    //Refactoring the code by extracting createuser out of this. Response is the inbuilt method of intellij
    //Extracted a code that create the user and "CreateUser" method gives us the response
    //To pass the parameter(body) inside Create user method - cmd+option+P
    public CreateUserResponse CreateUser(CreateUserRequestBody body) {

        Response response = new UsersClient().create(body);
        //Asking restAssured to convert response into createUserResponse type
        //we will be getting response body in deserialized(object) form
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.statusCode());
        return createUserResponse;
    }

    //creating a method which accepts CreateUserRequestBody
    public static CreateUserErrorResponse createUserExpectedError(CreateUserRequestBody body) {
        //create object returns response object of restAssured which need to be deserialized
        Response response = new UsersClient().create(body);
        //deserializing the response body
        CreateUserErrorResponse errorResponse = response.as(CreateUserErrorResponse.class);
        errorResponse.setStatusCode(response.statusCode());
        return errorResponse;
    }

    public GetAllUsersResponse getAllUsers() {
        Response response = new UsersClient().getAll();

        int statusCode = response.statusCode();
        GetAllUsersResponse getAllUsersResponse = response.as(GetAllUsersResponse.class);
        getAllUsersResponse.setStatusCode(statusCode);

        return getAllUsersResponse;


    }

    public GetAllUserResponseById getUser(int id) {
        Response response = new UsersClient().get(id);

        int statusCode = response.statusCode();

        GetAllUserResponseById getAllUserById = response.as(GetAllUserResponseById.class);
        getAllUserById.setStatusCode(200);
        return getAllUserById;

    }

    public int deleteUser(int id) {
        Response response = new UsersClient().delete(id);

        return response.statusCode();
    }

    public GetAllUserErrorResponse getUserExpectingError(int id) {
        Response response = new UsersClient().get(id);

        int statusCode = response.statusCode();

        GetAllUserErrorResponse getAllUserErrorResponse = response.as(GetAllUserErrorResponse.class);
        getAllUserErrorResponse.setStatusCode(statusCode);
        return getAllUserErrorResponse;
    }


    public UpdatedUserResponse getUpdatedUserDetails(int id,CreateUserRequestBody requestBody) {
        Response response = new UsersClient().patch(id,requestBody);
        int statusCode = response.statusCode();

        UpdatedUserResponse updatedUserResponse = response.as(UpdatedUserResponse.class);
        updatedUserResponse.setStatusCode(statusCode);

        return updatedUserResponse;
    }
}
