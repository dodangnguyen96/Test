package com.example.GrapQL.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import com.example.GrapQL.repos.AllUserProfilesFetchersFactory;
import com.example.GrapQL.repos.UserAddressDataFetcher;
import com.example.GrapQL.repos.UserAddressRepository;
import graphql.schema.DataFetcher;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GraphQLProvider  {
    private GraphQL _graphQL;
    @Autowired
    private UserAddressDataFetcher userAddressDataFetcher;
    private AllUserProfilesFetchersFactory _dataFetcherFactory;

    public GraphQLProvider(AllUserProfilesFetchersFactory dataFetcherFactory) {
        _dataFetcherFactory = dataFetcherFactory;
    }

    @Bean
    public GraphQL graphQL() {
        return _graphQL;
    }

    @PostConstruct
    public void init() throws IOException {
        ClassPathResource resLoader = new ClassPathResource("schema.graphql");
        InputStream inStr = resLoader.getInputStream();
        Reader typeReader = new InputStreamReader(inStr);

        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(typeReader);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        GraphQLSchema schema = schemaGenerator.makeExecutableSchema
                (typeRegistry, runtimeWiring);

        _graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring.dataFetcher
                        ("userProfiles", _dataFetcherFactory.dataFetcherForAllUserProfiles()))
                .type("Query", typeWiring -> typeWiring.dataFetcher
                        ("userProfilesByAge", _dataFetcherFactory.
                                dataFetcherForUserProfilesByAge()))
                .type("Query", typeWiring -> typeWiring.dataFetcher
                        ("userAddress", userAddressDataFetcher.dataFetcherForAllUserAddress())).build();
    }
}