# become-qa

This framework is designed for testing GitHub UI and API using Java, Maven and Selenium

# Framework structure

Modules:

1. Configuration
2. Application

## Used tools

1. Rest-Assured - tool for test API requests
2. TestNG - tool for add annotations, run, configure tests

## 1. Config module

Read values from configure json file

## 2. Application module
```
├──src 
    ├───main 
    │   └───java 
    │       ├───applications # Module containing GitHub Api actions
    │       │   └───github 
    │       │       ├───api 
    │       │       │   ├───constants 
    │       │       │   └───users 
    │       │       └───ui 
    │       ├───config # Module for basics configuration
    │       │   └───envs 
    │       └───utilities # Module with helper classes
    │           ├───jsonUtils 
    │           └───requestsUtils 
    └───test 
        ├───java 
        │   └───applications # Module with Test Cases to perform
        │       └───github 
        │           ├───api 
        │           └───ui
        └───resources
```

