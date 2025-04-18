## TC_MMV_MODUL_024 — Проверка UI кастомной страницы 404

### Description / Описание
    -

### Preconditions / Предусловия
    Пользователь находится на домашней странице https://modultest1.framer.website/

### Test Steps / Шаги тестирования
    1. Пользователь в поисковой строке дописывает не существующую страницу сайта (/kotalog)
    2. Нажать ENTER

### Expected Result / Ожидаемый результат
    1. Строка принимает введенные данные
    2. Отобразилась страница кастомной ошибки 404

### Actual Result / Фактический результат
    1. Строка принимает введенные данные
    2. Отобразилась страница кастомной ошибки 404

### Severity / Серьезность
    Medium

### Priority / Приоритет
    Medium

### Version / Версия
    Google Chrome: version 134.0.6998.166 (Official Build) (64-bit)

### Test
    Automation

### PYTHON: [UI check for custom 404 page](https://github.com/dema28/CrashProof/blob/main/tests/test_not_found_page.py)