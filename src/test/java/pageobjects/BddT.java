package pageobjects;

import io.cucumber.datatable.DataTable;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.List;

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

    public class User {
        private int id;
        private String username;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String phone;
        private int userStatus;

        public int getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public String getPhone() {
            return phone;
        }

        public int getUserStatus() {
            return userStatus;
        }
    }

    public static  Response PostUser(String userData) {

        return  given()
                .contentType(ContentType.JSON)
                .body("[" +userData+ "]")
                .post("https://petstore.swagger.io/v2/user/createWithList"); // adding a comment
    }


}
