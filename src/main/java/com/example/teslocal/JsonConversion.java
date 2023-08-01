package com.example.teslocal;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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
            StringBuilder sb = new StringBuilder("[\n");

            for (JsonNode node : root) {
                JsonNode medicationNode = node.get("medication");
                if (medicationNode != null) {
                    int medicationID = medicationNode.get("medicationID").asInt();
                    String drugname = medicationNode.get("drugname").asText();
                    sb.append(String.format("    {\"medicationID\": %d, \"drugname\": \"%s\"},\n", medicationID, drugname));
                }
            }

            sb.setLength(sb.length() - 2); // Remove the trailing comma and newline
            sb.append("\n]");

            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

