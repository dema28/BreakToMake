## TC_MMV_MODUL_051 — Переход по ссылке Facebook в футере

### Description / Описание
    Проверка, что ссылка в футере ведёт на правильный Facebook-профиль компании.

### Preconditions / Предусловия
    Открыта главная страница сайта.

### Test Steps / Шаги тестирования
    1. Открыть главную страницу
    2. Кликнуть по иконке Facebook
    3. Переключиться на новую вкладку
    4. Проверить, что URL содержит: facebook.com/people/Modul-Construct/61552282003531/

### Expected Result / Ожидаемый результат
    Переход происходит на Facebook-профиль компании

### Actual Result / Фактический результат
    Переход происходит на Facebook-профиль компании

### Severity / Серьезность
    Medium

### Priority / Приоритет
    Medium

### Version / Версия
    Google Chrome: version 134.0.6998.166 (Official Build) (64-bit)

### Test
    Automation

### JAVA: [TC_AUTO_J_008](https://github.com/dema28/BreakToMake/blob/main/src/test/java/com/breaktomake/tests/MainPageTest.java)