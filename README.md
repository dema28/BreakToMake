# BreakToMake — Automated Testing Project

![Java](https://img.shields.io/badge/java-17-blue)
![TestNG](https://img.shields.io/badge/TestNG-enabled-brightgreen)
![Allure](https://img.shields.io/badge/Allure-integrated-orange)
![CI](https://github.com/dema28/BreakToMake/actions/workflows/CI.yml/badge.svg)
![License](https://img.shields.io/badge/license-MIT-green)

---

## Project Description

**BreakToMake** is a diploma project combining **manual** and **automated testing** of a modular homes website. The project includes:

- Comparison of Manual and Automation testing approaches
- Coverage of positive and negative scenarios (UI and API)
- End-to-End testing (UI + API)
- Performance testing (Postman + Newman)
- Reporting via Allure
- CI/CD automation using GitHub Actions

---

## Technologies

| Category        | Tools                                     |
|----------------|--------------------------------------------|
| Language        | Java 17                                    |
| UI Testing      | Selenium + TestNG                          |
| API Testing     | Postman + Newman                           |
| Reporting       | Allure Reports                             |
| CI/CD           | GitHub Actions                             |
| Documentation   | Markdown + Excel + PDF                     |
| IDE             | IntelliJ IDEA                              |
| Version Control | Git + GitHub                               |

---

## Project Structure

```
BreakToMake/
├── .github/workflows/              # CI via GitHub Actions
├── manual_testing/
│   ├── bug_reports/                # Bug reports
│   ├── test_cases/                 # Test cases for MMV_MODUL project
│   └── test_runs/                  # Final test run reports
├── reports/
│   ├── allure_reports/             # Allure reports (with screenshots)
│   └── postman_reports/            # Postman/Newman reports
├── scripts/                        # Test run scripts
├── src/
│   ├── main/                       # Page Object + configs + utils
│   ├── postman/                    # Postman collections and environments
│   └── test/                       # UI tests in Java
├── test_data/                      # CSV/JSON data for tests
├── logs/                           # Logs from tests and CI
├── README.md                       # Main README
├── README_AUTOTESTS.md             # Java + Allure instructions
├── README_RUN_POSTMAN_TESTS.md     # Instructions for Postman tests
├── Allure_Errors_Solutions.md      # Common Allure issues and fixes
├── LICENSE.txt                     # MIT License
└── pom.xml                         # Maven configuration
```

---

## How to Run Tests

### UI Tests (Java + TestNG)
```bash
mvn clean test
allure generate target/allure-results --clean -o target/allure-report
allure open target/allure-report
```
For details see [README_AUTOTESTS.md](README_AUTOTESTS_EN.md)

### API Tests (Postman + Newman)
```bash
bash scripts/run_postman_tests.sh
```
For details see [README_RUN_POSTMAN_TESTS.md](README_RUN_POSTMAN_TESTS_EN.md)

---

## Useful Links

| Section             | Link                                                                        |
|---------------------|-----------------------------------------------------------------------------|
| Test Cases          | [test_cases_MMV_MODUL](manual_testing/Versions_EN/test_cases/)              |
| Bug Reports         | [bug_reports](manual_testing/Versions_EN/bug_reports/)                      |
| Allure Errors       | [Allure_Errors_Solutions.md](Allure_Errors_Solutions.md)                    |
| Final Test Report   | [TestRun_Report.md](manual_testing/Versions_EN/test_runs/TestRun_Report.md) |
| UI Autotests        | [README_AUTOTESTS.md](README_AUTOTESTS_EN.md)                               |
| Postman Instruction | [README_RUN_POSTMAN_TESTS.md](README_RUN_POSTMAN_TESTS_EN.md)               |

---

## License

This project is licensed under the **MIT** license.  
Author: **Denis Novicov** | QA Manual & Automation Engineer 🇨🇿  
See [LICENSE.txt](LICENSE_EN.txt) for more details.
