package com.breaktomake.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollUtil {

    @Step("Прокрутка к элементу: {element}")
    public static void scrollToElement(WebDriver driver, WebElement element) {
        try {
            LoggerUtil.debug(com.breaktomake.utils.LoggerTag.UTILS, "📦 Прокрутка к элементу: " + element);
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        } catch (Exception e) {
            LoggerUtil.warn(com.breaktomake.utils.LoggerTag.UTILS, "⚠️ Ошибка при прокрутке: " + e.getMessage());
        }
    }
}

