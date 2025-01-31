package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;

public class PetStoreSteps {

    private String requestBodyTemplate;
    private Response response;

    @When("I send a POST request with body:")
    public void sendPostRequest(String formattedBody) {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(formattedBody)
                .post("https://petstore.swagger.io/v2/store/order"); // post store orde
    }

    @Then("I should get {int} code")
    public void verifyStatusCode(int code) {
        int ResponseCode = response.getStatusCode();
        assertEquals(ResponseCode,code );
    }
}
