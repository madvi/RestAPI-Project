package users.Create.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateUserResponse {

    @Setter //Need to set the status code explicitly so @Setter is required
    private int statusCode;

    private String meta;
    private Data data;

}
//CreateUserResponse is the pojo class(that held all the response data)