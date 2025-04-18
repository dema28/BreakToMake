## TC_MMV_MODUL_022 — Подсчёт изображений в каждом альбоме галереи

### Description / Описание
    -

### Preconditions / Предусловия
    Пользователь находится на домашней странице https://modultest1.framer.website

### Test Steps / Шаги тестирования
    1. Переходим на вкладку Galerie
    2. Переходим в альбом Doprava
    3. Подсчитываем количество изображений
    4. Возвращаемся на предыдущею страницу и выбираем Montáž
    5. Подсчитываем количество изображений

### Expected Result / Ожидаемый результат
    1. Вкладка Galerie отобразилось
    2. Переход в Doprava осуществлен
    3. Количество подсчитано
    4. Возврат возможен выбран Montáž
    5. Количество изображений подсчитано

### Actual Result / Фактический результат
    1. Вкладка Galerie отобразилось
    2. Переход в Doprava выполнен
    3. Количество подсчитано
    4. Возврат выполнен выбран Montáž
    5. Количество изображений посчитано

### Severity / Серьезность
    Medium

### Priority / Приоритет
    Medium

### Version / Версия
    Google Chrome version 134.0.6998.166 (Official Build) (64-bit)

### Test
    Automation

### PYTHON: [Image count in each gallery album](https://github.com/dema28/CrashProof/blob/main/tests/test_gallery_albums.py)