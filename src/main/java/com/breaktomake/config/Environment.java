package com.breaktomake.config;

import com.breaktomake.utils.ConfigReader;
import com.breaktomake.utils.LoggerTag;
import com.breaktomake.utils.LoggerUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Environment {

    public static final String BASE_URL = "https://modultest1.framer.website";
    public static final String KATALOG_PAGE = BASE_URL + "/katalog-dom%C5%AF";
    public static final String PROJEKT_PAGE = BASE_URL + "/projekty";
    public static final String O_NAS_PAGE = BASE_URL + "/o-n%C3%A1s";
    public static final String REALIZACE_PAGE = BASE_URL + "/rozsah-realizace";
    public static final String KARIERA_PAGE = BASE_URL + "/kari%C3%A9ra";
    public static final String GALERIE_PAGE = BASE_URL + "/albums";
    public static final String KONTAKTY_PAGE = BASE_URL + "/kontakty";


    public static boolean isHeadless() {
        boolean headless = Boolean.parseBoolean(ConfigReader.get("headless"));
        LoggerUtil.debug(LoggerTag.ENV, "🔒 Headless: " + headless);
        return headless;
    }

    public static String getBrowser() {
        String browser = ConfigReader.get("browser");
        LoggerUtil.debug(LoggerTag.ENV, "🌐 Браузер: " + browser);
        return browser;
    }

    public static int getTimeout() {
        String timeoutStr = ConfigReader.get("timeout");
        try {
            int timeout = Integer.parseInt(timeoutStr);
            LoggerUtil.debug(LoggerTag.ENV, "⏱ Таймаут: " + timeout + " сек.");
            return timeout;
        } catch (NumberFormatException e) {
            LoggerUtil.warn(LoggerTag.ENV, "⚠️ Некорректный таймаут, используется по умолчанию: 10");
            return 10;
        }
    }

    public static boolean isScreenshotOnFail() {
        boolean flag = Boolean.parseBoolean(ConfigReader.get("screenshot.on.fail"));
        LoggerUtil.debug(LoggerTag.ENV, "📸 Скрин при падении: " + flag);
        return flag;
    }

    public static String getWindowSize() {
        String size = ConfigReader.get("window.size");
        LoggerUtil.debug(LoggerTag.ENV, "🪟 Размер окна: " + size);
        return size;
    }

    public static List<String> getChromeOptions() {
        String options = ConfigReader.get("local.chrome_options");
        if (options != null && !options.trim().isEmpty()) {
            List<String> list = Arrays.stream(options.split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .toList();
            LoggerUtil.debug(LoggerTag.ENV, "⚙️ Chrome аргументы: " + list);
            return list;
        }
        LoggerUtil.debug(LoggerTag.ENV, "⚙️ Chrome аргументы не заданы");
        return Collections.emptyList();
    }

    public static boolean isCloseBrowserOnError() {
        boolean close = Boolean.parseBoolean(ConfigReader.get("local.closeBrowserIfError"));
        LoggerUtil.debug(LoggerTag.ENV, "🛑 Закрытие браузера при ошибке: " + close);
        return close;
    }
}
