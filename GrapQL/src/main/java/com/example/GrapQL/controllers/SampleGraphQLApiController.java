package com.example.GrapQL.controllers;

import java.io.IOException;
import java.util.Map;

import com.example.GrapQL.services.GraphQLProvider;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import graphql.ExecutionResult;

@RestController
public class SampleGraphQLApiController {
    private GraphQLProvider _queryProvider;

    public SampleGraphQLApiController(GraphQLProvider queryProvider) {
        _queryProvider = queryProvider;
    }

    @PostMapping(value = "/api/allUserProfiles")
    public String allUserProfiles(@RequestBody String queryVal) throws IOException {
        ExecutionResult result = _queryProvider.graphQL().execute(queryVal);
        Map<String, Object> resp = (Map<String, Object>) result.getData();
        String retVal = new ObjectMapper().writeValueAsString(resp);

        return retVal;
    }
}