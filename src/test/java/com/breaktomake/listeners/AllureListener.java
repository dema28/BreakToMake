package com.breaktomake.listeners;

import com.breaktomake.utils.DriverFactory;
import com.breaktomake.utils.LoggerUtil;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();
        String testName = result.getMethod().getMethodName();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        String logFile = "logs/test_logs/FAILED_" + testName + "_" + timestamp + ".log";

        String message = "[FAILED] Test: " + testName + "\n"
                + "Time: " + timestamp + "\n"
                + "Exception: " + result.getThrowable();

        LoggerUtil.error("❌ Тест упал: " + testName, result.getThrowable());

        try {
            Files.createDirectories(Paths.get("logs/test_logs"));
            Files.write(Paths.get(logFile), message.getBytes(), StandardOpenOption.CREATE);
            attachLog("Failure Log - " + testName, message);
            LoggerUtil.info("📄 Сохранён лог падения: " + logFile);
        } catch (IOException e) {
            LoggerUtil.error("❌ Ошибка записи лога падения в файл", e);
        }

        if (driver != null) {
            LoggerUtil.info("📸 Снимаем скриншот (Allure)");
            saveScreenshot(driver);
        } else {
            LoggerUtil.warn("⚠️ WebDriver недоступен — скриншот не снят");
        }
    }

    @Attachment(value = "Screenshot on Failure", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{logName}", type = "text/plain")
    public String attachLog(String logName, String content) {
        return content;
    }
}
