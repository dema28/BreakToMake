package com.breaktomake.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {
    public static final Logger log = LogManager.getLogger();

    private LoggerUtil() {
        // Utility class
    }

    // INFO
    public static void info(String message) {
        log.info(message);
    }

    public static void info(com.breaktomake.utils.LoggerTag tag, String message) {
        log.info(tag.getPrefix() + " " + message);
    }

    // DEBUG
    public static void debug(String message) {
        log.debug(message);
    }

    public static void debug(com.breaktomake.utils.LoggerTag tag, String message) {
        log.debug(tag.getPrefix() + " " + message);
    }

    // WARN
    public static void warn(String message) {
        log.warn(message);
    }

    public static void warn(com.breaktomake.utils.LoggerTag tag, String message) {
        log.warn(tag.getPrefix() + " " + message);
    }

    // ERROR
    public static void error(String message, Throwable t) {
        log.error(message, t);
    }

    public static void error(com.breaktomake.utils.LoggerTag tag, String message) {
        log.error(tag.getPrefix() + " " + message);
    }

    public static void error(com.breaktomake.utils.LoggerTag tag, String message, Throwable t) {
        log.error(tag.getPrefix() + " " + message, t);
    }

    // START/END
    public static void logStart(String testName) {
        log.info(com.breaktomake.utils.LoggerTag.TEST.getPrefix() + " ==========[ 🚀 START TEST: " + testName + " ]==========");
    }

    public static void logEnd(String testName) {
        log.info(com.breaktomake.utils.LoggerTag.TEST.getPrefix() + " ==========[ 🧪 END TEST: " + testName + " ]==========");
    }

    public static void logError(String message, Throwable t) {
        log.error(com.breaktomake.utils.LoggerTag.TEST.getPrefix() + " ===== ERROR: " + message + " =====", t);
    }
}
