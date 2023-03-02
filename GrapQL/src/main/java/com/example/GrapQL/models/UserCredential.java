package com.example.GrapQL.models;

public class UserCredential
{
    private String userId;

    private String userCredential;

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getUserCredential()
    {
        return userCredential;
    }

    public void setUserCredential(String userCredential)
    {
        this.userCredential = userCredential;
    }
}