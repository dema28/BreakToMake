
## BUG_MMSRO_002 | Низкая производительность анимаций

### Описание проблемы  
При наведении курсора на элементы в разделе "Realizace" наблюдается подтормаживание и неполный эффект переворота.

---

### Приоритет  
**Уровень:** Medium  
> Влияет на пользовательский интерфейс и визуальное восприятие, снижая плавность взаимодействия.

---

### Среда

| Параметр             | Значение                                                                                      |
|----------------------|-----------------------------------------------------------------------------------------------|
| Устройство           | PC                                                                                            |
| Операционная система | Windows 11 Pro                                                                                |
| Браузеры             | Chrome 134.0.6998.166 (64-bit), Firefox 136.0.2 (64-bit), Edge 134.0.3124.85 (64-bit)         |
| Версия системы       | 64-bit                                                                                        |

---

### Шаги воспроизведения

1. Открыть сайт: https://modultest1.framer.website/  
2. Пролистать страницу до раздела "Realizace"  
3. Наводить курсор на карточки и перемещаться между ними

---

### Ожидаемое поведение  
Анимации должны проигрываться плавно и без рывков, обеспечивая полный эффект переворота.

---

### Фактическое поведение  
Анимации тормозят, особенно во время скролла, эффект переворота воспроизводится частично.

---

### Вложения  
- [Видео с воспроизведением бага](https://drive.google.com/file/d/1z4VJtCQh6RSeBq3kWewfSFkCbUOVQEH0/view?usp=sharing)

---

### Возможное решение  
Оптимизировать стили анимации (`transform`, `will-change`), уменьшить количество активных DOM-элементов.

---

### Дополнительная информация  
Проблема стабильно воспроизводится в указанной конфигурации и браузерах.
