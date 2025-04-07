package com.breaktomake.tests;

import com.breaktomake.utils.CsvDataProvider;
import org.testng.annotations.Test;

public class ProviderTest {

    @Test(dataProvider = "validLoginData", dataProviderClass = CsvDataProvider.class)
    public void testValidLogin(String username, String password) {
        System.out.println("Логин: " + username + ", пароль: " + password);
    }
}
