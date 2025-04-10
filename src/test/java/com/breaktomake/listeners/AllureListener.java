package com.breaktomake.listeners;

import com.breaktomake.utils.DriverFactory;
import com.breaktomake.utils.LoggerTag;
import com.breaktomake.utils.LoggerUtil;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();
        String testName = result.getMethod().getMethodName();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        Path logPath = Paths.get("logs/test_logs", "FAILED_" + testName + "_" + timestamp + ".log");

        String message = "==========[ FAILED TEST ]==========\n"
                + "Test: " + testName + "\n"
                + "Time: " + timestamp + "\n"
                + "Exception: " + result.getThrowable() + "\n"
                + "===================================\n";

        LoggerUtil.error(LoggerTag.LISTENER, "❌ Тест упал: " + testName, result.getThrowable());

        try {
            Files.createDirectories(logPath.getParent());
            Files.write(logPath, message.getBytes(), StandardOpenOption.CREATE);
            attachLog("Failure Log - " + testName, message);
            LoggerUtil.info(LoggerTag.LISTENER, "📄 Сохранён лог падения: " + logPath);
        } catch (IOException e) {
            LoggerUtil.error(LoggerTag.LISTENER, "❌ Ошибка записи лога падения в файл", e);
        }

        if (driver != null) {
            LoggerUtil.info(LoggerTag.LISTENER, "📸 Снимаем скриншот (Allure)");
            saveScreenshot(driver);
        } else {
            LoggerUtil.warn(LoggerTag.LISTENER, "⚠️ WebDriver недоступен — скриншот не снят");
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
