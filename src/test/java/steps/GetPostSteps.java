package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pageobjects.BddT;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;



public class GetPostSteps {

    public RequestSpecification httpRequest;
    public Response response;

    @Given("I create a new pet with name {string}, ID {int} and status {string}")
    public void createPet(String name, int id, String status) {
        System.out.println("Creating pet: name=" + name + ", id=" + id + ", status=" + status);

        given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": " + id + ",\n" +
                        "  \"name\": \"" + name + "\",\n" +
                        "  \"status\": \"" + status + "\"\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200);

    }

    @When("I retrieve the pet information for ID {int}")
    public void retrievePetInfo(int id) {
        BddT.GetPetInformation(id);
    }


    @Then("the response status code is {int} and the pet name is {string} if is shearched by ID {int}")
    public void IsShearchedByID(int status, String petName, int id) {

//        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
//        httpRequest = RestAssured.given();
//        response = httpRequest.get("pet");

//        Response response = given()
//                .contentType(ContentType.JSON)
//                .when()
//                .get("https://petstore.swagger.io/v2/pet/"+id);

        Response response = BddT.GetPetInformation(id);

        System.out.println("Response status code: " + response.statusCode());
        System.out.println("Response body 22 test: " + response.body().asString());
        Base.colorGreen("Texting color green");

        response.then()
                .body("name", is(petName));

        int ResponseCode = response.getStatusCode();

        assertEquals(ResponseCode,200 );
    }
}