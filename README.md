# become-qa

This framework is designed for testing GitHub UI and API using Java, Maven and Selenium

# Framework structure

Modules:

1. Applications
2. Configuration 
3. Utilities 
4. Tests

## Used tools

1. Rest-Assured - tool for test API requests
2. TestNG - tool for add annotations, run, configure tests (run test suit by .xml file)

## 1. Applications module

Contains all classes related with specific app. 
Class with requests implementations for specified API calls. 

## 2. Configuration

Read prepared JSON with baseURL to properties. 

## 3. Utilities

Base class with request implementation - build request with provided properties, validate response 

## 4. Tests 

Contains Test suits for specified API calls. 
Copy or modify TestRunner.xml file allows to specify source of data for tests 

# Framework tree
```
src
   ├───main
   │   └───java
   │       ├───applications ----------------------> Module for each app
   │       │   └───github
   │       │       ├───api
   │       │       │   ├───data
   │       │       │   │   └───default_headers
   │       │       │   └───user_module
   │       │       │       ├───builders  ---------> Create object from provided data
   │       │       │       ├───constants ---------> Request Path
   │       │       │       ├───data      ---------> JSON data for testing
   │       │       │       │   └───user_data
   │       │       │       ├───models    ---------> Request body models 
   │       │       │       └───services  ---------> Requests service class
   │       │       └───ui
   │       ├───config  ---------------------------> BaseURL for whole test suite
   │       │   └───envs
   │       └───utilities -------------------------> Package with class necessary in whole framework
   │           ├───common
   │           ├───jsonUtils
   │           └───requestsUtils ----------------> Base requests class to build request 
   │               └───builders
   └───test
       ├───java
       │   └───applications
       │       └───github
       │           ├───api
       │           │   └───user
       │           └───ui
       └───resources
```

