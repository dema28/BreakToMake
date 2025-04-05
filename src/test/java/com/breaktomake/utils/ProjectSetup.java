package com.breaktomake.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Logger;
import java.util.Comparator;

public class ProjectSetup {

    private static final Logger logger = Logger.getLogger(ProjectSetup.class.getName());
    private static final String[] folders = {"allure-results", "allure-report"};
    private static final String ERROR_LOG = "error_log.txt";

    public static void cleanProjectFolders() {
        for (String folderName : folders) {
            Path folder = Paths.get(folderName);
            try {
                if (Files.exists(folder)) {
                    Files.walk(folder)
                            .sorted(Comparator.reverseOrder())
                            .map(Path::toFile)
                            .forEach(File::delete);
                    logger.info("[INFO] Очищена папка: " + folderName);
                }
                Files.createDirectories(folder);
            } catch (IOException e) {
                logger.warning("Не удалось очистить: " + folderName + ". Ошибка: " + e.getMessage());
            }
        }

        File errorLog = new File(ERROR_LOG);
        if (errorLog.exists()) {
            if (errorLog.delete()) {
                logger.info("[INFO] Удалён старый error_log.txt");
            } else {
                logger.warning("[WARNING] Не удалось удалить error_log.txt");
            }
        }
    }

    public static void appendToErrorLog(String message) {
        try (FileWriter writer = new FileWriter(ERROR_LOG, true)) {
            writer.write(message + "\n");
        } catch (IOException e) {
            logger.warning("Ошибка при записи в error_log.txt: " + e.getMessage());
        }
    }
}
