#include <iostream>
#include <string>
#include <sstream>

using namespace std;

// Function declarations
double add(double a, double b);
double subtract(double a, double b);
double multiply(double a, double b);
double divide(double a, double b);

int main() {
    cout << "Welcome to the C++ Calculator!" << endl;
    cout << "Enter an expression (e.g., 2 + 3), or 'quit' to exit: " << endl;

    string input;
    while (true) {
        cout << "> ";
        getline(cin, input);

        if (input == "quit") {
            cout << "Goodbye!" << endl;
            break;
        }

        stringstream ss(input);
        double num1, num2;
        char op;
        ss >> num1 >> op >> num2;

        double result;
        switch (op) {
            case '+':
                result = add(num1, num2);
                break;
            case '-':
                result = subtract(num1, num2);
                break;
            case '*':
                result = multiply(num1, num2);
                break;
            case '/':
                result = divide(num1, num2);
                break;
            default:
                cout << "Invalid expression" << endl;
                continue; // Continue to the next iteration of the loop
        }

        cout << "Result: " << result << endl;
    }

    return 0;
}

// Function definitions
double add(double a, double b) {
    return a + b;
}

double subtract(double a, double b) {
    return a - b;
}

double multiply(double a, double b) {
    return a * b;
}

double divide(double a, double b) {
    if (b == 0) {
        cout << "Error: Division by zero" << endl;
        return 0;
    }
    return a / b;
}
