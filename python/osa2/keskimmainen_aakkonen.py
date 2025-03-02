kirjain1 = input("Anna 1. kirjain: ")
kirjain2 = input("Anna 2. kirjain: ")
kirjain3 = input("Anna 3. kirjain: ")

# Laitetaan kirjaimet listaan ja järjestetään
kirjaimet = sorted([kirjain1, kirjain2, kirjain3])

# Keskimmäinen kirjain on järjestetyn listan keskimmäinen alkio
print(f"Keskimmäinen kirjain on {kirjaimet[1]}")
