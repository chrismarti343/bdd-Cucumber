package steps;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class BddT {

    public static Response GetPetInformation(int id) {

        return given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://petstore.swagger.io/v2/pet/"+id);
    }

    public static Response PostPet(String petData) {

        JSONObject petJson = new JSONObject(petData);

        return  given()
                .contentType(ContentType.JSON)
                .body(petJson.toString())
                .post("https://petstore.swagger.io/v2/store/order");
    }


}
