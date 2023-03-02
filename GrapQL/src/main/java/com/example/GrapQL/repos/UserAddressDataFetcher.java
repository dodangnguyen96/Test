package com.example.GrapQL.repos;

import com.example.GrapQL.models.UserAddress;
import com.example.GrapQL.models.UserProfile;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserAddressDataFetcher  {
    @Autowired
    private UserAddressRepository userAddressRepository;

   public DataFetcher<List<UserAddress>> dataFetcherForAllUserAddress()
    {
        DataFetcher<List<UserAddress>> retVal = new DataFetcher<List<UserAddress>>() {
            @Override
            public List<UserAddress> get(DataFetchingEnvironment environment) {
                return userAddressRepository.findAll();
            }
        };

        return retVal;
    }

}
