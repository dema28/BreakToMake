## TC_MMV_MODUL_011 — Кликабельность меню в мобильной версии

### Description / Описание
    -

### Preconditions / Предусловия
    Пользователь находится на https://modultest1.framer.website
    Открыт браузер в мобильной версии

### Test Steps / Шаги тестирования
    1. Кликнуть на заначек меню в правом верхнем углу
    2. Наводим курсор на любое меню и кликаем
    3. Повторно кликаем на меню

### Expected Result / Ожидаемый результат
    1. Отобразилось выпадающие меню
    2. Перешли на выбранную вкладку
    3. Выпадающий список отобразился, нет визуального отображения в которой вкладке 
    находится пользователь

### Actual Result / Фактический результат
    1. Отобразилось выпадающие меню
    2. Перешли на выбранную вкладку
    3. Выпадающий список отобразился, нет визуального отображения в которой вкладке 
    находится пользователь

### Severity / Серьезность
    Medium

### Priority / Приоритет
    Medium

### Version / Версия
    Google Chrome Mobile

### Test
    Manual/Automation

### PYTHON: [Menu items are clickable and lead to correct sections (mobile)](https://github.com/dema28/CrashProof/blob/main/tests/test_main_page_mobile.py)
### [BUG_MMSRO_004_RU – Отсутствие обратной связи на кнопках вкладок](../bug_reports/BUG_MMSRO_004_RU.md)
