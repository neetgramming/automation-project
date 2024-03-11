package com.neetgramming.data;

import io.cucumber.datatable.DataTable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

public class CreateJsonObjectData {
    private static final String JSON_KEY = "key";
    private static final String JSON_VALUE = "value";

    public static JSONObject getJsonObject(DataTable user) {
        JSONObject petData = new JSONObject();
        for(Map<String, String> data : user.asMaps(String.class, String.class)) {
            petData.put(data.get(JSON_KEY), data.get(JSON_VALUE));
        }

        return petData;
    }

    public static JSONObject getPetJsonObject(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        JSONArray petArray = new JSONArray();

        for(Map<String, String> row : rows) {
            JSONObject petObject = new JSONObject();
            petObject.put("name", row.get("name"));

            JSONObject categoryObject = new JSONObject();
            categoryObject.put("name", row.get("category.name"));
            petObject.put("category", categoryObject);

            JSONArray tagsArray = new JSONArray();
            String[] tags = row.get("tags").split(",");
            for (String tag: tags) {
                JSONObject tagObject = new JSONObject();
                tagObject.put("name", tag);
                tagsArray.add(tagObject);
            }
            petObject.put("tags", tagsArray);

            petObject.put("status", row.get("status"));
            petArray.add(petObject);
        }

        System.out.println(petArray.toJSONString());
        return (JSONObject) new JSONObject().put("", petArray);
    }
}
