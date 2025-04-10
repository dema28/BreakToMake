package com.breaktomake.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

    public static void captureScreenshot(WebDriver driver, String name) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String screenshotPath = "reports/allure_reports/screenshots/" + name + "_" + timestamp + ".png";
        File dest = new File(screenshotPath);

        try {
            FileUtils.copyFile(src, dest);
            LoggerUtil.info(com.breaktomake.utils.LoggerTag.UTILS, "📸 Скриншот сохранён: " + screenshotPath);
        } catch (IOException e) {
            LoggerUtil.error(com.breaktomake.utils.LoggerTag.UTILS, "❌ Ошибка при сохранении скриншота: " + e.getMessage(), e);
        }
    }
}
