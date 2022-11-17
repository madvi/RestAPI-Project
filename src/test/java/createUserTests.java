import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.Create.CreateUserRequestBody;
import users.Create.Response.CreateUserResponse;
import users.UsersClient;

import java.util.UUID;


public class createUserTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass() {
        usersClient = new UsersClient();
    }


        @Test
        public void createMaleUser () {

            String email = String.format("%s@gmail.com", UUID.randomUUID());
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
            CreateUserRequestBody requestBody = CreateUserRequestBody.builder().name(name).gender(gender)
                                                 .email(email).status(status).build();

            //to create a parameter cmd+option+P
            //2.Act - calling the API to create user

            //CreateUser method can be used by many other methods, hence saved the CreateUser method in seperate class
            //hence it will be used as reference to access CreateUser(body)
            CreateUserResponse createUserResponse = usersClient.CreateUser(requestBody);
            Assert.assertEquals(createUserResponse.getStatusCode(),201);
            Assert.assertEquals(createUserResponse.getEmail(),requestBody.getEmail());
            Assert.assertNotNull(createUserResponse.getId());


            //Modifying below assertions and adding it above

            //3.Assert - adding assertions to evaluate
                        /*.statusCode(201)
                        .body("id", Matchers.notNullValue())
                        .body("email", Matchers.equalTo(email))
                        .body("name", Matchers.equalTo("Tenali Ramkrishna"));*/


        }
        @Test
        public void createFemaleUser () {

            String email = String.format("%s@gmail.com",UUID.randomUUID());

            String name = "Vinutha Mahadev";
            String gender = "female";
            String status = "active";

            //1.Arrange - Arranging the data to create user
            //CreateUserRequestBody requestBody = new CreateUserRequestBody(name,gender,email,status);
            CreateUserRequestBody requestBody = CreateUserRequestBody.builder().name(name).gender(gender)
                    .email(email).status(status).build();

            //2.Act - calling the API to create user
            CreateUserResponse createUserResponse = usersClient.CreateUser(requestBody);
            Assert.assertEquals(createUserResponse.getStatusCode(),201);
            Assert.assertEquals(createUserResponse.getEmail(),requestBody.getEmail());
            Assert.assertNotNull(createUserResponse.getId());


            //3.Assert - adding assertions to evaluate
//                        .body("id", Matchers.notNullValue())
//                        .body("email", Matchers.equalTo(email))
//                        .body("name", Matchers.equalTo("Vinutha Mahadev"));


        }

    }

