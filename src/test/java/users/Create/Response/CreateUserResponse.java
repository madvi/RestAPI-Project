package users.Create.Response;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;
import users.Create.CreateUserRequestBody;

@Getter
public class CreateUserResponse {

    @Setter //Need to set the status code explicitly so @Setter is required
    private int statusCode;

    private String meta;
    private Data data;

    public void assertUser(CreateUserRequestBody requestBody) {

        Assert.assertEquals(this.getStatusCode(),201);
        Assert.assertNotNull(this.getData().getId());
        Assert.assertEquals(this.getData().getEmail(),requestBody.getEmail());
        Assert.assertEquals(this.getData().getName(),requestBody.getName());
        Assert.assertEquals(this.getData().getGender(),requestBody.getGender());
        Assert.assertEquals(this.getData().getStatus(),requestBody.getStatus());
    }
}
//CreateUserResponse is the pojo class(that held all the response data)
//for deserializing json response to CreateUserResponse class