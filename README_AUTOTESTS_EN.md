# Instructions for Running Autotests with Allure (Java + TestNG + Maven)

## Requirements

- **JDK 17** installed (`JAVA_HOME` configured)
- **Maven** installed and available in `PATH`
- **Allure CLI** installed (`allure --version` should work)
- All dependencies resolved (`mvn clean verify` or `mvn dependency:resolve`)

---

## For Windows / PowerShell

| #  | Action                                           | Command                                                                 |
|----|--------------------------------------------------|-------------------------------------------------------------------------|
| 1  | Remove old builds and results                    | `mvn clean`                                                             |
| 2  | Run tests and generate Allure results            | `mvn test`                                                              |
| 3  | Generate Allure report                           | `allure generate target/allure-results --clean -o target/allure-report` |
| 4  | Open Allure report in browser                    | `allure open target/allure-report`                                      |
| 5  | Run a specific test (example)                    | `mvn -Dtest=CatalogPageTest#testCatalogHouseCardsAreVisibleAndCounted test` |

---

## For Linux / macOS / CI

(Additionally: `export DISPLAY=:99` — if using Xvfb manually)

| #  | Action                                           | Command                                                                 |
|----|--------------------------------------------------|-------------------------------------------------------------------------|
| 1  | Remove old builds and results                    | `mvn clean`                                                             |
| 2  | Run tests                                        | `mvn test`                                                              |
| 3  | Generate Allure report                           | `allure generate target/allure-results --clean -o target/allure-report` |
| 4  | Open Allure report                               | `allure open target/allure-report`                                      |
| 5  | Run a specific test                              | `mvn -Dtest=CatalogPageTest#testCatalogHouseCardsAreVisibleAndCounted test` |

---

## Additional

- **Run by groups** (if using `@Test(groups = "...")`):
  ```bash
  mvn test -Dgroups=smoke
  ```

---

## Git Ignore

```gitignore
# Allure
target/allure-results/
target/allure-report/

# IDE
.idea/
*.iml

# Logs
logs/
```

---

✅ Everything is ready for local and CI execution. Add parameters or extend the configuration for specific environments if needed.
