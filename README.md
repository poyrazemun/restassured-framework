# API Test Automation Framework

## Overview
This project is a Test Automation Framework for API testing using **Java, TestNG, and RestAssured**. It follows best practices in automation testing, including data-driven testing, property file configurations, and logging mechanisms.

## Project Structure
```
|-- .gitignore
|-- pom.xml
|-- testng.xml
|-- src
|   `-- test
|       |-- java
|       |   |-- api
|       |   |   |-- payload          # POJO classes for API requests
|       |   |   |-- test             # API test classes
|       |   |   |-- utilities        # Utility classes (e.g., Excel reader, Data providers)
|       |   |-- base                 # Base classes for API test execution
|       |-- resources
|           |-- log4j2.xml            # Logging configuration
|           |-- routes.properties     # API route configurations
|-- reports                           # Test execution reports
|-- logs                              # Log files for debugging
|-- testData                          # External test data (e.g., Excel files)
```

## Prerequisites
- Java 8 or later
- Maven
- TestNG
- RestAssured

## Installation
1. Clone the repository:
   ```sh
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```sh
   cd <project-folder>
   ```
3. Install dependencies using Maven:
   ```sh
   mvn clean install
   ```

## Running Tests
- To execute all tests:
  ```sh
  mvn test
  ```
- To run specific test classes:
  ```sh
  mvn -Dtest=TestUserModule test
  ```
- To execute tests using `testng.xml`:
  ```sh
  mvn test -DsuiteXmlFile=testng.xml
  ```

## Test Reporting
- Test reports are generated in the `reports` directory.
- Additional reports (e.g., TestNG, Surefire) are available in `target/surefire-reports`.

## Logging
- Log files are stored in the `logs` directory.
- Configurable via `log4j2.xml`.

## Configuration
- API routes are managed in `routes.properties`.
- Test data is stored in `testData/userData.xlsx`.
- Utility methods for reading property files and Excel data are available in `utilities`.

## Author
[Your Name]

