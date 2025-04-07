#!/bin/bash

COLLECTION_PATH="src/postman/collections/login_collection.json"
ENV_PATH="src/postman/environments/local_environment.json"
REPORT_PATH="reports/postman_reports/report.json"

# Проверка установки newman
if ! command -v newman &> /dev/null; then
  echo "❌ Newman is not installed. Run: npm install -g newman"
  exit 1
fi

# Проверка существования файлов
if [ ! -f "$COLLECTION_PATH" ]; then
  echo "❌ Collection file not found: $COLLECTION_PATH"
  exit 1
fi

if [ ! -f "$ENV_PATH" ]; then
  echo "❌ Environment file not found: $ENV_PATH"
  exit 1
fi

# Создание папки, если не существует
mkdir -p "$(dirname "$REPORT_PATH")"

# Запуск теста
echo "====================================="
echo "🧪 Running Postman Collection"
echo "Collection:  $COLLECTION_PATH"
echo "Environment: $ENV_PATH"
echo "Output:      $REPORT_PATH"
echo "====================================="

newman run "$COLLECTION_PATH" -e "$ENV_PATH" -r json --reporter-json-export "$REPORT_PATH"

echo "✅ Test report saved to $REPORT_PATH"
