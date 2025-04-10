package com.breaktomake.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties props = new Properties();

    static {
        String env = System.getProperty("env", "local");
        String fileName = env + ".properties";

        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                LoggerUtil.error(com.breaktomake.utils.LoggerTag.ENV, "❌ Файл конфигурации не найден: " + fileName, null);
                throw new RuntimeException("Файл конфигурации " + fileName + " не найден в classpath");
            }
            props.load(input);
            LoggerUtil.info(com.breaktomake.utils.LoggerTag.ENV, "✅ Загружен конфиг: " + fileName);
        } catch (IOException e) {
            LoggerUtil.error(com.breaktomake.utils.LoggerTag.ENV, "❌ Ошибка при загрузке конфигурации: " + fileName, e);
            throw new RuntimeException("Ошибка при загрузке " + fileName, e);
        }
    }

    public static String get(String key) {
        String value = props.getProperty(key);
        if (value == null) {
            LoggerUtil.warn(com.breaktomake.utils.LoggerTag.ENV, "⚠️ Ключ не найден в конфиге: " + key);
        }
        return value;
    }
}
