@echo off
set COLLECTION_PATH=src\postman\collections\login_collection.json
set ENV_PATH=src\postman\environments\local_environment.json
set REPORT_PATH=reports\postman_reports\report.json

echo Running Postman collection: %COLLECTION_PATH% with environment: %ENV_PATH%

newman run %COLLECTION_PATH% -e %ENV_PATH% -r json --reporter-json-export %REPORT_PATH%
echo Test report saved to %REPORT_PATH%
