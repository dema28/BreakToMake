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
        Object testClass = result.getInstance();
        if (testClass instanceof BaseTest) {
            WebDriver driver = ((BaseTest) testClass).driver;
            if (driver != null) {
                saveScreenshot(driver);
            }
        }

        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        ProjectSetup.appendToErrorLog("[" + timestamp + "] Ошибка в тесте: " + result.getName());
    }

    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warning("⚠️ SKIPPED: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("=== 🔷 START TEST SUITE: " + context.getName() + " ===");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("=== 🔶 END TEST SUITE: " + context.getName() + " ===");
    }
}
