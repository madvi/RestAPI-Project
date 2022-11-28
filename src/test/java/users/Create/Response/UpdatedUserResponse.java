package users.Create.Response;

import lombok.Getter;
import lombok.Setter;
import users.Create.CreateUserRequestBody;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@Getter
public class UpdatedUserResponse {

    @Setter
    private int statusCode;

    private String meta;
    private Data data;

    private int id;
    private String name;
    private String email;
    private String gender;
    private String status;

    public void assertUser(UpdatedUserResponse requestBody) {
        assertEquals(this.getStatusCode(),200);
        assertNotNull(this.getData().getId());
        assertEquals(this.getData().getEmail(),requestBody.getEmail());
        assertEquals(this.getData().getName(),requestBody.getName());
        assertEquals(this.getData().getGender(),requestBody.getGender());
        assertEquals(this.getData().getStatus(),requestBody.getStatus());
    }
}
