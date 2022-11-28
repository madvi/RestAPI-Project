package users.getUserByID;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;
import users.Create.CreateUserRequestBody;

@Getter
public class GetAllUserErrorResponse {

    @Setter
    private int statusCode;

    private Data data;
    private String meta;

    public void assertError(int expectedStatusCode, String expectedMessage) {
        Assert.assertEquals(statusCode,expectedStatusCode);
        Assert.assertEquals(data.message,expectedMessage);
    }

    @Getter
    public static class Data{
        private String message;
    }
}

