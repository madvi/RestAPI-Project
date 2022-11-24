package users.Create;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

//@Getter is to cut of the multiple getter methods
@Getter
//@Builder is to avoid creating a object by calling constructor

public class CreateUserRequestBody {

    private String name;
    private String gender;
    private String email;
    private String status;

    public CreateUserRequestBody(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.status = builder.status;
        this.gender = builder.gender;
    }

    public static class Builder{

        private String name;
        private String gender;
        private String email;
        private String status;

        public Builder() {
            this.name = "Tenali Ramkrishna";
            this.gender = "male";
            this.email = String.format("%s@gmail.com", UUID.randomUUID());
            this.status = "active";
        }

        //to accept the gender = female
        public Builder gender(String gender){
            this.gender = gender;
            return this;
        }

        public CreateUserRequestBody build(){
            CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody(this);
            return createUserRequestBody;
        }
        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder status(String status){
            this.status = status;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }
    }


    }


