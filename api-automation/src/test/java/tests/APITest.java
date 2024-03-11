package tests;

import com.neetgramming.data.Pet;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.TestBase;

import java.util.ArrayList;
import java.util.List;

import static com.neetgramming.utils.FileUtils.readPetIdFromJsonFile;
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

    @Test(priority = 1, testName = "POST-verifyCreatePet")
    public void testCreatePet() {
        tagList.add("cute");
        tagList.add("stray");
        pet = new Pet(1001, "Fluffy", "available", tagList);
        response = postPet(pet);
        petId = getResponseData(response, "id");
        storePetIdInJsonFile(petId);

        tagList.clear();
        tagList.add("black");
        tagList.add("hunting");
        pet = new Pet(1002, "James", "pending", tagList);
        response = postPet(pet);
        petId = getResponseData(response, "id");
        storePetIdInJsonFile(petId);

        tagList.clear();
        tagList.add("snowy");
        tagList.add("petting");
        pet = new Pet(1003, "Shane", "available", tagList);
        response = postPet(pet);
        petId = getResponseData(response, "id");
        storePetIdInJsonFile(petId);

        tagList.clear();
        tagList.add("Noisy");
        tagList.add("beauty");
        pet = new Pet(1004, "Banu", "sold", tagList);
        response = postPet(pet);
        petId = getResponseData(response, "id");
        storePetIdInJsonFile(petId);

        softAssert.assertEquals(getResponseCode(response), 200, "POSTPetResponseFails - Incorrect response code");
        softAssert.assertEquals(getStrResponseData(response, "name"), "Banu", "Incorrect Pet name");
        softAssert.assertAll();
    }

    @Test(priority = 2, testName = "PUT-verifyUpdatePet")
    public void testUpdatePet() {
        tagList.clear();
        tagList.add("Noisy");
        Long petId = readPetIdFromJsonFile();
        pet = new Pet(petId, "Banu2", "injured", tagList);
        response = putPet(pet);
        softAssert.assertEquals(getResponseCode(response), 200, "incorrect Response Code");
        softAssert.assertEquals(petId, getResponseData(response, "id"), "Pet id has changed");
        softAssert.assertEquals(getStrResponseData(response, "name"), "Banu2", "Pet name not updated");
        softAssert.assertAll();
    }

    @Test(priority = 3, testName = "GET-verifyGetPetsByStatus")
    public void testGetPetsByStatus() {
        response = getPetsByStatus("available");
        Assert.assertEquals(getResponseCode(response), 200, "Incorrect Response Code");
    }

    @Test(priority = 3, testName = "GET-verifyGetPetsByTag")
    public void testGetPetsByTag() {
        response = getPetsByTag("string");
        Assert.assertEquals(getResponseCode(response), 200, "Incorrect Response Code");
    }
}