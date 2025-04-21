## Test Case: TC_MMV_MODUL_007 — Загрузка домашней страницы

### Description / Описание
    Проверка корректной загрузки домашней страницы

### Preconditions / Предусловия
    Пользователь находится на главной странице: https://modultest1.framer.website

### Test Steps / Шаги тестирования
    1. Проскролить вниз до "futur"

### Expected Result / Ожидаемый результат
    1. Видны основные элементы: логотип, меню навигации, футер, 
    ключевые изображения и текст.

### Actual Result / Фактический результат
    Видны основные элементы: логотип, меню навигации, футер, 
    ключевые изображения и текст.

### Severity / Серьезность
    Medium

### Priority / Приоритет
    Medium

### Version / Версия
    Firefox Browser: 136.0.2 (64-bit)

### Test
    Manual/Automation
#### JAVA: [MainPageTest.java TC_AUTO_J_004](https://github.com/dema28/BreakToMake/blob/main/src/test/java/com/breaktomake/tests/MainPageTest.java)
#### PYTHON: [test_main_page.py TC_AUTO_PY_005](https://github.com/dema28/CrashProof/blob/main/tests/test_main_page.py)