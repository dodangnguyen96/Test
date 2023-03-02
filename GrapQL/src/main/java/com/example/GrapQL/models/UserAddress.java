package com.example.GrapQL.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserAddress
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userId;

    private String userAddressLine1;

    private String userAddressLine2;

    private String userCity;

    private String userState;

    private String userZipCode;

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getUserAddressLine1()
    {
        return userAddressLine1;
    }

    public void setUserAddressLine1(String userAddressLine1)
    {
        this.userAddressLine1 = userAddressLine1;
    }

    public String getUserAddressLine2()
    {
        return userAddressLine2;
    }

    public void setUserAddressLine2(String userAddressLine2)
    {
        this.userAddressLine2 = userAddressLine2;
    }

    public String getUserCity()
    {
        return userCity;
    }

    public void setUserCity(String userCity)
    {
        this.userCity = userCity;
    }

    public String getUserState()
    {
        return userState;
    }

    public void setUserState(String userState)
    {
        this.userState = userState;
    }

    public String getUserZipCode()
    {
        return userZipCode;
    }

    public void setUserZipCode(String userZipCode)
    {
        this.userZipCode = userZipCode;
    }
}