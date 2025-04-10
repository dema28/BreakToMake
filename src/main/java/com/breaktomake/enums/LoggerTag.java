package com.breaktomake.utils;

public enum LoggerTag {
    TEST("[Test]"),
    DRIVER("[Driver]"),
    ENV("[Env]"),
    PAGE("[Page]"),
    UTILS("[Utils]"),
    LISTENER("[Listener]"),
    CI("[CI]"),
    ALLURE("[Allure]");

    private final String prefix;

    LoggerTag(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
