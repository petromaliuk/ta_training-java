package com.epam.ta.service;

import com.epam.ta.model.User;

public class UserCreator {

    public static final String TESTDATA_USER_NAME = "testdata.user.name";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";
    public static final String TESTDATA_GOOD_USER_NAME = "testdata.gooduser.name";
    public static final String TESTDATA_GOOD_USER_PASSWORD = "testdata.gooduser.password";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }
    public static User withGoodCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(TESTDATA_GOOD_USER_NAME),
                TestDataReader.getTestData(TESTDATA_GOOD_USER_PASSWORD));
    }

    public static User withEmptyUsername(){
        return new User("", TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }

    public static User withEmptyPassword(){
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME), "");
    }
}
