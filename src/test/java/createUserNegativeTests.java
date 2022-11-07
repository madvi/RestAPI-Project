import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClient;

public class createUserNegativeTests {

    @Test
    public void shouldNotAllowNegativeTests(){
        String body = "{\n" +
                "    \"name\": \"Tenali Ramkrishna\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"tenali.ramkrishnace.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        new UsersClient().CreateUser(body)
                .then()
                .log().body()
                .statusCode(422)
                //.body(Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("field", Matchers.hasItem("email"))
                //.body(Matchers.hasItem(Matchers.hasEntry("message","is invalid")))
                .body("message", Matchers.hasItem("is invalid"));

    }
}
