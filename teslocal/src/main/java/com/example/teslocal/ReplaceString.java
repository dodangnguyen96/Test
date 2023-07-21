package com.example.teslocal;

public class ReplaceString {
    public static void main(String[] args) {
        String json = "{\n  \"service\": \"dental\",\n  \"plan\": \"basic\"\n,\n  \"npi\": 12321321\n}";
//        String json = "";

// Remove double quotes around keys
        String modifiedJson = json.replaceAll("\"(\\w+)\":", "$1:").replaceAll("\\{",",").replaceAll("}","").trim();

        System.out.println(modifiedJson);
    }
}
