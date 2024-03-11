package steps.post;

import com.neetgramming.data.CreateJsonObjectData;
import com.neetgramming.data.Pet;
import com.neetgramming.utils.ResponseUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import javax.xml.crypto.Data;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class CreatePet {
    private Response response;
    private JSONObject petJsonObject;

    public static void main(String arg) {

    }

    @Given("I have the following Pet Data")
    public void iHaveTheFollowingPetData(DataTable petData) {
        given().contentType(ContentType.JSON).body(CreateJsonObjectData.getPetJsonObject(petData));
    }

    @When("I send a POST request to {string}")
    public void iSendAPOSTRequestTo(String endPoint) {
        when().post(endPoint).then().assertThat().statusCode(200);
    }

    @Then("the status code should be {int}")
    public void theStatusCodeShouldBe(int arg0) {
    }

    @And("the response should contain the pet details")
    public void theResponseShouldContainThePetDetails() {
    }
}
