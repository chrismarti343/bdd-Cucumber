package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pageobjects.BddT;

import static org.junit.Assert.assertEquals;

public class UsersPet {
    private String userData;
    private Response resp;
    private String userDataFormat;

    @Given("a list to add users")
    public void aListToAddUsers(String userData) {
        this.userData = userData;
        System.out.println("data from feature:"+ userData);
    }

    @When("I sent the request with the data")
    public void iSentTheRequestWithTheData() {
        this.resp = BddT.PostUser(userData);
    }


    @Then("It should return {int} code")
    public void itShouldReturnCode(int expectedStatus) {

        int actualStatus = resp.getStatusCode();
        assertEquals(expectedStatus, actualStatus);
    }
}
