package com.neetgramming.utils;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
    public static void storePetIdInJsonFile(long petId) {
        JSONObject json = new JSONObject();
        json.put("id", petId);
        try (FileWriter file = new FileWriter("petId.json")) {
            file.write(json.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
