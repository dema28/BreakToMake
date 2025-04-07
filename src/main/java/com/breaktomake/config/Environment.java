package com.breaktomake.config;

import com.breaktomake.utils.ConfigReader;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    public static String getWindowSize() {
        return ConfigReader.get("window.size");
    }

    public static List<String> getChromeOptions() {
        String options = ConfigReader.get("local.chrome_options");
        if (options != null && !options.trim().isEmpty()) {
            return Arrays.stream(options.split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .toList();
        }
        return Collections.emptyList();
    }

    public static boolean isCloseBrowserOnError() {
        return Boolean.parseBoolean(ConfigReader.get("local.closeBrowserIfError"));
    }

    public static final String BASE_URL = "https://modultest1.framer.website";
    public static final String CONTACT_PAGE = BASE_URL + "/kontakty";


}
