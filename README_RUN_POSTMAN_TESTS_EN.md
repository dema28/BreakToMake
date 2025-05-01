# Autotests: Running Postman Collections Using Newman

## Requirements
- Node.js and `npm` installed
- `newman` installed: `npm install -g newman`
- Collection files are located in `src/postman/collections/`
- Environment files are located in `src/postman/environments/`

---

## Project Structure (fragment)
```
.
├── scripts/
│   ├── run_postman_tests.bat     # For Windows CMD
│   ├── run_postman_tests.sh      # For Linux/macOS/CI
│   └── run_postman_tests.ps1     # For PowerShell
├── src/
│   └── postman/
│       ├── collections/
│       └── environments/
├── reports/
│   └── postman_reports/
```

---

## Running Postman Collections

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

## Reports
JSON reports are saved to the folder:
```
reports/postman_reports/
```

---

## Note
The scripts automatically:
- check for the presence of `newman`
- check for the required files
- create the report directory if it doesn’t exist

If you want to run other collections — just change the path in the `COLLECTION_PATH` variable inside the script.
