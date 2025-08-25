# Project Overview

This is a Spring Boot project written in Kotlin that implements a simple RESTful API. The project is built with Gradle and uses Java 21.

The API provides basic CRUD operations for managing users. It demonstrates the use of various Spring Web annotations like `@RestController`, `@RequestMapping`, `@GetMapping`, `@PostMapping`, and `@PutMapping`. It also shows how to handle request and response bodies with data classes.

## Building and Running

### Building the project

To build the project, run the following command in the root directory:

```bash
./gradlew build
```

### Running the project

To run the project, use the following command:

```bash
./gradlew bootRun
```

The application will start on `http://localhost:8080`.

### Running tests

To run the tests, use the following command:

```bash
./gradlew test
```

## Development Conventions

*   **Language:** The project is written in Kotlin.
*   **Framework:** It uses the Spring Boot framework.
*   **Build Tool:** Gradle is used for building the project and managing dependencies.
*   **API Style:** The API follows RESTful principles.
*   **Data Transfer Objects (DTOs):** The project uses data classes (`UserRequest`, `UserResponse`) for handling request and response data.
*   **Controller Structure:** Controllers are organized by the HTTP method they handle (e.g., `GetApiController`, `PostApiController`, `PutApiController`).

## Project Structure

```
├── build.gradle.kts      # Gradle build script for project dependencies and configuration
├── gradlew               # Gradle wrapper script for Unix-based systems
├── gradlew.bat           # Gradle wrapper script for Windows
├── settings.gradle.kts   # Gradle settings script
└── src
    ├── main
    │   ├── kotlin
    │   │   └── com
    │   │       └── example
    │   │           └── mvc
    │   │               ├── MvcApplication.kt     # Main application entry point
    │   │               ├── controller
    │   │               │   ├── get
    │   │               │   │   └── GetApiController.kt   # Handles GET requests
    │   │               │   ├── post
    │   │               │   │   └── PostApiController.kt  # Handles POST requests
    │   │               │   └── put
    │   │               │       └── PutApiController.kt   # Handles PUT requests
    │   │               └── model
    │   │                   └── http
    │   │                       ├── UserRequest.kt      # Data class for user requests
    │   │                       └── UserResponse.kt     # Data class for user responses
    │   └── resources
    │       ├── application.properties  # Spring Boot application configuration
    │       ├── static                  # Directory for static assets
    │       └── templates               # Directory for templates
    └── test
        └── kotlin
            └── com
                └── example
                    └── mvc
                        └── MvcApplicationTests.kt # Tests for the application
```