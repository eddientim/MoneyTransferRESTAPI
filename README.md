
# Simple implementation of RESTful API for money transfers between accounts.

REST API consist of transaction operations.

## Setup

After the project has been cloned, in the project directory <br/>
"mvn test" and "mvn package" commands can be called. <br/>

### Ports

This project uses port "8888" as default <br/>


### Tech Stack
- Java 11
- MAVEN for dependency management
- Javalin Framework  <br/>
- Jackson for JSON formatting <br/>
- TestNG for unit testing <br/>
- unirest for unit testing <br/>

### Installing

Run "mvn package"<br/>
Under the target directory "MoneyTransferRESTAPI-<version>.jar" will be created.<br/>
This jar file contains all the necessary dependencies.<br/>
It can be directly called via "java -jar <jar_name>"<br/>

## Running the tests

Calling "mvn test" command will eventually execute all the test cases.

## HTTP Status
- 200 OK
- 400 Bad request
- 404 Not found
- 500 Internal server error

