import collections
import os

def analyze_book():
    # Get the absolute path to the book file
    base_dir = os.path.dirname(os.path.abspath(__file__))
    file_path = os.path.join(base_dir, 'books', 'my_small_book.txt')

    print("============ BOOKBOT ============")
    print(f"Analyzing book found at {file_path}...")

    try:
        with open(file_path, 'r', encoding='utf-8') as file:
            text = file.read().lower()
    except FileNotFoundError:
        print("Error: Book file not found.")
        return

    # Word count
    words = text.split()
    total_words = len(words)

    print("----------- Word Count ----------")
    print(f"Found {total_words} total words")

    # Character count (letters only)
    char_counter = collections.Counter(c for c in text if c.isalpha())
    sorted_chars = dict(sorted(char_counter.items(), key=lambda item: (-item[1], item[0])))

    print("--------- Character Count -------")
    for char, count in sorted_chars.items():
        print(f"{char}: {count}")

    print("============= END ===============")


if __name__ == "__main__":
    analyze_book()
