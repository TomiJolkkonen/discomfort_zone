def play_quiz():
    print("Welcome to the Quiz Game!")
    play = input("Do you want to play a quiz? (yes/no): ").strip().lower()

    if play != "yes":
        print("Okay, maybe next time. Goodbye!")
        return

    print("Great! Let's get started!")

    # List of questions and answers
    questions = [
        ("What is 5 + 3?", 8),
        ("What is 7 - 2?", 5),
        ("What is 4 * 2?", 8)
    ]

    correct_answers = 0

    # Loop through the questions
    for question, answer in questions:
        while True:
            try:
                user_answer = int(input(f"{question} "))
                break
            except ValueError:
                print("Please enter a valid number.")

        if user_answer == answer:
            print("Correct!")
            correct_answers += 1
        else:
            print(f"Wrong! The correct answer was {answer}.")

    print(f"You got {correct_answers} out of {len(questions)} questions right.")
    print("Thank you for playing! Goodbye!")

# Start the quiz
def main():
    play_quiz()

if __name__ == "__main__":
    main()