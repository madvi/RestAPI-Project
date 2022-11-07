import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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

            String email = String.format("%s@gmail.com",UUID.randomUUID());
            //1.Arrange - Arranging the data to create user
            //creating a variable that needs to be passed to create user method - cmd+option+V
            String body = String.format("{\n" +
                    "    \"name\": \"Tenali Ramkrishna\",\n" +
                    "    \"gender\": \"male\",\n" +
                    "    \"email\": \"%s\",\n" +
                    "    \"status\": \"active\"\n" +
                    "}",email);
            //to create a parameter cmd+option+P
            //2.Act - calling the API to create user

            //CreateUser method can be used by many other methods, hence saved the CreateUser method in seperate class
            //hence it will be used as reference to access CreateUser(body)
            usersClient.CreateUser(body)
                    .then()
                        .statusCode(201)
                        .log().body()

            //3.Assert - adding assertions to evaluate
                        .body("id", Matchers.notNullValue())
                        .body("email", Matchers.equalTo(email))
                        .body("name", Matchers.equalTo("Tenali Ramkrishna"));


        }
        @Test
        public void createFemaleUser () {

            String email = String.format("%s@gmail.com",UUID.randomUUID());

            //1.Arrange - Arranging the data to create user
            String body = String.format("{\n" +
                    "    \"name\": \"Vinutha Mahadev\",\n" +
                    "    \"gender\": \"male\",\n" +
                    "    \"email\": \"%s\",\n" +
                    "    \"status\": \"active\"\n" +
                    "}",email);

            //2.Act - calling the API to create user
            usersClient.CreateUser(body)
                    .then()
                        .statusCode(201)
                        .log().body()

            //3.Assert - adding assertions to evaluate
                        .body("id", Matchers.notNullValue())
                        .body("email", Matchers.equalTo(email))
                        .body("name", Matchers.equalTo("Vinutha Mahadev"));


        }

    }

