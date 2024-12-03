package positiveTests.settingsForPositiveTests;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseApi {
    public RequestSpecification spec;

    public BaseApi() {
        spec = RestAssured.given()
                .baseUri("https://petstore.swagger.io/v2")
                .contentType("application/json");
    }

}
