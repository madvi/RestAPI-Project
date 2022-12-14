import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.Create.CreateUserRequestBody;
import users.Create.Response.CreateUserResponse;
import users.UsersClient;
import users.UsersService;


import java.util.UUID;


public class createUserTests {

    private UsersService usersService;

    @BeforeClass
    public void beforeClass() {
        usersService = new UsersService();
    }


        @Test
        public void createMaleUser () {

            /*String email = String.format("%s@gmail.com", UUID.randomUUID());
            String name = "Tenali Ramkrishna";
            String gender = "male";
            String status = "active";
            //1.Arrange - Arranging the data to create user
            //creating a variable that needs to be passed to create user method - cmd+option+V
            //To use String object instead of String body
            // String body is unused so it can be removed in CreateUserTests and CreateUserNegativeTests
            /*String body = "{\n" +
                    "   \"name\": \"" + name +"\",\n" +
                    "    \"gender\": \""+ gender +"\",\n" +
                    "    \"email\": \"%s\",\n" +
                    "    \"status\": \""+ status +"\"\n" +
                    "}";*/


            //CreateUserRequestBody requestBody = new CreateUserRequestBody(name,gender,email,status);
            //Without calling a constructor builder() method is creating a object
            /*CreateUserRequestBody requestBody = CreateUserRequestBody.builder().name(name).gender(gender)
                                                 .email(email).status(status).build();*/

            //to create a parameter cmd+option+P
            //2.Act - calling the API to create user

            //CreateUser method can be used by many other methods, hence saved the CreateUser method in seperate class
            //hence it will be used as reference to access CreateUser(body)
           CreateUserRequestBody requestBody =  new CreateUserRequestBody.Builder().gender("male").build();
            CreateUserResponse createUserResponse = usersService.CreateUser(requestBody);

            //assetUser is a method created in createUserResponse class which accepts request body and all
            // assertions for response will be stored here

            createUserResponse.assertUser(requestBody);
            //3.Assert - adding assertions to evaluate
                        /*.statusCode(201)
                        .body("id", Matchers.notNullValue())
                        .body("email", Matchers.equalTo(email))
                        .body("name", Matchers.equalTo("Tenali Ramkrishna"));*/
        }
        @Test
        public void createFemaleUser () {

            /*String email = String.format("%s@gmail.com",UUID.randomUUID());

            //1.Arrange - Arranging the data to create user
            //CreateUserRequestBody requestBody = new CreateUserRequestBody(name,gender,email,status);
            CreateUserRequestBody requestBody = CreateUserRequestBody.builder().name("Vinutha Mahadev").gender("female")
                    .email(email).status("active").build();*/

            //2.Act - calling the API to create user
            CreateUserRequestBody requestBody =  new CreateUserRequestBody.Builder().name("Vinutha").gender("female").build();
            CreateUserResponse createUserResponse = usersService.CreateUser(requestBody);
            createUserResponse.assertUser(requestBody);


            //3.Assert - adding assertions to evaluate
//                        .body("id", Matchers.notNullValue())
//                        .body("email", Matchers.equalTo(email))
//                        .body("name", Matchers.equalTo("Vinutha Mahadev"));


        }

    }

