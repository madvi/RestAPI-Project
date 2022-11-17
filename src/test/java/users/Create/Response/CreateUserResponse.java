package users.Create.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateUserResponse {

    @Setter //Need to set the status code explicitly so @Setter is required
    private int statusCode;
    private int id;
    private String name;
    private String email;
    private String gender;
    private String status;
}
//CreateUserResponse is the pojo class(that held all the response data)