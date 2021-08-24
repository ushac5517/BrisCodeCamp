import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestTestSuite {

    @Test
    public void Status200Test() {
        given()
                .param("q", "Tascott").and().header("auth-key", "76eb35d9-6e8b-4ac6-b0e7-a58334c5259e").
        when()
                .get("https://digitalapi.auspost.com.au/postcode/search.json").
        then()
                .assertThat().statusCode(200);
    }

    @Test
    public void GivenQuery_GetPostcodeSearch_PostcodeTest() {
        given()
                .param("q", "Tascott").and().header("auth-key", "76eb35d9-6e8b-4ac6-b0e7-a58334c5259e").
                when()
                .get("https://digitalapi.auspost.com.au/postcode/search.json").
                then()
                .assertThat().statusCode(200).and().body("localities.locality.postcode", equalTo(2250));
    }

}
