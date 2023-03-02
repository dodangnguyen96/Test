package com.example.GrapQL.repos;

import java.util.List;
import java.util.stream.Collectors;

import com.example.GrapQL.models.UserProfile;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllUserProfilesFetchersFactory
{
    private DummyDataBank _dataBank;

    public AllUserProfilesFetchersFactory(DummyDataBank dataBank)
    {
        _dataBank = dataBank;
    }

    public DataFetcher<List<UserProfile>> dataFetcherForAllUserProfiles()
    {
        DataFetcher<List<UserProfile>> retVal = new DataFetcher<List<UserProfile>>() {
            @Override
            public List<UserProfile> get(DataFetchingEnvironment environment) {
                System.out.println("data fetcher for all user profiles retrieval.");
                return _dataBank.getAllUserProfiles();
            }
        };

        return retVal;
    }

    public DataFetcher<List<UserProfile>> dataFetcherForUserProfilesByAge()
    {
        DataFetcher<List<UserProfile>> retVal = new DataFetcher<List<UserProfile>>() {
            @Override
            public List<UserProfile> get(DataFetchingEnvironment environment) {
                int expectedAge = (int)environment.getArgument("age");
                System.out.println("data fetcher for user profiles based by age retrieval. Age: " + expectedAge);
                List<UserProfile> retVal =
                        _dataBank.getAllUserProfiles()
                                .stream()
                                .filter( x -> x.getUserDetail() != null &&
                                        x.getUserDetail().getUserAge() == expectedAge)
                                .collect(Collectors.toList());
                return retVal;
            }
        };

        return retVal;
    }
}