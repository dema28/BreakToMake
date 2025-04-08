package com.breaktomake.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {
    public static final Logger log = LogManager.getLogger();

    private LoggerUtil() {
        // Utility class
    }

    public static void info(String message) {
        log.info(message);
    }

    public static void error(String message, Throwable t) {
        log.error(message, t);
    }

    public static void warn(String message) {
        log.warn(message);
    }

    public static void debug(String message) {
        log.debug(message);
    }

    public static void logStart(String testName) {
        log.info("===== START TEST: " + testName + " =====");
    }

    public static void logEnd(String testName) {
        log.info("===== END TEST: " + testName + " =====");
    }

    public static void logError(String message, Throwable t) {
        log.error("===== ERROR: " + message + " =====", t);
    }
}
