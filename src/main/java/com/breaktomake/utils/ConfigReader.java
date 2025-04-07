package com.breaktomake.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties props = new Properties();

    static {
        String env = System.getProperty("env", "local"); // по умолчанию "local"
        String fileName = env + ".properties"; // например: "ci.properties" или "local.properties"

        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                throw new RuntimeException("❌ Файл конфигурации " + fileName + " не найден в classpath");
            }
            props.load(input);
            System.out.println("✅ Загружен конфиг: " + fileName);
        } catch (IOException e) {
            throw new RuntimeException("❌ Ошибка при загрузке " + fileName, e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
