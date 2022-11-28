package users.getUserByID;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;
import users.Create.CreateUserRequestBody;

@Getter
public class GetAllUserResponseById {

    @Setter
    private int statusCode;

    private Data data;
    private String meta;

    public void assertUser(CreateUserRequestBody requestBody) {
        Assert.assertEquals(data.email,requestBody.getEmail());
        Assert.assertEquals(data.name,requestBody.getName());
        Assert.assertEquals(data.gender,requestBody.getGender());
        Assert.assertEquals(data.status,requestBody.getStatus());
    }

    @Getter
    public static class Data{
        private String gender;
        private String name;
        private String id;
        private String email;
        private String status;
    }
}

