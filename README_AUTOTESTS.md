# Инструкции по запуску автотестов с Allure (Java + TestNG + Maven)

## Условия

- JDK 17 установлен и доступен в `JAVA_HOME`
- Maven установлен
- Allure CLI установлен (`allure --version` должен работать)
- Все зависимости подтянуты (`mvn install`)

---

## Для Windows (CMD / PowerShell)

| №  | Действие                                        | Команда                                                                 |
|----|-------------------------------------------------|-------------------------------------------------------------------------|
| 1  | Удалить старые сборки и результаты              | `mvn clean`                                                             |
| 2  | Запустить тесты с генерацией Allure-результатов | `mvn test`                                                              |
| 3  | Сгенерировать Allure-отчёт                      | `allure generate allure-results --clean -o allure-report`               |
| 4  | Открыть Allure-отчёт в браузере                 | `allure open allure-report`                                            |
| 5  | Запустить один конкретный тест (пример)         | `mvn -Dtest=CatalogPageTest#testCatalogHouseCardsAreVisibleAndCounted test` |

---

## Для Linux / macOS / CI

| №  | Действие                                        | Команда                                                                 |
|----|-------------------------------------------------|-------------------------------------------------------------------------|
| 1  | Удалить старые сборки и результаты              | `mvn clean`                                                             |
| 2  | Запустить тесты с генерацией Allure-результатов | `mvn test`                                                              |
| 3  | Сгенерировать Allure-отчёт                      | `allure generate allure-results --clean -o allure-report`               |
| 4  | Открыть Allure-отчёт в браузере                 | `allure open allure-report`                                            |
| 5  | Запустить один конкретный тест (пример)         | `mvn -Dtest=CatalogPageTest#testCatalogHouseCardsAreVisibleAndCounted test` |

---

## Важно

- Папки `allure-results/` и `allure-report/` не должны попадать в репозиторий (они игнорируются через `.gitignore`).
- Конфигурационный файл `local.properties` должен быть добавлен **локально** и также не добавляться в Git.
