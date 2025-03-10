package com.breaktomake.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Test Allure Integration")
public class AllureTestExample {

    @Test
    @Feature("Basic Test Feature")
    @Description("This is a simple test to check allure integration.")
    @TmsLink("http://example.com/tmslink")
    public void sampleTest() {
        Assert.assertTrue(true, "The condition is true.");
    }
}
