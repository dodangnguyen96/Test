package com.example.GrapQL.models;

public class UserDetail
{
    private String userId;

    private String userFirstName;

    private String userLastName;

    private String userGender;

    private int userAge;

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getUserFirstName()
    {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName)
    {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName()
    {
        return userLastName;
    }

    public void setUserLastName(String userLastName)
    {
        this.userLastName = userLastName;
    }

    public String getUserGender()
    {
        return userGender;
    }

    public void setUserGender(String userGender)
    {
        this.userGender = userGender;
    }

    public int getUserAge()
    {
        return userAge;
    }

    public void setUserAge(int userAge)
    {
        this.userAge = userAge;
    }
}