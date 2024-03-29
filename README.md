# Math Expression Evaluator

## Usage

### Prerequisites

- Java Development Kit (JDK) installed on your machine.

### Building and Running

1. **Clone this repository to your local machine:**
   ```bash
   git clone https://github.com/aramali0/matheval.git
   ```
2. **Navigate to the cloned directory:**
   ```bash
   cd matheval
   ```
3. **Compile the Java source code:**
   ```bash
   javac MathExpressionEvaluator.java
   ```
4. **Run the application:**
   ```bash
   java MathExpressionEvaluator
   ```
### Input Format
The application prompts you to enter a mathematical expression. You can enter expressions like:

1 + (2 * 3 - 10.5)
sqrt(16) + pow(2, 3)
cos(0) * sin(1.5)
To exit the application, type 'q' and press Enter.

### Implementation Details
The application uses a recursive descent parser approach to parse and evaluate mathematical expressions. It supports arithmetic operators (+, -, *, /) and math functions (cos, acos, sin, asin, tan, atan, sqrt, pow).

### How It Works
Parsing: The input expression is parsed recursively using a parser that handles parentheses, operators, and functions.

Evaluation: After parsing, the expression is evaluated step by step according to mathematical rules and functions.

Error Handling: Malformed expressions are detected and reported as errors, ensuring robustness.

Extensibility: The code is designed to support easy addition of new functions or operators if needed.
### Example
 ```bash
Enter an expression (or 'q' to quit): 1 + (2 * 3 - 10.5)
Expression: 1 + (2 * 3 - 10.5)
Result: -4.5

Enter an expression (or 'q' to quit): sqrt(16) + pow(2, 3)
Expression: sqrt(16) + pow(2, 3)
Result: 10.0

Enter an expression (or 'q' to quit): q
Exiting the program.
```

### Contributing
Contributions are welcome! If you have any suggestions or improvements, please create an issue or submit a pull request.
