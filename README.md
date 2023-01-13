# PACT - Provider Project

This is a spring boot based microservice for technical courses that shall be consumed by an Onboarding microservice. The purpose of the project is to demonstrate consumer driver contract testing using Pactflow

## Getting Started

1. Clone the Project
2. Create DB and Tables specified 
3. Start the server by running : *src/main/java/com/parthibanrajasekaran/ProviderApplication.java*

### DB & Table creation

```roomsql
CREATE DATABASE Courses;

use Courses;

CREATE TABLE Course_Inventory(course_name varchar(50),id varchar(50),

price int,

category varchar(50),

PRIMARY KEY (course_name));

INSERT INTO Course_Inventory(course_name,id,price,category) values("Microservices testing","2",23,"api");
INSERT INTO Course_Inventory(course_name,id,price,category) values("Selenium","3",66,"web");
INSERT INTO Course_Inventory(course_name,id,price,category) values("Appium","12",13,"mobile");

SELECT 
    *
FROM
    Course_Inventory;
```

### Prerequisites

* Java 17+
* MySql
* Maven
* Pactflow account (optional : to trigger contracts from remote url)
* IDE (IntelliJ)

## Test Location
* Pact Provider Tests: src/test/java/com/parthibanrajasekaran/courses/PactCoursesTests.java
* Unit Tests: src/test/java/com/parthibanrajasekaran/courses/ProviderApplicationTests.java

## Usage

* To run PACT provider tests, trigger tests from the aforementioned location

* To run all tests in the project (Unit + Pact Provider tests)
```
$ mvn clean test
```
* By default, the pact tests run against the contract in remote url (https://parthibanrajasekaran.pactflow.io/)

* If you wish to run contracts from your local machine, then move your contract to src/main/java/pacts then run your pact tests in the aforementioned location

## Additional Documentation and Acknowledgments

<p align="center">
  <a href="https://docs.pact.io/">What is PACT?</a> •
  <a href="https://junit.org/junit5/docs/current/user-guide/">Assertions</a>
</p>

## FAQ
How can I delete the table created?
```roomsql
use Courses;
DROP TABLE Course_Inventory;
```

How can I delete the DB created
```roomsql
DROP DATABASE Courses;
```