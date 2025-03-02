package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

// Function to add two numbers
func add(a, b float64) float64 {
	return a + b
}

// Function to subtract two numbers
func subtract(a, b float64) float64 {
	return a - b
}

// Function to multiply two numbers
func multiply(a, b float64) float64 {
	return a * b
}

// Function to divide two numbers
func divide(a, b float64) float64 {
	if b == 0 {
		fmt.Println("Error: Division by zero")
		return 0
	}
	return a / b
}

func main() {
	fmt.Println("Welcome to the Go Calculator!")
	fmt.Println("Enter an expression (e.g., 2 + 3), or 'quit' to exit:")

	reader := bufio.NewReader(os.Stdin)

	for {
		fmt.Print("> ")
		input, err := reader.ReadString('\n')
		if err != nil {
			fmt.Println("Error reading input:", err)
			continue
		}

		// Remove newline character
		input = strings.TrimSpace(input)

		if input == "quit" {
			fmt.Println("Goodbye!")
			break
		}

		tokens := strings.Split(input, " ")
		if len(tokens) != 3 {
			fmt.Println("Invalid expression")
			continue
		}

		num1, err := strconv.ParseFloat(tokens[0], 64)
		if err != nil {
			fmt.Println("Invalid number:", tokens[0])
			continue
		}

		num2, err := strconv.ParseFloat(tokens[2], 64)
		if err != nil {
			fmt.Println("Invalid number:", tokens[2])
			continue
		}

		var result float64
		switch tokens[1] {
		case "+":
			result = add(num1, num2)
		case "-":
			result = subtract(num1, num2)
		case "*":
			result = multiply(num1, num2)
		case "/":
			result = divide(num1, num2)
		default:
			fmt.Println("Invalid operator:", tokens[1])
			continue
		}

		fmt.Println("Result:", result)
	}
}
