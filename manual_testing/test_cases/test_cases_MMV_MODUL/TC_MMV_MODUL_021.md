## TC_MMV_MODUL_021 — Отображение страницы ошибки (404) при переходе по несуществующему URL

### Description / Описание
    Веб-приложение доступно пользователю

### Preconditions / Предусловия
    Пользователь имеет доступ к веб-приложению

### Test Steps / Шаги тестирования
    1. Открыть браузер и ввести в адресной строке несуществующий URL (https://not.modultest1.framer.website)
    2. Нажать Enter для перехода по указанному URL

### Expected Result / Ожидаемый результат
    1. Браузер открыт, строка принимает введенные данные
    2. Отображается страница ошибки 404 с сообщением о том, что запрошенная страница не найдена

### Actual Result / Фактический результат
    1. Браузер открыт, строка принимает введенные данные
    2. Отображается страница ошибки 404 с сообщением о том, что запрошенная страница не найдена

### Severity / Серьезность
    Medium

### Priority / Приоритет
    Medium

### Version / Версия
    oogle Chrome: version 134.0.6998.166 (Official Build) (64-bit)

### Test
    Manual/Automation

### PYTHON: [Check that non-existent page returns 404 status](https://github.com/dema28/CrashProof/blob/main/tests/test_not_found_page.py)