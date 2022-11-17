import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.Create.CreateUserRequestBody;
import users.Create.Response.CreateUserErrorResponse;
import users.Create.Response.CreateUserResponse;
import users.UsersClient;

import java.util.UUID;

public class createUserNegativeTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }

    @Test
    public void shouldNotAllowNegativeTests(){

        String email = "vinuthamahadev.com";
        String name = "Vinutha Mahadev";
        String gender = "female";
        String status = "active";

        //CreateUserRequestBody requestBody = new CreateUserRequestBody(name,gender,email,status);
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder().name(name).gender(gender)
                                                    .email(email).status(status).build();

        CreateUserErrorResponse errorResponse = usersClient.createUserExpectedError(requestBody);
        Assert.assertEquals(errorResponse.getStatusCode(),422);
        errorResponse.assertHasError("email","invalid");



//                .then()
//                    .statusCode(422)
//                    //.body(Matchers.hasItem(Matchers.hasEntry("field","email")))
//                    .body("field", Matchers.hasItem("email"))
//                    //.body(Matchers.hasItem(Matchers.hasEntry("message","is invalid")))
//                    .body("message", Matchers.hasItem("is invalid"));

    }
}
