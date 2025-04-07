# Автотесты: запуск Postman коллекций с помощью Newman

## Требования
- Node.js и `npm` установлены
- Установлен `newman`: `npm install -g newman`
- Файлы коллекций находятся в `src/postman/collections/`
- Файлы окружений находятся в `src/postman/environments/`

---

## Структура проекта (фрагмент)
```
.
├── scripts/
│   ├── run_postman_tests.bat     # Для Windows CMD
│   ├── run_postman_tests.sh      # Для Linux/macOS/CI
│   └── run_postman_tests.ps1     # Для PowerShell
├── src/
│   └── postman/
│       ├── collections/
│       └── environments/
├── reports/
│   └── postman_reports/
```

---

## Запуск Postman коллекций

### Windows CMD:
```cmd
scripts\run_postman_tests.bat
```

### PowerShell:
```powershell
./scripts/run_postman_tests.ps1
```

### Linux / macOS / GitHub Actions:
```bash
 bash scripts/run_postman_tests.sh
```

---

## Отчёты
JSON-отчёты сохраняются в папку:
```
reports/postman_reports/
```

---

## Примечание
Скрипты автоматически:
- проверяют наличие `newman`
- проверяют наличие нужных файлов
- создают директорию для отчётов, если её нет

Если хочешь запускать другие коллекции — просто поменяй путь в переменной `COLLECTION_PATH` внутри скрипта.
