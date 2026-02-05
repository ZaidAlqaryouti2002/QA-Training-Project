# SauceDemo Automation Testing

Automated testing suite for SauceDemo e-commerce website using Selenium WebDriver and TestNG.

## Description

This project contains automated end-to-end tests for the SauceDemo application (https://www.saucedemo.com/).
The test suite covers the complete user flow from login to logout, including product selection, cart management, and checkout process.

## Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Microsoft Edge WebDriver

## Prerequisites

Before running the tests, ensure you have the following installed:

- Java JDK 8 or higher
- Maven (for dependency management)
- Microsoft Edge browser
- Edge WebDriver

## Setup

1. Clone the repository:
```bash
git clone https://github.com/ZaidAlqaryouti2002/QA-Training-Project
cd QA-Training-Project
```

2. Install dependencies using Maven:
```bash
mvn clean install
```

3. Ensure Edge WebDriver is properly configured in your system PATH or project dependencies.

## Test Cases

The test suite includes the following test cases executed in sequence:

1. **SignIn** - Logs into the application with valid credentials
2. **AddItemsToCart** - Adds two items to the shopping cart
3. **GoToCart** - Navigates to the cart page
4. **Checkout** - Initiates the checkout process
5. **FillCheckoutData** - Enters customer information
6. **Finish** - Completes the order
7. **BackHome** - Returns to the products page
8. **OpenMenu** - Opens the navigation menu
9. **SignOut** - Logs out of the application

## Running the Tests

Run all tests using Maven:
```bash
mvn test
```

Or run the test class directly from your IDE (IntelliJ IDEA, Eclipse, etc.)

## Project Structure

```
SauceTest/
└── automationTests.java    # Main test class containing all test cases
```

## Configuration

- **Base URL**: https://www.saucedemo.com/
- **Browser**: Microsoft Edge
- **Implicit Wait**: 15 seconds
- **Test Delays**: 2 seconds between each test

## Test Credentials

- **Username**: standard_user
- **Password**: secret_sauce

## Features

- Automatic browser window maximization
- Implicit wait configuration for element synchronization
- Thread sleep delays for better test observation
- Comprehensive assertions for test validation
- Proper browser cleanup after test execution

## Contributing

Feel free to fork this project and submit pull requests for any improvements.

## License

This project is open source and available under the MIT License.

## Author

Zaid Alabed

## Acknowledgments

- SauceDemo for providing the test application
- Selenium WebDriver community
- TestNG framework