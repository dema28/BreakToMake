## BUG_MMSRO_007 | Фото находится вне своего контейнера

### Описание проблемы

На главной странице сайта, в блоке "O nas", фотография выходит за границы своего контейнера и располагается вне заданного макета.

---

### Приоритет

**Уровень:** Medium

> Влияет на визуальное восприятие и нарушает структуру макета страницы.

---

### Среда

| Параметр             | Значение                                                                              |
| -------------------- | ------------------------------------------------------------------------------------- |
| Устройство           | PC                                                                                    |
| Операционная система | Windows 11 Pro                                                                        |
| Браузеры             | Chrome 134.0.6998.166 (64-bit), Firefox 136.0.2 (64-bit), Edge 134.0.3124.85 (64-bit) |
| Версия системы       | 64-bit                                                                                |

---

### Шаги для воспроизведения

1. Перейти на сайт https://modultest1.framer.website/
2. Прокрутить страницу до блока "O nas"

---

### Ожидаемое поведение

Изображение располагается строго внутри контейнера и не выходит за его пределы.

---

### Фактическое поведение

Изображение выведено за границы контейнера и нарушает визуальную композицию.

---

### Вложения

- [Скриншот проблемы](https://drive.google.com/file/d/1AUVzm6nW-rPyXGoFHHu3CcjKFGVJ56vl/view?usp=sharing)

---

### Предлагаемое решение

Откорректировать HTML/CSS верстку, чтобы фото находилось внутри родительского блока.

---

### Дополнительная информация

Проблема стабильно наблюдается во всех протестированных браузерах.
