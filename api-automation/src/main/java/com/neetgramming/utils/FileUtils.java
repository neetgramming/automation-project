package com.neetgramming.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
    private static String JSON_FILE_PATH = System.getProperty("user.dir") + "/src/main/resources/petId.json";
    public static void storePetIdInJsonFile(long petId) {
        JSONObject json = new JSONObject();
        json.put("id", petId);
        try (FileWriter file = new FileWriter(JSON_FILE_PATH)) {
            file.write(json.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Long readPetIdFromJsonFile() {
        Long petId;
        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(JSON_FILE_PATH));
            petId = (Long) jsonObject.get("id");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return petId;
    }
}