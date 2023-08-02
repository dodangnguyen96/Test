package com.example.teslocal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonElementFinder {

    public static void main(String[] args) {
        String jsonString = "[{\"id\":1,\"name\":\"John\"}, {\"id\":2,\"name\":\"Alice\"}, {\"id\":3,\"name\":\"Bob\"}]";
        int targetId = 2;

        try {
            JSONArray jsonArray = new JSONArray(jsonString);

            JSONObject foundObject = findElementByFieldValue(jsonArray, "id", targetId);

            if (foundObject != null) {
                System.out.println("Found object: " + foundObject.toString());
            } else {
                System.out.println("Element with id " + targetId + " not found.");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject findElementByFieldValue(JSONArray jsonArray, String fieldName, int fieldValue) {
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject.has(fieldName) && jsonObject.getInt(fieldName) == fieldValue) {
                    return jsonObject;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null; // Element not found
    }
}
