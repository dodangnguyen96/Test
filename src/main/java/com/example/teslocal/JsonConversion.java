package com.example.teslocal;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class JsonConversion {
    public static void main(String[] args) {
        String inputJson = "[\n" +
                "    {\n" +
                "        \"medication\": {\n" +
                "            \"medicationID\": 1,\n" +
                "            \"drugname\": \"a\",\n" +
                "            \"ndc:\": \"1223214\"\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"medication\": {\n" +
                "            \"medicationID\": 2,\n" +
                "            \"drugname\": \"b\",\n" +
                "            \"ndc:\": \"454353\"\n" +
                "        }\n" +
                "    }\n" +
                "]";

        String convertedJson = convertJson(inputJson);
        System.out.println(convertedJson);
    }

    public static String convertJson(String inputJson) {
        try {
            JsonNode root = new ObjectMapper().readTree(inputJson);
            List<String> data = new ArrayList<>();
            for(int i=0;i<=1;i++){
                data.add(root.get(i).toString());
            }




return data.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

