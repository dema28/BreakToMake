# Test Run Report — MMV MODUL

---


| TC ID            | Название теста                                                                              | Статус | Баг           | Тест                | Автотест                       |
| ---------------- | ------------------------------------------------------------------------------------------- | ------ | ------------- |---------------------| ------------------------------ |
| TC_MMV_MODUL_001 | Negative Scenario                                                                           | Passed | -             | Automation          | TC_AUTO_PY_001                 |
| TC_MMV_MODUL_002 | Positive Scenario                                                                           | Passed | -             | Automation          | TC_AUTO_PY_002                 |
| TC_MMV_MODUL_003 | Валидация формата email                                                                     | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_004 | Воспроизведение видеоконтента                                                               | Failed | BUG_MMSRO_008 | Manual              |                                |
| TC_MMV_MODUL_005 | Карточки проектов                                                                           | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_006 | Кнопка 'Kontakty'                                                                           | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_007 | Загрузка домашней страницы                                                                  | Passed | -             | Manual / Automation | TC_AUTO_PY_005 / TC_AUTO_J_004 |
| TC_MMV_MODUL_008 | Загрузка каталога модульных домов                                                           | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_009 | Загрузка текстовых данных и изображений модуля                                              | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_010 | Кликабельность изображений в "Galerie"                                                      | Failed | BUG_MMSRO_005 | Manual              |                                |
| TC_MMV_MODUL_011 | Кликабельность меню в мобильной версии                                                      | Failed | BUG_MMSRO_004 | Manual / Automation | TC_AUTO_PY_006                 |
| TC_MMV_MODUL_012 | Корректное заполнение формы обратной связи                                                  | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_013 | Корректность отображения логотипа                                                           | Failed | BUG_MMSRO_001 | Manual              |                                |
| TC_MMV_MODUL_014 | Корректность отображения списков и разделов                                                 | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_015 | Корректность отображения фото на главной странице                                           | Failed | BUG_MMSRO_007 | Manual              |                                |
| TC_MMV_MODUL_016 | Проверка вкладок Меню                                                                       | Passed | -             | Manual / Automation | TC_AUTO_J_005                  |
| TC_MMV_MODUL_017 | Низкая производительность анимации                                                          | Failed | BUG_MMSRO_002 | Manual              |                                |
| TC_MMV_MODUL_018 | Отображение web-страницы на мобильном браузере под Android                                  | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_019 | Отображение web-страницы на мобильном браузере под iOS                                      | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_020 | Отображение главной страницы при разных разрешениях экрана                                  | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_021 | Отображение страницы ошибки (404) при переходе по несуществующему URL                       | Passed | -             | Manual / Automation | TC_AUTO_PY_007                 |
| TC_MMV_MODUL_022 | Подсчёт изображений в каждом альбоме галереи                                                | Passed | -             | Automation          | TC_AUTO_PY_004                 |
| TC_MMV_MODUL_023 | Проверка ввода в форму данных для отправки                                                  | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_024 | Проверка UI кастомной страницы 404                                                          | Passed | -             | Automation          | TC_AUTO_PY_008                 |
| TC_MMV_MODUL_025 | Проверка hover-эффектов                                                                     | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_026 | Проверка «резинового» дизайна – отсутствие наложения элементов при изменении размера окна   | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_027 | Проверка адаптивности                                                                       | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_028 | Проверка ввода специальных символов                                                         | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_029 | Проверка граничных значений поля "Zpráva"                                                   | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_030 | наличие атрибутов alt у изображений                                                         | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_031 | Проверка единообразия шрифтов                                                               | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_032 | Проверка логичности и корректности перехода между полями формы с помощью клавиши Tab        | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_033 | Проверка обязательных полей                                                                 | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_034 | Проверка отображения и функционирования сайта в режиме инкогнито (Firefox Browser: 136.0.2) | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_035 | Проверка отображения сайта в Microsoft Edge Legacy                                          | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_036 | Проверка отступов и выравнивания элементов интерфейса                                       | Failed | BUG_MMSRO_003 | Manual              |                                |
| TC_MMV_MODUL_037 | Проверка поведения сайта при медленном соединении (Slow 3G)                                 | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_038 | Проверка ссылки tel: на номер телефона                                                      | Passed | -             | Automation          | TC_AUTO_PY_003                 |
| TC_MMV_MODUL_039 | Проверка цветовой схемы                                                                     | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_040 | Работа с интерактивными элементами и жестами на мобильном устройстве                        | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_041 | Работа якорных ссылок и скроллинга                                                          | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_043 | Фото в мобильной галерее                                                                    | Failed | BUG_MMSRO_003 | Manual              |                                |
| TC_MMV_MODUL_044 | Функциональность форм и обратной связи на мобильном устройстве                              | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_045 | CZ/CZ                                                                                       | Passed | -             | Manual              |                                |
| TC_MMV_MODUL_046 | Карточка дома — заголовок, характеристики, цены                                             | Passed | -             | Automation          | TC_AUTO_J_001                  |
| TC_MMV_MODUL_047 | Контактная информация на карточке дома                                                      | Passed | -             | Automation          | TC_AUTO_J_002                  |
| TC_MMV_MODUL_048 | Форма обратной связи — позитивный сценарий с CSV                                            | Passed | -             | Automation          | TC_AUTO_J_003                  |
| TC_MMV_MODUL_049 | Подсчтет карточки домов на главной странице                                                 | Passed | -             | Automation          | TC_AUTO_J_006                  |
| TC_MMV_MODUL_050 | Проверка перехода по ссылке Instagram                                                       | Passed | -             | Automation          | TC_AUTO_J_007                  |
| TC_MMV_MODUL_051 | Проверка перехода по ссылке Facebook                                                        | Passed | -             | Automation          | TC_AUTO_J_008                  |

---
