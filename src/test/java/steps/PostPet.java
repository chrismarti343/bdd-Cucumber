package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pageobjects.BddT;

import static org.junit.Assert.assertEquals;

public class PostPet {

    private String petData;
    private int expectedCode;
    private Response response;


    @Given("I have this data:")
    public void dataGiven(String docString) {
        this.petData = docString;
    }

    @When("I send a post request with data")
    public void sendPostRequest() {

        this.response = BddT.PostPet(petData);
    }
    @Then("I receive the response code as {int}")
    public void verifyResponseCode(int status) {
        int ResponseCode = response.getStatusCode();
        assertEquals(ResponseCode,status );
        System.out.println("Testing message more here ");
    }
}
