package users.Create.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hamcrest.Condition;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CreateUserErrorResponse {

    @Setter
    private int statusCode;

    @JsonProperty
    private List<dataList> dataLists;

    public void assertHasError(String field,String message) {
        int size = dataLists.stream()
                .filter(dataList -> dataList.equals(field))
                .filter(dataList -> dataList.equals(message))
                .collect(Collectors.toList())
                .size();
        Assert.assertEquals(size,1);
    }


    //Inner class
    public static class dataList{
        private String field;
        private String message;

    }

}
