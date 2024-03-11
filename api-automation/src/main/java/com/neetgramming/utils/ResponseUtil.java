package com.neetgramming.utils;

import com.neetgramming.data.Pet;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ResponseUtil {
    private static JSONObject petObject;
//    public static Response postPet(Pet pet) {
//        petObject = createPetJsonObject(pet);
//        return RestAssured.given()
//                .contentType(ContentType.JSON)
//                .body(petObject.toJSONString())
//                .post("/pet");
//    }
//
//    public static Response putPet(Pet pet) {
//        petObject = createPetJsonObjectWithId(pet);
//        return RestAssured.given()
//                .contentType(ContentType.JSON)
//                .body(petObject.toJSONString())
//                .put("/pet");
//    }
//
//    public static Response getPetsByStatus(String status) {
//        return RestAssured.given()
//                .queryParam("status", status)
//                .get("/pet/findByStatus");
//    }
//
//    public static Response getPetsByTag(String tag) {
//        return RestAssured.given()
//                .queryParam("tags", tag)
//                .get("/pet/findByTags");
//    }
//
//    public static int getResponseCode(Response response) {
//        return response.getStatusCode();
//    }
//
//    public static Long getResponseData(Response response, String path) {
//        return response.then().extract().path(path);
//    }
//
//    public static String getStrResponseData(Response response, String path) {
//        return response.then().extract().path(path);
//    }

//    private static JSONObject createPetJsonObject(Pet pet) {
//        JSONObject petObject = new JSONObject();
//        petObject.put("name", pet.getName());
//        JSONArray tagsArray = new JSONArray();
//        for (String tag : pet.getTags()) {
//            JSONObject tagObject = new JSONObject();
//            tagObject.put("name", tag);
//            tagsArray.add(tagObject);
//        }
//        petObject.put("tags", tagsArray);
//        petObject.put("status", pet.getStatus());
//        return petObject;
//    }
//
//    private static JSONObject createPetJsonObjectWithId(Pet pet) {
//        JSONObject petObject = new JSONObject();
//        petObject.put("id", pet.getId());
//        petObject.put("name", pet.getName());
//        JSONArray tagsArray = new JSONArray();
//        for (String tag : pet.getTags()) {
//            JSONObject tagObject = new JSONObject();
//            tagObject.put("name", tag);
//            tagsArray.add(tagObject);
//        }
//        petObject.put("tags", tagsArray);
//        petObject.put("status", pet.getStatus());
//        return petObject;
//    }
}