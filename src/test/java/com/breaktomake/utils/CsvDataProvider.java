package com.breaktomake.utils;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvDataProvider {

    public static Object[][] readCsv(String filePath) throws Exception {
        List<Object[]> data = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        boolean skipHeader = true;

        while ((line = reader.readLine()) != null) {
            if (skipHeader) {
                skipHeader = false;
                continue;
            }
            data.add(line.split(","));
        }

        reader.close();
        return data.toArray(new Object[0][0]);
    }

    @DataProvider(name = "validLoginData")
    public static Object[][] getValidLoginData() throws Exception {
        return readCsv("test_data/login/valid_users.csv");
    }

    @DataProvider(name = "invalidLoginData")
    public static Object[][] getInvalidLoginData() throws Exception {
        return readCsv("test_data/login/invalid_users.csv");
    }
}
