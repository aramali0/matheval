import java.util.Scanner;

public class MathExpressionEvaluator {
    private static int index;
    private static String expression;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter an expression (or 'q' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                break; // Exit the loop if user enters 'q'
            }

            input = input.replaceAll("\\s", ""); // Remove all whitespaces
            System.out.println("Expression: " + input);
            double result = evaluate(input);
            if (Double.isNaN(result)) {
                System.out.println("Malformed expression");
            } else {
                System.out.println("Result: " + result);
            }
        }

        System.out.println("Exiting the program.");
        scanner.close();
    }

    public static double evaluate(String exp) {
        expression = exp;
        index = 0;
        double result = evaluateExpression();
        if (index != expression.length()) {
            return Double.NaN; // Malformed expression
        }
        return result;
    }

    private static double evaluateExpression() {
        double term = parseTerm();
        while (index < expression.length()) {
            char operator = expression.charAt(index);
            if (operator != '+' && operator != '-') {
                break;
            }
            index++;
            double nextTerm = parseTerm();
            if (operator == '+') {
                term += nextTerm;
            } else {
                term -= nextTerm;
            }
        }
        return term;
    }

    private static double parseTerm() {
        double factor = parseFactor();
        while (index < expression.length()) {
            char operator = expression.charAt(index);
            if (operator != '*' && operator != '/') {
                break;
            }
            index++;
            double nextFactor = parseFactor();
            if (operator == '*') {
                factor *= nextFactor;
            } else {
                factor /= nextFactor;
            }
        }
        return factor;
    }

    private static double parseFactor() {
        double value;
        int startPos = index;
        if (expression.charAt(index) == '(') {
            index++;
            value = evaluateExpression();
            if (expression.charAt(index) != ')') {
                return Double.NaN; // Malformed expression
            }
            index++;
        } else {
            while (index < expression.length() && (Character.isDigit(expression.charAt(index)) || expression.charAt(index) == '.')) {
                index++;
            }
            if (index > startPos) {
                value = Double.parseDouble(expression.substring(startPos, index));
            } else {
                value = parseFunction();
            }
        }
        return value;
    }

    private static double parseFunction() {
        int startPos = index;
        while (index < expression.length() && Character.isLetter(expression.charAt(index))) {
            index++;
        }
        String function = expression.substring(startPos, index);
        if (index < expression.length() && expression.charAt(index) == '(') {
            index++;
            double argument = evaluateExpression();
            if (expression.charAt(index) != ')') {
                return Double.NaN; // Malformed expression
            }
            index++;
            return switch (function) {
                case "cos" -> Math.cos(argument);
                case "acos" -> Math.acos(argument);
                case "sin" -> Math.sin(argument);
                case "asin" -> Math.asin(argument);
                case "tan" -> Math.tan(argument);
                case "atan" -> Math.atan(argument);
                case "sqrt" -> Math.sqrt(argument);
                case "pow" -> Math.pow(argument, parseFactor());
                default -> Double.NaN; // Unknown function
            };
        } else {
            return Double.NaN; // Malformed expression
        }
    }
}
