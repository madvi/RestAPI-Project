import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.Create.CreateUserRequestBody;
import users.Create.Response.CreateUserErrorResponse;
import users.Create.Response.CreateUserResponse;
import users.UsersClient;
import users.UsersService;

import java.util.UUID;

public class createUserNegativeTests {

    private UsersService usersService;

    @BeforeClass
    public void beforeClass(){
        usersService = new UsersService();
    }

    @Test
    public void shouldNotAllowNegativeTests(){

        /*String email = "vinuthamahadev.com";
        String name = "Vinutha Mahadev";
        String gender = "female";
        String status = "active";

        //CreateUserRequestBody requestBody = new CreateUserRequestBody(name,gender,email,status);
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder().name(name).gender(gender)
                                                    .email(email).status(status).build();*/

        CreateUserRequestBody requestBody =  new CreateUserRequestBody.Builder().email("vinuthamahadev.com").build();
        CreateUserErrorResponse errorResponse = usersService.createUserExpectedError(requestBody);
        Assert.assertEquals(errorResponse.getStatusCode(),422);
        errorResponse.assertHasError("email","is invalid");

        /*usersClient.create(requestBody)

                .then()
                    .statusCode(422)
                    .body("data",Matchers.hasItem(Matchers.hasEntry("field","email")))
                    .body("data",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));*/

    }
    @Test
    public void shouldNotAllowUserToCreateWithBlankGenderAndStatus(){
        /*String email = "vinuthamahadev11@gmail.com";
        String name = "Vinutha Mahadev";
        String gender = "";
        String status = "";

        //CreateUserRequestBody requestBody = new CreateUserRequestBody(name,gender,email,status);
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder().name(name).gender(gender)
                .email(email).status(status).build();*/

        CreateUserRequestBody requestBody =  new CreateUserRequestBody.Builder().gender("").status("").build();

        CreateUserErrorResponse errorResponse = usersService.createUserExpectedError(requestBody);
        Assert.assertEquals(errorResponse.getStatusCode(),422);
        errorResponse.assertHasError("gender","can't be blank, can be male of female");
        errorResponse.assertHasError("status","can't be blank");


    }
}
