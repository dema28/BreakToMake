# BreakToMake

## Описание

**BreakToMake** — это дипломный проект, целью которого является автоматизация тестирования веб-приложений с использованием CI/CD.

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

	├── `docs/` — Документация по проекту  
	├── `src/` — Исходный код  
	├── `tests/` — Тесты и сценарии  
	├── `ci_cd/` — Конфигурации для CI/CD (GitHub Actions)  
	├── `logs/` — Логи и отчёты  
	└── `README.md` — Этот файл

## Как внести вклад
	Форкните репозиторий.
	Создайте новую ветку для вашего изменения.
	Осуществите изменения и протестируйте их.
	Создайте pull request с подробным описанием изменений.

## Лицензия
	Этот проект лицензирован под MIT License - см. файл [LICENSE](LICENSE) для подробностей.

## Контакты
	Если у вас есть вопросы, обращайтесь по email: dema28ster@gmail.com