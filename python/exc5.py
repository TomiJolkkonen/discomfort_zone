def organize_words(input_file, output_file):
    try:
        # Read words from the file
        with open(input_file, "r") as file:
            words = file.read().splitlines()

        # Organize words by length and then alphabetically for equal lengths
        sorted_words = sorted(words, key=lambda word: (len(word), word))

        # Write the ordered words to the output file
        with open(output_file, "w") as file:
            for word in sorted_words:
                file.write(word + "\n")

        print(f"Words have been organized and written to {output_file}.")

    except Exception as e:
        print(f"An error occurred: {e}")

# Specify input and output file paths
input_file = "input.txt"
output_file = "output.txt"

# Call the function
organize_words(input_file, output_file)
