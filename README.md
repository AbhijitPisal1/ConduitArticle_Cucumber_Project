## ConduitArticle_Cucumber_Project

Welcome to the **ConduitArticle_Cucumber_Project** repository. This project demonstrates the use of **Cucumber** for Behavior Driven Development (BDD) in conjunction with **Selenium** and **TestNG** for test automation. The repository follows a Page Object Model (POM) and uses Cucumber annotations for test steps, ensuring maintainable and scalable test scripts.

## Table of Contents
1. [Repository Overview](#repository-overview)
2. [Technologies Used](#technologies-used)
3. [Installation Instructions](#installation-instructions)
4. [Folder Structure](#folder-structure)
   - [src/test/java](#srctestjava)
   - [src/test/resources](#srctestresources)
5. [Contributing](#contributing)
6. [License](#license)
7. [Acknowledgments](#acknowledgments)

## Repository Overview

This repository is designed to help developers understand the use of **Cucumber** with **Selenium** in **Java** for test automation. The repository is structured to demonstrate the use of Page Object Model (POM) for better code organization, reusability, and maintainability. The project also integrates **TestNG** for test execution and reporting.

## Technologies Used

For details on the technologies used in this project, refer to the `pom.xml` file for configuration.

## Installation Instructions

To get started with this repository on your local machine, follow the steps below:

### Prerequisites:
1. Ensure you have **Java 8+** installed on your machine.
2. You will need **Maven** to build the project and handle dependencies.
3. **IDE**: Use an IDE like **IntelliJ IDEA** or **Eclipse** to open and work with the repository.

### Steps to Clone and Set Up:
```plaintext
1. **Clone the repository**:
   git clone [https://github.com/yourusername/ConduitArticle_Cucumber_Project.git](https://github.com/AbhijitPisal1/ConduitArticle_Cucumber_Project.git)
   cd ConduitArticle_Cucumber_Project

2. **Build the project** using Maven:
   mvn clean install

3. **Run the tests** using Maven:
    mvn test
```

This will set up the project and execute the tests defined in the MytestRunner class.

## Folder Structure
The repository is organized into several folders to structure the project in a clean and maintainable way. Here’s a breakdown of the folder structure:

### Source Code
- **src/test/java**: Contains Java files for test execution.
  - **base folder**: Contains TestBase.java for setting up common driver-related functions.
  - **commonUtils**: Contains Utility.java, which includes methods for handling screenshots and alerts.
  - **pages**: Contains multiple page objects that implement the Page Object Model (POM) and PageFactory pattern for cleaner and more reusable test code.
  - **runners**: Contains the MytestRunner.java file for managing test execution.
  - **stepDefs**: Contains the StepDefs.java file for defining step definitions using TestNG and Cucumber annotations. It also includes the Hooks.java file for setting up the driver before tests and attaching screenshots on test failures.

### Resources
- **src/test/resources**: Contains feature files written in **Gherkin** syntax for the book search functionality.
  - **features folder**: Contains the ArticleTest.feature file, which defines the test scenarios in Gherkin syntax for Behavior Driven Development (BDD)

## Contributing

We welcome contributions! If you'd like to contribute, follow these steps:

1. **Fork the repository**: Create a fork of the repository to your own GitHub account.
2. **Clone your fork**: Clone the forked repository to your local machine.
3. **Create a branch**: Make changes in a new branch for clarity and separation of concerns.
   ```plaintext
   git checkout -b feature/your-feature
   ```
4. **Commit changes**: After making the necessary changes, commit them with a meaningful commit message.
   ```plaintext
   git add .
   git commit -m "Added new feature"
   ```
5. **Push changes**: Push your changes to your forked repository.
   ```plaintext
   git push origin feature/your-feature
   ```
6. **Create a Pull Request**: Go to your forked repository on GitHub and create a Pull Request to merge your changes into the main repository.

Please ensure to follow the repository's coding standards and test your changes before submitting a PR.

## License

This project is not licensed. All rights are reserved by the author.

## Acknowledgments

- Special thanks to the **Cucumber** community for providing a robust BDD framework.
- Thanks to the **Selenium** community for creating a powerful tool for browser automation.
- This repository is created to help beginners learn and practice test automation using **Cucumber** and **TestNG**.

Feel free to reach out if you have any questions or need further clarification. Happy learning and automating!
