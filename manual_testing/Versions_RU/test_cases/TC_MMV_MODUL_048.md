## TC_MMV_MODUL_048 — Проверка отправки формы с валидными данными из CSV

### Description / Описание
    Форма отправляется с валидными данными из CSV-файла (dataProvider).
    Отправка данных из файлов и групп пользователей

### Preconditions / Предусловия
    Пользователь находится на домашней странице https://modultest1.framer.website

### Test Steps / Шаги тестирования
    1. Перейти в раздел Kontakty
    2. Заполнить форму данными из CSV
    3. Нажать кнопку отправки
    4. Проверить отображение сообщения об успешной отправке

### Expected Result / Ожидаемый результат
    Форма успешно отправляется и появляется сообщение 'Děkujeme'

### Actual Result / Фактический результат
    Форма успешно отправляется и появляется сообщение 'Děkujeme'

### Severity / Серьезность
    Medium

### Priority / Приоритет
    Medium

### Version / Версия
    Google Chrome: version 134.0.6998.166 (Official Build) (64-bit)

### Test
    Automation

### JAVA: [TC_AUTO_J_003](https://github.com/dema28/BreakToMake/blob/main/src/test/java/com/breaktomake/tests/ProviderTest.java)