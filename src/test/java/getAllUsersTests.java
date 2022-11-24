import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.UsersService;
import users.getAllUsers.GetAllUsersResponse;

import static io.restassured.RestAssured.given;

public class getAllUsersTests {

    private UsersService usersService;
    @BeforeClass
    public void beforeClass(){
        usersService = new UsersService();
    }
    @Test
    public void GetListOfUsers(){

        GetAllUsersResponse getAllUsersResponse = usersService.getAllUsers();

        //Assert
        Assert.assertEquals(getAllUsersResponse.getStatusCode(),200);
        Assert.assertEquals(getAllUsersResponse.getDataList().size(),10);
        Assert.assertTrue(getAllUsersResponse.hasMaleUser());

    }


}
//Using AAA pattern
//Arrange
//Act- to write the code
//Assert- to evaluate the expected output
//given() - to add pre-requisites like header,body etc
//when() - to write the actual code for the testcase
//then() - to evaluate the response