package com.example.teslocal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceString {
    public static void main(String[] args) {


        System.out.println(test2());
    }

    private static String test() {
        String json = "{\"service\":\"dental\",\"plan\":\"basic\",\"npi\": 12321321,\"service\":\"dental\"}";

        // Replace key-value pairs and curly braces
        Pattern pattern = Pattern.compile("\"(\\w+)\":|\\{|\\}");
        Matcher matcher = pattern.matcher(json);
        String modifiedJson = matcher.replaceAll(match -> match.group(1) != null ? match.group(1) + ":" : "").trim();

        return modifiedJson.toString();
    }

    private static String test2() {
        String json = "{\"service\":\"dental\",\"plan\":\"basic\",\"npi\": 12321321,\"service\":\"dental\"}";
        Pattern pattern = Pattern.compile("\"(\\w+)\":|\\{|\\}");
        Matcher matcher = pattern.matcher(json);
        StringBuilder result = new StringBuilder();
        int lastMatchEnd = 0;

        while (matcher.find()) {
            result.append(json, lastMatchEnd, matcher.start());
            if (matcher.group(1) != null) {
                result.append(matcher.group(1)).append(":");
            }
            lastMatchEnd = matcher.end();
        }

        result.append(json, lastMatchEnd, json.length());

        String arguments = result.toString().trim();
        arguments = arguments.isEmpty() ? arguments : String.format("%s)", arguments);
       return arguments;

    }
    Matcher matcher = pattern.matcher(functionCall.getArguments());
    StringBuilder result = new StringBuilder();
    int lastMatchEnd = 0;

while (matcher.find()) {
        result.append(functionCall.getArguments(), lastMatchEnd, matcher.start());
        if (matcher.group(1) != null) {
            result.append(matcher.group(1)).append(":");
        }
        lastMatchEnd = matcher.end();
    }

result.append(functionCall.getArguments(), lastMatchEnd, functionCall.getArguments().length());

    String arguments = result.toString().trim();
    arguments = arguments.isEmpty() ? arguments : String.format("%s)", arguments);
this.query = String.format("%s%s{code data error}}", functionCall.getName(), arguments);

}
