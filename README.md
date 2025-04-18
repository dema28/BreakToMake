
# BreakToMake — Проект по автоматизированному тестированию

![Java](https://img.shields.io/badge/java-17-blue)
![TestNG](https://img.shields.io/badge/TestNG-enabled-brightgreen)
![Allure](https://img.shields.io/badge/Allure-integrated-orange)
![CI](https://github.com/dema28/BreakToMake/actions/workflows/CI.yml/badge.svg)
![License](https://img.shields.io/badge/license-MIT-green)

---

## Описание проекта

**BreakToMake** — дипломный проект, сочетающий **ручное** и **автоматизированное тестирование** веб-приложения сайта модульных домов. В рамках проекта реализованы:

- Сравнение подходов Manual и Automation
- Покрытие позитивных и негативных сценариев (UI и API)
- End-to-End тестирование (UI + API)
- Тестирование производительности (Postman + Newman)
- Отчётность через Allure
- Автоматизация CI/CD с помощью GitHub Actions

---

## Технологии

| Категория     | Инструменты                                |
|---------------|---------------------------------------------|
| Язык          | Java 17                                     |
| UI тесты      | Selenium + TestNG                           |
| API тесты     | Postman + Newman                            |
| Отчёты        | Allure Reports                              |
| CI/CD         | GitHub Actions                              |
| Документация  | Markdown + Excel + PDF                      |
| IDE           | IntelliJ IDEA                               |
| Контроль версий| Git + GitHub                               |

---

## Структура проекта

```
BreakToMake/
├── .github/workflows/              # CI через GitHub Actions
├── manual_testing/
│   ├── bug_reports/                # Баг-репорты
│   ├── test_cases/                 # Тест-кейсы проекта MMV_MODUL
│   └── test_runs/                 # Финальные отчёты о тест-прогонах
├── reports/
│   ├── allure_reports/             # Отчёты Allure (со скриншотами)
│   └── postman_reports/            # Отчёты Postman/Newman
├── scripts/                        # Скрипты для запуска тестов
├── src/
│   ├── main/                       # Page Object + конфиги + утилиты
│   ├── postman/                    # Коллекции и окружения Postman
│   └── test/                       # UI тесты на Java
├── test_data/                      # CSV/JSON данные для тестов
├── logs/                           # Логи тестов и CI
├── README.md                       # Основной README
├── README_AUTOTESTS.md             # Инструкция по Java + Allure
├── README_RUN_POSTMAN_TESTS.md     # Инструкция по запуску Postman
├── Allure_Errors_Solutions.md      # Частые ошибки и решения для Allure
├── LICENSE.txt                     # Лицензия MIT
└── pom.xml                         # Конфигурация Maven
```

---

## Как запустить тесты

### UI тесты (Java + TestNG)
```bash
mvn clean test
allure generate target/allure-results --clean -o target/allure-report
allure open target/allure-report
```
Подробнее см. [README_AUTOTESTS.md](README_AUTOTESTS.md)

### API тесты (Postman + Newman)
```bash
bash scripts/run_postman_tests.sh
```
Подробнее см. [README_RUN_POSTMAN_TESTS.md](README_RUN_POSTMAN_TESTS.md)

---

## Полезные ссылки

| Раздел               | Ссылка                                                        |
|----------------------|---------------------------------------------------------------|
| Тест-кейсы          | [test_cases_MMV_MODUL](manual_testing/test_cases/test_cases_MMV_MODUL/) |
| Баг-репорты         | [bug_reports](manual_testing/bug_reports/)                   |
| Ошибки Allure      | [Allure_Errors_Solutions.md](Allure_Errors_Solutions.md)     |
| Финальный тест-прогон| [TestRun_Report.md](manual_testing/test_runs/TestRun_Report.md) |
| UI автотесты      | [README_AUTOTESTS.md](README_AUTOTESTS.md)                   |
| Инструкция Postman | [README_RUN_POSTMAN_TESTS.md](README_RUN_POSTMAN_TESTS.md)   |

---

## Лицензия

Проект распространяется под лицензией **MIT**  
Автор: **Denis Novicov** | QA Manual & Automation Engineer 🇨🇿  
См. [LICENSE.txt](LICENSE.txt) для подробностей.
