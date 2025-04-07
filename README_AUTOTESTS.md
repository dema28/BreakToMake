# Инструкции по запуску автотестов с Allure (Java + TestNG + Maven)

## Условия

- Установлен **JDK 17** (`JAVA_HOME` настроен)
- **Maven** установлен и доступен в `PATH`
- **Allure CLI** установлен (`allure --version` работает)
- Все зависимости подтянуты (`mvn clean verify` или `mvn dependency:resolve`)

---

## Для Windows / PowerShell

| №  | Действие                                        | Команда                                                                 |
|----|-------------------------------------------------|-------------------------------------------------------------------------|
| 1  | Удалить старые сборки и результаты              | `mvn clean`                                                             |
| 2  | Запустить тесты с генерацией Allure-результатов | `mvn test`                                                              |
| 3  | Сгенерировать Allure-отчёт                      | `allure generate target/allure-results --clean -o target/allure-report` |
| 4  | Открыть Allure-отчёт в браузере                 | `allure open target/allure-report`                                      |
| 5  | Запустить конкретный тест (пример)              | `mvn -Dtest=CatalogPageTest#testCatalogHouseCardsAreVisibleAndCounted test` |

---

## Для Linux / macOS / CI

(дополнительно: `export DISPLAY=:99` — если используется Xvfb вручную)

| №  | Действие                                        | Команда                                                                 |
|----|-------------------------------------------------|-------------------------------------------------------------------------|
| 1  | Удалить старые сборки и результаты              | `mvn clean`                                                             |
| 2  | Запустить тесты                                 | `mvn test`                                                              |
| 3  | Сгенерировать Allure-отчёт                      | `allure generate target/allure-results --clean -o target/allure-report` |
| 4  | Открыть Allure-отчёт                            | `allure open target/allure-report`                                      |
| 5  | Запустить конкретный тест                       | `mvn -Dtest=CatalogPageTest#testCatalogHouseCardsAreVisibleAndCounted test` |

---

## Дополнительно

- **Запуск по группам** (если используется `@Test(groups = "...")`):
  ```bash
  mvn test -Dgroups=smoke
  ```

---

## Git игнор

```gitignore
# Allure
target/allure-results/
target/allure-report/

# IDE
.idea/
*.iml

# Logs
logs/
```

---

✅ Всё готово для локального запуска и CI. При необходимости добавляйте параметры или расширяйте конфигурацию под конкретные окружения.
