package com.example.teslocal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceString {
    public static void main(String[] args) {
        String json = "{\"service\":\"dental\",\"plan\":\"basic\",\"npi\": 12321321,\"service\":\"dental\"}";

        // Replace key-value pairs and curly braces
        Pattern pattern = Pattern.compile("\"(\\w+)\":|\\{|\\}");
        Matcher matcher = pattern.matcher(json);
        String modifiedJson = matcher.replaceAll(match -> match.group(1) != null ? match.group(1) + ":" : ",").trim();

        System.out.println(modifiedJson);
    }
}
