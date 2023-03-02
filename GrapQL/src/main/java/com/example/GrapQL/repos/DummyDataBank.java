package com.example.GrapQL.repos;

import java.util.ArrayList;
import java.util.List;

import com.example.GrapQL.models.UserAddress;
import com.example.GrapQL.models.UserCredential;
import com.example.GrapQL.models.UserDetail;
import com.example.GrapQL.models.UserProfile;
import org.springframework.stereotype.Component;

@Component
public class DummyDataBank
{
    private static List<UserProfile> mockUserProfiles;

    static
    {
        mockUserProfiles = new ArrayList<UserProfile>();

        UserProfile profileToAdd = new UserProfile();

        profileToAdd.setUserId("00000001");
        profileToAdd.setUserName("testUser1");
        profileToAdd.setUserEmail("testUser1@test.org");
        profileToAdd.setUserActive(true);

        UserAddress userAddress = new UserAddress();
        userAddress.setUserAddressLine1("123 Main St.");
        userAddress.setUserAddressLine2("");
        userAddress.setUserCity("Kalamazoo");
        userAddress.setUserId("00000001");
        profileToAdd.setUserAddress(userAddress);

        UserDetail userDetail = new UserDetail();
        userDetail.setUserAge(35);
        userDetail.setUserFirstName("Lee");
        userDetail.setUserLastName("Junkie");
        userDetail.setUserGender("M");
        userDetail.setUserId("00000001");
        profileToAdd.setUserDetail(userDetail);

        UserCredential userCredential = new UserCredential();
        userCredential.setUserCredential("xxxxyyyyxxxxyyyy");
        userCredential.setUserId("00000001");
        profileToAdd.setUserCredential(userCredential);

        mockUserProfiles.add(profileToAdd);
    }

    public List<UserProfile> getAllUserProfiles()
    {
        return mockUserProfiles;
    }
}