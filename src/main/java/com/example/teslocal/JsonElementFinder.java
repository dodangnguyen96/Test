package com.example.teslocal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonElementFinder {

    public static void main(String[] args) {
        String jsonString1 = "[{\"medication\":{\"medicationID\":1,\"drugname\":\"a\",\"ndc:\":\"1223214\"}},{\"medication\":{\"medicationID\":2,\"drugname\":\"b\",\"ndc:\":\"454353\"}},{\"medication\":{\"medicationID\":3,\"drugname\":\"b\",\"ndc:\":\"34324\"}}]";
        String jsonString2 = "[{\"chum\":{\"medicationID\":1,\"drugname\":\"a\",\"ndc:\":\"1223214\"}},{\"chum\":{\"medicationID\":2,\"drugname\":\"b\",\"ndc:\":\"454353\"}},{\"chum\":{\"medicationID\":3,\"drugname\":\"b\",\"ndc:\":\"34324\"}}]";

        int targetMedicationID = 2;
        String targetField1 = "medicationID";
        String targetField2 = "drugname";
        String targetValue2 = "b";

        JSONObject foundObject1 = findElementByFieldValue(jsonString1, targetField1, targetMedicationID);
        JSONObject foundObject2 = findElementByFieldValue(jsonString2, targetField2, targetValue2);

        if (foundObject1 != null) {
            System.out.println("Found object in jsonString1: " + foundObject1.toString());
        } else {
            System.out.println("Element with " + targetField1 + " " + targetMedicationID + " not found in jsonString1.");
        }

        if (foundObject2 != null) {
            System.out.println("Found object in jsonString2: " + foundObject2.toString());
        } else {
            System.out.println("Element with " + targetField2 + " \"" + targetValue2 + "\" not found in jsonString2.");
        }
    }

    public static JSONObject findElementByFieldValue(String jsonString, String targetField, Object targetValue) {
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                JSONObject result = findElementByFieldValue(jsonObject, targetField, targetValue);
                if (result != null) {
                    return result;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null; // Element not found
    }

    private static JSONObject findElementByFieldValue(JSONObject jsonObject, String targetField, Object targetValue) throws JSONException {
        if (jsonObject.has(targetField) && jsonObject.get(targetField).equals(targetValue)) {
            return jsonObject;
        } else {
            // Check nested objects
            for (String key : jsonObject.keySet()) {
                if (jsonObject.get(key) instanceof JSONObject) {
                    JSONObject nestedObject = jsonObject.getJSONObject(key);
                    JSONObject result = findElementByFieldValue(nestedObject, targetField, targetValue);
                    if (result != null) {
                        return result;
                    }
                }
            }
        }
        return null; // Element not found
    }
}


