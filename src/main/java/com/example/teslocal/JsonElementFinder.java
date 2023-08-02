package com.example.teslocal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonElementFinder {

    public static void main(String[] args) {
        String jsonString = "[{\"medication\":{\"medicationID\":1,\"drugname\":\"a\",\"ndc:\":\"1223214\"}},{\"medication\":{\"medicationID\":2,\"drugname\":\"b\",\"ndc:\":\"454353\"}},{\"medication\":{\"medicationID\":3,\"drugname\":\"b\",\"ndc:\":\"34324\"}}]";

        try {
            JSONArray jsonArray = new JSONArray(jsonString);

            int targetMedicationID = 2;

            JSONObject foundObject = findElementByFieldValue(jsonArray, "medicationID", targetMedicationID);

            if (foundObject != null) {
                System.out.println("Found object: " + foundObject.toString());
            } else {
                System.out.println("Element with medicationID " + targetMedicationID + " not found.");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject findElementByFieldValue(JSONArray jsonArray, String fieldName, int fieldValue) {
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject.has("medication") && jsonObject.getJSONObject("medication").has(fieldName) && jsonObject.getJSONObject("medication").getInt(fieldName) == fieldValue) {
                    return jsonObject;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null; // Element not found
    }
}

