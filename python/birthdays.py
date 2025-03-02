# @Tomi Jolkkonen

from datetime import datetime


def user_input(): # function for usr inputs
    
    names_birthdays = []

    while True:
        name = input("Enter person's first and last name with space, e.g. 'Jack Niklaus': ").strip() # if usr puts white spaces, strip it away
        birthday = input("Enter birthday in the form of dd.mm.yyyy, e.g. '23.08.2001': ").strip()
        
        try:
            birthday_date = datetime.strptime(birthday, "%d.%m.%Y") # parse birthday into datetime object, in finnish form dd.mm.yyyy
            names_birthdays.append((name, birthday_date)) ## tuples to the list
        except ValueError:
            print("Invalid birthday. Please enter the birthday in the form of dd.mm.yyyy , e.g. '25.12.1978'.") # if usr enters bd in wrong format
            continue
        
        more = input("Add another user? (yes/no): ").strip().lower() ## if usr uses caps, strip it away
        if more != 'yes':
            break
    
    return names_birthdays
    

def oldest_youngest(names_birthdays):  # function for sorting
    for i in range(len(names_birthdays)):
        for j in range(i + 1, len(names_birthdays)):
            if names_birthdays[i][1] > names_birthdays[j][1]:  # compare bds in the 2nd index of tuples
                names_birthdays[i], names_birthdays[j] = names_birthdays[j], names_birthdays[i]  # change if 1st one is older
    oldest = names_birthdays[0]  # first one is oldest
    youngest = names_birthdays[-1]  # last one is youngest
    
    return oldest, youngest   
    

if __name__ == "__main__":

    print("Birthday sorting machine")
    print("Insert names and birthdays of the people, and it will print out the oldest & youngest ones.")
    
    unsorted_list_of_names_birthdays = user_input()
    
    if len(unsorted_list_of_names_birthdays) < 2:

      print("You need to have at least 2 persons in the database in order to sort out oldest & youngest ones. Try again!")
    
    oldest, youngest = oldest_youngest(unsorted_list_of_names_birthdays)
    
    print("Database results:")
    print(f"The oldest person in the birthday database is: {oldest[0]}, born {oldest[1].strftime('%d.%m.%Y')}") # change datetime to string
    print(f"...and the youngest one is: {youngest[0]}, born {youngest[1].strftime('%d.%m.%Y')}")
    print("Thank you for using birthday sorting machine. Closing..")
