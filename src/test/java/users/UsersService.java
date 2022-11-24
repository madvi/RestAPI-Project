package users;

import io.restassured.response.Response;
import users.Create.CreateUserRequestBody;
import users.Create.Response.CreateUserErrorResponse;
import users.Create.Response.CreateUserResponse;
import users.getAllUsers.GetAllUsersResponse;
import users.getUserByID.GetAllUserById;

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
    public static CreateUserErrorResponse createUserExpectedError(CreateUserRequestBody body){
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
    public GetAllUserById getUser(int id){
        Response response = new UsersClient().get(id);

        int statusCode = response.statusCode();

        GetAllUserById getAllUserById = response.as(GetAllUserById.class);
        getAllUserById.setStatusCode(200);
        return getAllUserById;

    }
}
