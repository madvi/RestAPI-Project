package users.Create;

import lombok.Builder;
import lombok.Getter;

//@Getter is to cut of the multiple getter methods
@Getter
//@Builder is to avoid creating a object by calling constructor
@Builder
public class CreateUserRequestBody {

    private String name;
    private String gender;
    private String email;
    private String status;


    }


