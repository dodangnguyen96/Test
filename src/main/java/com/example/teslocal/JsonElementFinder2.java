package com.example.teslocal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonElementFinder2 {

    public static void main(String[] args) {
        String jsonString = "[{\"medication\":{\"medicationID\":1,\"drugname\":\"a\",\"ndc:\":\"1223214\"}},{\"medication\":{\"medicationID\":2,\"drugname\":\"b\",\"ndc:\":\"454353\"}},{\"medication\":{\"medicationID\":3,\"drugname\":\"b\",\"ndc:\":\"34324\"}}]";

        try {
            JSONArray jsonArray = new JSONArray(jsonString);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject.has("medication") && jsonObject.getJSONObject("medication").has("medicationID")) {
                    int medicationID = jsonObject.getJSONObject("medication").getInt("medicationID");
                    String medicationName = getMedicationNameByMedicationID(medicationID);
                    jsonObject.put("medicationname", medicationName);
                }
            }

            System.out.println("Updated JSON array: " + jsonArray.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static String getMedicationNameByMedicationID(int medicationID) {
        switch (medicationID) {
            case 1:
                return "a";
            case 2:
                return "b";
            case 3:
                return "c";
            default:
                return "unknown";
        }
    }
}
