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

    private String meta;

    //While running it will be looking for "data" which we have used as "dataList"
    //by using JsonProperty we can tell dataList is nothing but data
    @JsonProperty("data")
    private List<Data> dataList;

    //Iterating over data array, and one item should should match with field = email and message = is invalid
    public void assertHasError(String field, String message) {
        int size = dataList.stream()
                .filter(data -> data.getField().equals(field))
                .filter(data -> data.getMessage().equals(message))
                .collect(Collectors.toList())
                .size();
        //one item in the array should meet the condition from -ve test class, hence asserting for the size 1
        Assert.assertEquals(size,1);
    }

    @Getter
    public static class Data{
        private String field;
        private String message;

    }
}
