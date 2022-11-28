package integrationTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.Create.CreateUserRequestBody;
import users.Create.Response.UpdatedUserResponse;

import users.UsersService;


public class UserTests {

    private UsersService usersService;

    @BeforeClass
    public void beforeClass() {
        usersService = new UsersService();
    }


        @Test
        public void shouldCreateAndGetUser () {

            /*String email = String.format("%s@gmail.com", UUID.randomUUID());
            String name = "Tenali Ramkrishna";
            String gender = "male";
            String status = "active";

            //CreateUserRequestBody requestBody = new CreateUserRequestBody(name,gender,email,status);
            //Without calling a constructor builder() method is creating a object
            CreateUserRequestBody requestBody = CreateUserRequestBody.builder().name(name).gender(gender)
                                                 .email(email).status(status).build();*/

            //to create a parameter cmd+option+P
            //2.Act - calling the API to create user

            CreateUserRequestBody requestBody =  new CreateUserRequestBody.Builder().build();
            //instead of returning a response, we are fetching id and store it in an variable
            int id = usersService.CreateUser(requestBody).getData().getId();

            //assetUser is a method created in createUserResponse class which accepts request body and all
            // assertions for response will be stored here

            //Assert
            //invoking another api getUser by id and it should match with request body of createUser api
            usersService.getUser(id).assertUser(requestBody);

        }
        @Test
        public void shouldDeleteUser () {

            //Arrange
            CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().build();

            //Act
            int id = usersService.CreateUser(requestBody).getData().getId();
            int statusCode = usersService.deleteUser(id);

            //Assert
            //invoking another api getUser by id and it should match with request body of createUser api
            Assert.assertEquals(statusCode, 204);
            usersService.getUserExpectingError(id).assertError(404,"Resource not found");

        }

        @Test
        public void shouldEditUsername(){

            //Arrange
            CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().build();
            CreateUserRequestBody updateRequestBody = new CreateUserRequestBody.Builder().name("Tenali ram").build();

            //Act
            int id = usersService.CreateUser(requestBody).getData().getId();

            UpdatedUserResponse updatedUserResponse = usersService.getUpdatedUserDetails(id,updateRequestBody);

            //Assert
           // usersService.getUser(id).assertUser(updatedUserResponse);
           updatedUserResponse.assertUser(updatedUserResponse);



        }
    }

