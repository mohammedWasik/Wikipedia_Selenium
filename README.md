# Wikipedia Selenium Automation Project

## Overview
This project automates Wikipedia's core functionalities using **Selenium WebDriver, TestNG, and Java**.  
It follows the **Page Object Model (POM)** structure, ensuring better maintainability and scalability.


## Technologies Used
- **Java** – Core programming language
- **Selenium WebDriver** – Browser automation
- **TestNG** – Test execution and reporting
- **Maven** – Dependency management
- **Allure** – Test reporting

## Setup Instructions

### Clone the Repository
```sh
git clone https://github.com/mohammedWasik/Wikipedia_Selenium.git

cd Wikipedia_Selenium

```
### Install Dependencies

```
mvn clean install

```
### Configure Properties
Edit the config.properties file in resources/ to update browser settings and URLs.

### Run Test

```sh
mvn test
```
### Generate Test Reports
To generate an Allure report, run:

```sh
allure serve target/allure-results
```


### Test Cases Covered
1.Search Language Test – Validates Wikipedia search functionality in different languages.

2.Page Information Test – Checks if the retrieved page information is accurate.

3.PDF Download Test – Verifies the PDF download functionality.


### Contributing
Feel free to contribute by submitting pull requests or reporting issues! 🚀

 Save and Push to GitHub

After writing your README file, save it and push it to GitHub:  

```sh
git add README.md
git commit -m "Added README"
git push origin main
```
