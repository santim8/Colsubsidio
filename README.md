# Colsubsidio Testing Framework

## Overview
This framework provides automated testing capabilities for Colsubsidio services, enabling both API and UI testing with a BDD approach. It supports end-to-end testing of various services including user authentication, validation rights, card validation, restrictive list verification, and pre-approval checks.

## Technologies
- Java 17
- Maven
- Selenium WebDriver (UI Testing)
- RestAssured (API Testing)
- Cucumber (BDD)
- TestNG (Test Execution)
- Extent Reports (Reporting)
- Docker & Jenkins (CI/CD)

## Prerequisites
- Java JDK 17
- Maven 3.8+
- Git

## Setup
1. Clone the repository:
   ```
   git clone [repository-url]
   ```

2. Navigate to the project directory:
   ```
   cd colsubsidioFramework
   ```

3. Install dependencies:
   ```
   mvn clean install
   ```

## Project Structure
```
colsubsidioFramework/
├── src/
│   ├── main/java/                    # Core framework code
│   │   └── org/colsubsidio/framework/
│   │       ├── models/               # Data models
│   │       └── ...                   # Other framework components
│   └── test/
│       ├── java/                     # Test implementations
│       └── resources/
│           ├── features/             # Cucumber feature files
│           ├── schemas/              # JSON schemas for validation
│           └── suits/                # TestNG XML suite files
├── libs/                             # External libraries
├── DockerFile                        # Docker configuration
├── Jenkinsfile                       # Jenkins pipeline definition
└── pom.xml                           # Maven configuration
```

## Running Tests
### Local Execution
Run all tests:
```
mvn test
```

Run specific TestNG suite:
```
mvn test -Dsurefire.suiteXmlFiles=src/test/resources/suits/suitTest.xml
```

Run Cucumber tests:
```
mvn test -Dsurefire.suiteXmlFiles=src/test/resources/suits/suitCucumber.xml
```

### CI/CD Execution
The project includes Jenkins pipeline configuration for automated test execution. The pipeline is defined in the Jenkinsfile.

## Features
- BDD-style test definitions
- API testing with request/response validation
- Detailed test reporting
- CI/CD integration
- Reusable test components

## License
[Specify License]

## Contact
[Provide Contact Information]