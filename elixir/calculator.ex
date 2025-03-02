defmodule Calculator do
  # Function to add two numbers
  def add(a, b), do: a + b

  # Function to subtract two numbers
  def subtract(a, b), do: a - b

  # Function to multiply two numbers
  def multiply(a, b), do: a * b

  # Function to divide two numbers
  def divide(a, b) when b != 0, do: a / b
  def divide(_, 0), do: {:error, "Division by zero"}

  # Main function to handle user input and calculations
  def main_loop() do
    IO.puts("Welcome to the Elixir Calculator!")
    IO.puts("Enter an expression (e.g., 2 + 3), or 'quit' to exit:")

    loop()
  end

  defp loop() do
    input = IO.gets(">")
             |> String.trim()

    case input do
      "quit" ->
        IO.puts("Goodbye!")

      _ ->
        case parse_expression(input) do
          {num1, op, num2} ->
            result =
              case op do
                "+" -> add(num1, num2)
                "-" -> subtract(num1, num2)
                "*" -> multiply(num1, num2)
                "/" -> divide(num1, num2)
              end

            IO.puts("Result: #{result}")
          :error ->
            IO.puts("Invalid expression")
        end

        loop()
    end
  end

  defp parse_expression(input) do
    [num1_str, op_str, num2_str] = String.split(input, " ")

    num1 = String.to_float(num1_str)
    num2 = String.to_float(num2_str)

    case {num1, op_str, num2} do
      {n1, op, n2} when is_float(n1) and is_float(n2) -> {n1, op, n2}
      _ -> :error
    end
  end
end

# Start the calculator
Calculator.main_loop()
