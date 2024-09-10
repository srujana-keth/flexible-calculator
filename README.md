# Calculator App

## Overview

This is a simple, extensible calculator application implemented in Java, following the **Open-Closed Principle (OCP)**. The calculator supports basic operations like addition, subtraction, multiplication, and division, with the flexibility to add new operations without modifying existing code.

The design makes use of:

- **Interfaces** to define operations (`GeneralOperations`).
- **Enum** to define a set of supported operations (`Operation`) .
- **Class registration** that allows for easy extension of new operations.

## Features

- **Basic Operations**: Addition, Subtraction, Multiplication, Division.
- **Chain Operations**: The ability to chain multiple operations together, respecting the order they are provided in.
- **Open-Closed Principle**: You can add new operations without modifying the core logic of the calculator. New operations can be implemented as new classes that extend the `GeneralOperations` interface.
- **Dynamic Registration**: New operations can be dynamically registered at runtime.

## Assumptions

- The calculator operates with **double precision** for all operations, converting inputs to `double` via `doubleValue()` from the `Number` class.
- Division by zero throws an **ArithmeticException** with a custom message `"Cannot divide by zero"`.
- Operations are passed as instances of the `Operation` enum and must be valid enum values.
- Chain operations are evaluated in the order they are provided. Operator precedence (like `*` before `+`) is **not handled** in this version.

## Design Decisions

- **Open-Closed Principle (OCP)**: The application adheres to OCP by using the `GeneralOperations` interface for each operation (e.g., `Sum`, `Difference`, `Product`, `Division`). This makes the application **closed to modification** but **open for extension**, meaning you can add new operations without changing the `Calculator` class.
  
- **Folder-Structure**: The project is organized into logical packages:
  - `com.calculator`: Contains the core `Calculator` class.
  - `com.calculator.enums`: Contains the `Operation` enum.
  - `com.calculator.operations`: Contains all classes that implement different operations (e.g., `Sum`, `Difference`, `Product`, `Division`).

- **Dynamic Operation Registration**: The calculator allows dynamic registration of new operations at runtime using the `addNewOperation()` method.

## Installation and Setup

### Prerequisites

- **Java 17 or later** is required to run this project.
- **Maven** is used for building the project. If Maven is not installed, you can download it [here](https://maven.apache.org/download.cgi).
- **Docker** is required for building and running the application inside a container.

### Steps to Build and Run Locally

1. **Clone the repository**:

   ```bash
   git clone https://github.com/srujana-keth/calculator-app.git
   cd calculator-app
   ```

2. **Build the project**:
   Run the following command to compile the source files and run any tests.

   ```bash
   mvn clean install
   ```

3. **Run the application**:
   To run the calculator with basic operations, use the following command:

   ```bash
   java -cp target/classes com.calculator.Main
   ```

4. **Run unit tests**:
   The unit tests can be executed using:

   ```bash
   mvn test
   ```

### Running the Application with Docker

#### Building and Running the Docker Container

To run the application inside a Docker container, follow these steps:

1. **Build the Docker Image**:
   First, you need to build the Docker image using the `Dockerfile` provided. Run the following command in the root of the project directory:

   ```bash
   docker build -t calculator-app .
   ```

2. **Run the Docker Container in Interactive Mode**:
   The calculator expects user input, so you need to run the container in interactive mode (`-it`) to enable input through the terminal.

   Use the following command to run the Docker container:

   ```bash
   docker run -it calculator-app
   ```

   This command ensures that the container is interactive and will allow you to input numbers and operations.

### Common Issues

- **NoSuchElementException**: If you encounter this error while running the application inside Docker, it's likely because the container was not started in interactive mode. Ensure that you run the container with the `-it` flag to allow input from the terminal:

  ```bash
  docker run -it calculator-app
  ```

### Docker Cleanup

After running the container, you can stop and remove it. If you want to clean up Docker resources (like unused images or containers), use the following commands:

```bash
# Stop the container
docker stop <container-id>

# Remove the container
docker rm <container-id>

# Remove the image (optional)
docker rmi calculator-app
```

## Usage Example

### Adding New Operations

You can add custom operations by implementing the `GeneralOperations` interface and registering them with the calculator.

For example, to add a **Modulo** operation:

1. Create a `Modulo.java` class:

   ```java
   public class Modulo implements GeneralOperations {
      @Override
      public Number calculateResult(Number a, Number b) {
         return a.intValue() % b.intValue();
      }
   }
   ```

2. Register it in the `Calculator`:

   ```java
   calculator.addnewOperation(Operation.MODULO, new Modulo());
   ```

3. Use the newly added operation:

   ```java
   Number result = calculator.calculate(Operation.MODULO, 10, 3);
   System.out.println("10 % 3 = " + result);  // Output: 1
   ```

## Testing

Unit tests are provided for the `Calculator` class in the `CalculatorTest.java` file. You can run the tests using Maven:

```bash
mvn test
```

The tests cover:

- Basic operations (addition, subtraction, multiplication, division).
- Chain operations.
- Unsupported operation handling (e.g., attempting to divide by zero or use an undefined operation).

## Extending the Calculator

To add new operations:

1. Create a new class that implements the `GeneralOperations` interface.
2. Register the new operation using the `addnewOperation()` method.

This design ensures that new operations can be easily added without modifying the existing code, in line with the Open-Closed Principle.
