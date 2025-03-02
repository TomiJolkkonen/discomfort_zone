import math
import sys

def main():
    try:
        # Take input from command line arguments
        if len(sys.argv) < 2:
            print("Please provide space-separated numbers as arguments.")
            return

        # Convert command line arguments to a list of numbers
        numbers = [float(num) for num in sys.argv[1:]]

        # Calculate minimum and maximum
        min_value = min(numbers)
        max_value = max(numbers)

        # Calculate mean
        mean_value = sum(numbers) / len(numbers)

        # Calculate median
        numbers.sort()
        n = len(numbers)
        if n % 2 == 0:
            median_value = (numbers[n // 2 - 1] + numbers[n // 2]) / 2
        else:
            median_value = numbers[n // 2]

        # Calculate mode
        frequency = {}
        for num in numbers:
            frequency[num] = frequency.get(num, 0) + 1
        max_freq = max(frequency.values())
        mode_value = [key for key, val in frequency.items() if val == max_freq]

        if len(mode_value) == 1:
            mode_value = mode_value[0]
        else:
            mode_value = "No unique mode"

        # Print the results
        print(f"Sum: {sum(numbers)}")
        print(f"Minimum: {min_value}")
        print(f"Maximum: {max_value}")
        print(f"Mean: {mean_value}")
        print(f"Median: {median_value}")
        print(f"Mode: {mode_value}")

    except ValueError:
        print("Invalid input. Please provide valid numbers as arguments.")

if __name__ == "__main__":
    main()
