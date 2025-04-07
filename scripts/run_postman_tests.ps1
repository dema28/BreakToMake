$CollectionPath = "src/postman/collections/login_collection.json"
$EnvPath = "src/postman/environments/local_environment.json"
$ReportPath = "reports/postman_reports/report.json"

Write-Host "🧪 Running Postman Collection"
Write-Host "Collection:  $CollectionPath"
Write-Host "Environment: $EnvPath"
Write-Host "Output:      $ReportPath"

# Проверка newman
if (-not (Get-Command newman -ErrorAction SilentlyContinue)) {
    Write-Error "❌ Newman is not installed. Run: npm install -g newman"
    exit 1
}

# Проверка файлов
if (-not (Test-Path $CollectionPath)) {
    Write-Error "❌ Collection file not found: $CollectionPath"
    exit 1
}

if (-not (Test-Path $EnvPath)) {
    Write-Error "❌ Environment file not found: $EnvPath"
    exit 1
}

# Создание директории, если не существует
$reportDir = Split-Path $ReportPath
if (-not (Test-Path $reportDir)) {
    New-Item -ItemType Directory -Path $reportDir | Out-Null
}

# Запуск Newman
newman run $CollectionPath -e $EnvPath -r json --reporter-json-export $ReportPath

Write-Host "✅ Test report saved to $ReportPath"
