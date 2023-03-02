package com.example.GrapQL.models;

public class UserProfile
{
    private String userId;

    private String userName;

    private String userEmail;

    private boolean userActive;

    private UserAddress userAddress;

    private UserCredential userCredential;

    private UserDetail userDetail;

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserEmail()
    {
        return userEmail;
    }

    public void setUserEmail(String userEmail)
    {
        this.userEmail = userEmail;
    }

    public boolean isUserActive()
    {
        return userActive;
    }

    public void setUserActive(boolean userActive)
    {
        this.userActive = userActive;
    }

    public UserAddress getUserAddress()
    {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress)
    {
        this.userAddress = userAddress;
    }

    public UserCredential getUserCredential()
    {
        return userCredential;
    }

    public void setUserCredential(UserCredential userCredential)
    {
        this.userCredential = userCredential;
    }

    public UserDetail getUserDetail()
    {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail)
    {
        this.userDetail = userDetail;
    }
}