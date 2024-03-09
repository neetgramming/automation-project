package tests;

import com.neetgramming.data.Pet;
import com.neetgramming.utils.ResponseUtil;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.TestBase;

import java.util.ArrayList;
import java.util.List;

import static com.neetgramming.utils.FileUtils.storePetIdInJsonFile;
import static com.neetgramming.utils.ResponseUtil.*;

public class APITest extends TestBase {
    private Pet pet;
    private List<String> tagList = new ArrayList<>();
    private SoftAssert softAssert = new SoftAssert();
    private Response response;
    private long petId;

    @BeforeClass
    public void initClass() {
        RestAssured.baseURI = BASE_URI;
    }

    @Test(priority = 1, testName = "POST-pet")
    public void testCreatePets() {
        tagList.add("cute");
        tagList.add("stray");
        pet = new Pet("Fluffy", "available", tagList);
        response = postPet(pet);
        softAssert.assertEquals(ResponseUtil.getResponseCode(response), 200, "incorrect code");
        petId = getPetId(response, "id");
        storePetIdInJsonFile(petId);

        tagList.clear();
        tagList.add("black");
        tagList.add("hunting");
        pet = new Pet("James", "taming", tagList);
        response = postPet(pet);
        softAssert.assertEquals(ResponseUtil.getResponseCode(response), 200, "incorrect code");
        petId = getPetId(response, "id");
        storePetIdInJsonFile(petId);

        tagList.clear();
        tagList.add("snowy");
        tagList.add("petting");
        pet = new Pet("Shane", "available", tagList);
        response = postPet(pet);
        softAssert.assertEquals(ResponseUtil.getResponseCode(response), 200, "incorrect code");
        petId = getPetId(response, "id");
        storePetIdInJsonFile(petId);

        tagList.clear();
        tagList.add("Noisy");
        tagList.add("beauty");
        pet = new Pet("Banu", "reserved", tagList);
        response = postPet(pet);
        softAssert.assertEquals(ResponseUtil.getResponseCode(response), 200, "incorrect code");
        petId = getPetId(response, "id");
        storePetIdInJsonFile(petId);
    }

    @Test(priority = 2, testName = "PUT-updatePet")
    public void testUpdatePet() {
        tagList.clear();
        tagList.add("Noisy");
        pet = new Pet(petId, "Banu2", "injured", tagList);
        response = putPet(pet);
        softAssert.assertEquals(ResponseUtil.getResponseCode(response), 200, "incorrect code");
    }

}
