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

3. Update configuration files with your credentials:
   - Edit `src/test/resources/figma.properties` with your Figma API access token
   - Edit `src/test/resources/sdk.properties` with your authentication credentials

4. Install dependencies:
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
│           ├── suits/                # TestNG XML suite files
│           ├── figma.properties      # Figma API configuration
│           └── sdk.properties        # SDK authentication configuration
├── libs/                             # External libraries
├── DockerFile                        # Docker configuration
├── Jenkinsfile                       # Jenkins pipeline definition
└── pom.xml                           # Maven configuration
```

### Configuration Files
The project requires configuration of the following properties files:

#### `figma.properties`
Contains Figma API configuration:
```properties
figma.base.uri=https://api.figma.com/
figma.images.base.path=v1/images/
figma.access.token=YOUR_FIGMA_ACCESS_TOKEN
```

#### `sdk.properties`
Contains SDK authentication credentials:
```properties
#Global
magnifai.port=443
magnifai.host=https://console.magnifai.es
magnifai_auth.host=https://auth-console.magnifai.es

#Auth
auth.port=443
auth.user=YOUR_USERNAME
auth.password=YOUR_PASSWORD
auth.token.threshold.seconds=120
```

**Important**: Always replace the placeholder credentials with your own before running tests.

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