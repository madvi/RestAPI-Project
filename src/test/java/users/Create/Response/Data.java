package users.Create.Response;

import lombok.Getter;

@Getter
public class Data<D> {

    private int id;
    private String name;
    private String email;
    private String gender;
    private String status;
}
