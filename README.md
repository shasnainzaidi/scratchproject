[![CircleCI](https://circleci.com/gh/shasnainzaidi/scratchproject.svg?style=shield)](https://circleci.com/gh/shasnainzaidi/scratchproject)

# Project Name: Scratch Project
The Scratch Project is a Selenium-based test automation framework designed for end-to-end testing of web applications. The framework supports mobile and desktop browsers, enabling cross-browser testing and mobile emulation. It simplifies the testing process with pre-configured setups and integrates seamlessly with CI/CD pipelines. It is name Scratch because it encores the core Selenium Java concepts from the scratch.

## Description
This project automates various test scenarios for the OLX web platform using Selenium WebDriver, TestNG, and Maven. It includes login functionalities, ad posting, and other critical features to ensure the web platform's stability.

## Technologies Used
- Selenium WebDriver
- TestNG
- Maven
- ChromeDriver
- Applitools Eyes (for visual testing)
- Git for version control
- AutoIT for file uploading

**Key Features:**
- Automated cross-browser testing
- Mobile emulation using Chrome DevTools
- Configurable test environments
- Headless browser support for CI/CD pipelines

## Setup
Follow these steps to set up the project on your local machine:

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- Maven 3.6.3 or higher
- Git
- An IDE such as IntelliJ IDEA or Eclipse

### Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/shasnainzaidi/scratchproject.git
   cd scratchproject
 ```
2. Navigate to the project directory:
   ```bash
   cd scratch
   ```
3. Install the dependencies using Maven:
   ```bash
   mvn clean install
   ```

### Running Tests
- To run all tests:
  ```bash
  mvn test
  ```
- To run specific groups of tests (e.g., Sanity):
  ```bash
  mvn -Dgroups=Sanity test
  ```
## Project Structure
 - `src/test/java`: Contains test classes for execution.
  - `hpcases`: Contains High Priority Test Cases like `Logins`, `adPosting`, etc.
  - `concepts`: Includes core automation concept usage like utility classes like `configReader`, multi browser testing & Retry Analyzer
  - `objects`: Contains Page Object Model classes.
  - `mwHighPriority`: Contains high priority mobile web tests
  - `homepage`: Contain e2e testcases from homepage
  - `visuals`: Contains visual tests from 

- `pom.xml`: Maven configuration file for managing dependencies.
- `.circleci`: Integration with CI/CD tool circleci, contain config.yml file for integration.

## Test Plan

### Test Cases
1. **Login Email Test** @loginEmail
   - **Description**: Verifies that a user can log in using their email.
   - **Steps**:
     1.Go to web URL
     2. Navigate to the login page.
     3. Enter the email and password.
     4. Click the login button.
   - **Expected Outcome**: The user is successfully logged in and redirected to the homepage.

2. **Login Phone Test** @loginPhone
   - **Description**: Verifies that a user can log in using their phone number.
   - **Steps**:
     1. Go to web URL
     2. Navigate to the login page.
     3. Enter the phone number and password.
     4. Click the login button.
   - **Expected Outcome**: The user is successfully logged in and redirected to the homepage.
   - 
3.  **Free Ad Posting Test**
   - **Description**: Ensures that a logged-in user can post an ad for free.
   - **Steps**:
     1. Log in using the `loginEmail` method.
     2. Navigate to the ad posting section.
     3. Fill out the required details.
     4. Submit the ad.
   - **Expected Outcome**: The ad is successfully posted and visible on the user's profile.

## Configuration Files

### config.properties
- `baseURL`: The base URL of the application.
- `timeout`: The timeout value for WebDriver waits.
- `browser`: The browser to use for testing (e.g., Chrome, Firefox).
- `prod`   : Production environment link
- `stage`  : Staging environment link
- `scroll.vertical` : Pixels for vertical scroll
- `scroll.horizontal` : Pixels for horizontal scroll

### testng.xml
- Defines the test suite and test groups.
- Includes listeners for reporting and other configurations.

## Known Issues
- The `loginEmail` test occasionally fails due to a race condition in page loading.
- The 'olxFooter' Test occasionally fails due to a race condition in page loading.

## Future Improvements
- Implement parallel test execution for faster results.
- Improve the code usage and better reporting using Allure reports.

## Contributors
- Syed Hasnain Zaidi (Project Lead)
