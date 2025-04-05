package com.breaktomake.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class TestListener implements ITestListener {

    private static final Logger logger = Logger.getLogger(TestListener.class.getName());

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("🟢 START TEST: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("✅ PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.warning("🔴 FAILED: " + result.getName());
        WebDriver driver = ((BaseTest) result.getInstance()).driver;
        if (driver != null) {
            saveScreenshot(driver);
        }

        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        ProjectSetup.appendToErrorLog("[" + timestamp + "] Ошибка в тесте: " + result.getName());
    }

    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
