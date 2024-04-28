# Devowelizer Service

## Overview
This project provides a Devowelizer service, which removes vowels from input strings. It includes automated tests to validate the service functionality.

## How to Run the Project

### Environment Setup
- Install and run Docker.
- Run the Devowelizer service using Docker:

- docker run -p 8080:8080 -it casumo/devowelizer:latest

- Open your browser and navigate to http://localhost:8080/ + input to use the service.
- Run the source code from your favorite IDE.

### Tools Used
- Java JDK 17 as the programming language
- RestAssured 5.4.0 for RESTful API testing
- TestNG 7.04.0 as the testing framework
- Apache POI 5.2.5 for reading test data from Excel

## Automated Tests
- There are 3 automated tests to cover different scenarios:
1. `SDevowelizerServiceGetInputTest`: Tests 14 different cases using data-driven testing with a provided Excel file.
2. `StatusCodeTest`: Tests the status code returned by the Devowelizer service.
3. `HugeInputTest`: Tests the service with a huge input string.

## Bugs
1. Capitalized letters are not devowelized.
2. The localhost fails to respond when a huge input string is provided.
3. Performance issues have been observed.

## Automation Solution
- Implemented retry logic to retry failed test cases up to 3 times.

## Contact Information
- Email: mofid.zaki@outlook.com
- Phone: +201203328894
