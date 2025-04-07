@echo off
setlocal

set COLLECTION_PATH=src\postman\collections\login_collection.json
set ENV_PATH=src\postman\environments\local_environment.json
set REPORT_PATH=reports\postman_reports\report.json

:: Проверка наличия newman
where newman >nul 2>&1
if errorlevel 1 (
    echo ❌ Newman is not installed. Run: npm install -g newman
    exit /b 1
)

:: Проверка наличия файлов
if not exist %COLLECTION_PATH% (
    echo ❌ Collection file not found: %COLLECTION_PATH%
    exit /b 1
)

if not exist %ENV_PATH% (
    echo ❌ Environment file not found: %ENV_PATH%
    exit /b 1
)

:: Убедимся, что папка для отчётов существует
if not exist reports\postman_reports (
    mkdir reports\postman_reports
)

echo =====================================
echo 🧪 Running Postman Collection
echo Collection:  %COLLECTION_PATH%
echo Environment: %ENV_PATH%
echo Output:      %REPORT_PATH%
echo =====================================

newman run %COLLECTION_PATH% -e %ENV_PATH% -r json --reporter-json-export %REPORT_PATH%

echo ✅ Test report saved to %REPORT_PATH%
endlocal
