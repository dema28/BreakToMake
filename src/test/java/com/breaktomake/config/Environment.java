package com.breaktomake.config;

import com.breaktomake.utils.ConfigReader;

public class Environment {

    public static boolean isHeadless() {
        return Boolean.parseBoolean(ConfigReader.get("headless"));
    }

    public static String getBrowser() {
        return ConfigReader.get("browser");
    }

    public static int getTimeout() {
        return Integer.parseInt(ConfigReader.get("timeout"));
    }

    public static boolean isScreenshotOnFail() {
        return Boolean.parseBoolean(ConfigReader.get("screenshot.on.fail"));
    }

    public static String getChromeOptions() {
        return ConfigReader.get("local.chrome_options");
    }

    public static boolean isCloseBrowserOnError() {
        return Boolean.parseBoolean(ConfigReader.get("local.closeBrowserIfError"));
    }
}
