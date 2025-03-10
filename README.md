# BreakToMake

## Описание

**BreakToMake** — это дипломный проект, цель которого — автоматизация тестирования веб-приложений с использованием CI/CD, где мы тестируем функциональность сайта, включая позитивные и негативные сценарии для UI и API, с акцентом на интеграцию TestNG и Selenium для UI тестирования и RestAssured для API тестов.


В проекте рассматриваются различные аспекты тестирования, включая:

- Сравнение **Manual** и **Automation** тестирования.
- Покрытие негативных сценариев **UI** и **API** тестами.
- Основы производительного тестирования с использованием **Postman** или **Python**.
- **End-to-end** тестирование с интеграцией **UI** и **API**.


## Стек технологий

- **Языки**: Java, Python
- **Инструменты**: Git, GitHub Actions, Postman, Selenium, TestNG, Docker
- **IDE**: IntelliJ IDEA, PyCharm


## Запуск проекта

## Клонируйте репозиторий:
  git clone https://github.com/dema28/BreakToMake.git

## Перейдите в директорию проекта:
	cd BreakToMake

## Настройте окружение:

	Установите зависимости:
	Для Java:
	mvn install

	Для Python:
	pip install -r requirements.txt

## Запустите тесты:

	Для Java (TestNG):
	mvn test

	Для Python:
	pytest

## Для CI/CD запустится автоматически при каждом push через GitHub Actions.

## CI/CD
	В проекте используется GitHub Actions для автоматического тестирования. 
	Каждый push или pull request запускает следующие действия:

## Проверка кода с использованием линтеров.
	Запуск тестов (JUnit, TestNG, Pytest).
	Развертывание на тестовом сервере (если необходимо).

## Тестирование
    В проекте есть два типа тестирования:
	UI тесты с использованием Selenium.
	API тесты с использованием Postman и Python.

## Для добавления новых тестов создавайте соответствующие классы в папке tests.

## Структура репозитория
    

├── `manual_testing/` — Документы по прохождению мануальных тестов  
├── `src/` — Исходный код для тестов и вспомогательных классов (например, классы для UI тестов, API тестов)  
├── `tests/` — Тесты и сценарии (UI, API, интеграционные тесты)  
│   ├── `ui_tests/` — Тесты для UI с использованием Selenium  
│   └── `api_tests/` — Тесты для API с использованием RestAssured и Python  
├── `ci_cd/` — Конфигурации для CI/CD (GitHub Actions, настройки для автоматического тестирования)  
│   └── `.github/` — Конфигурации для GitHub Actions  
├── `logs/` — Логи и отчеты с тестирований  
├── `pom.xml` — Зависимости для Java (для установки через `mvn`)  
├── `requirements.txt` — Зависимости для Python (для установки через `pip`)  
└── `README.md` — Этот файл


## Как внести вклад
	Форкните репозиторий.
	Создайте новую ветку для вашего изменения.
	Осуществите изменения и протестируйте их.
	Создайте pull request с подробным описанием изменений.
    Создайте Pull Request с подробным описанием изменений и ссылками на созданные issues.

## Лицензия
	Этот проект лицензирован под MIT License - см. файл [LICENSE](LICENSE) для подробностей.

## Контакты
	Если у вас есть вопросы, обращайтесь по email: dema28ster@gmail.com